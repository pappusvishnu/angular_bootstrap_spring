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
		getCustomers();
	};
	
	getCustomers = function() {
		CustomerService.getCustomers().then(function(response) {
			$scope.customers = response;
			
			console.debug("Customers Retrieved");
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