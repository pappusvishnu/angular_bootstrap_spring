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

            console.debug("Customers Retrieved");
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

    $scope.edit = function(id) {
        $scope.$evalAsync(function() {
            isEditButtonVisible(id, false);
        });
    };

    $scope.save = function(id) {
        $scope.$evalAsync(function() {
            isEditButtonVisible(id, true);
        });
    };

    $scope.cancel = function(id) {
        $scope.$evalAsync(function() {
            isEditButtonVisible(id, true);
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