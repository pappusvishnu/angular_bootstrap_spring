app.controller('MainController', function ($scope, $rootScope, $location, AuthenticationService) {
	$scope.logout = function () {
		$scope.$emit('event:logoutRequest');
		
        AuthenticationService.logout().then(function() {
        	$rootScope.user = null;
            $scope.username = $scope.password = null;
            $location.path('/main');
            
            console.debug("Logout Completed.");
        });
    };
});

app.controller('CustomerController', function ($scope, CustomerService) {
	$scope.init = function() {
        CustomerService.getCustomers().then(function(response) {
            $scope.customers = response;
        });
	};

    $scope.delete = function(id) {
        CustomerService.deleteCustomer(id).then(function(response) {

            angular.forEach($scope.customers, function(customer, index) {
                if(id == customer.id) {
                    $scope.customers.splice(index, 1);
                }
            });

            console.debug("Customers " + id + " Has Been Deleted");
        });
    };

    $scope.save = function(id) {

        angular.forEach($scope.customers, function(customer, index) {
            if(id == customer.id) {
                console.debug(customer.firstName);
            }
        });
    };
});

app.controller('LoginController', function($scope, $location) {
	$scope.login = function () {
		$scope.$emit('event:loginRequest', $scope.username, $scope.password);
		$location.path(originalLocation);
		
		console.debug("Login event requested.");
    };
});