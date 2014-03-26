package au.com.example.persistence.dao;

import au.com.example.exception.UpdateDeleteException;
import au.com.example.persistence.dao.query.QueryParameter;
import au.com.example.persistence.dao.query.QueryString;
import au.com.example.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseDao {
	private static Logger log = LoggerFactory.getLogger(BaseDao.class);

	@PersistenceUnit
	private EntityManagerFactory emf;

	// === Getters & Setters ===

	protected EntityManagerFactory getEmf() {
		return emf;
	}

	// === Methods ===

    @SuppressWarnings("unchecked")
	protected <T extends Cloneable> T loadDataSingle(Class<T> oType, QueryString queryString) {
		EntityManager entityManager = emf.createEntityManager();

		T data = null;

		try {
			Query query = entityManager.createQuery(queryString.getStatement());

			for (QueryParameter parameter : queryString.getParameters()) {
				query.setParameter(parameter.getName(), parameter.getValue());
			}

			T result = (T) query.getSingleResult();

			if (result != null) {
				data = CopyUtil.clone(result);
			}
		} catch (NoResultException nre) {
			log.warn("No results found: " + nre.getMessage());
		} finally {
			entityManager.close();
		}

		return data;
	}

	@SuppressWarnings("unchecked")
	protected <T extends Cloneable> Collection<T> loadData(Class<T> oType, QueryString queryString) {
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery(queryString.getStatement());

			for (QueryParameter parameter : queryString.getParameters()) {
				query.setParameter(parameter.getName(), parameter.getValue());
			}

			List<T> data = new ArrayList<T>();

			Collection<T> resultList = query.getResultList();
			if (resultList != null) {
				for (T element : resultList) {
					// clone (lazy load collections and detach objects)
					data.add(CopyUtil.clone(element));
				}
			}

			return data;
		} finally {
			em.close();
		}
	}

	protected int updateDeleteDataSingle(QueryString queryString) throws UpdateDeleteException {
		EntityManager entityManager = emf.createEntityManager();

		int rowsModified = 0;

		try {
			EntityTransaction tx = null;

			try {
				tx = entityManager.getTransaction();

				tx.begin();

				Query query = entityManager.createQuery(queryString.getStatement());

				for (QueryParameter parameter : queryString.getParameters()) {
					query.setParameter(parameter.getName(), parameter.getValue());
				}

				rowsModified = query.executeUpdate();

				tx.commit();
			} catch (Exception e) {
				log.error("Exception during update or delete query: " + e.getMessage());

				throw new UpdateDeleteException(e.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
			}
		} finally {
			entityManager.close();
		}

		return rowsModified;
	}

    protected <T extends Cloneable> boolean deleteSingleData(Class<T> oType, Long id) throws UpdateDeleteException {
        EntityManager entityManager = getEmf().createEntityManager();

        try	{
            EntityTransaction tx = null;

            try {
                tx = entityManager.getTransaction();

                tx.begin();

                entityManager.remove(entityManager.find(oType, id));

                tx.commit();
            }
            catch (Exception e) {
                log.error("Exception during deleting " + id + ": " + e.getMessage());

                throw new UpdateDeleteException("Unable to delete data " + id, e);
            }
            finally	{
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }
            }
        }
        finally	{
            entityManager.close();
        }

        return true;
    }
}
