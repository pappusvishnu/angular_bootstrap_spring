app.service('CustomerService', function($http, $q){
	this.getCustomers = function() {
		var d = $q.defer();
		
		$http.get('customer/customers/retrieve').success(function(response) {
			d.resolve(response);
		});
		
		return d.promise;
	};
});