app.controller('CustomerController', function ($scope, CustomerService) {
	$scope.init = function() {
		getCustomers();
	};
	
	$scope.saveCustomer = function() {
		// TODO: get customer from scope
		
		// reload the customers
		getCustomers();
	};
	
	$scope.deleteCustomer = function(id) {
		
		// reload the customers
		getCustomers();
	};
	
	getCustomers = function() {
		CustomerService.getCustomers().then(function(response) {
			$scope.customers = response;
			
			console.debug("Customers Retrieved");
		});
	};
});