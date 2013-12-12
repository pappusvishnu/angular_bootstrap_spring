app.config(function($routeProvider) {
	$routeProvider
		.when('/main', {
			title: 'Main',
			templateUrl: 'resources/html/partials/main.html'
		})
		.when('/customer/search', {
			title: 'Customer Search',
			controller: 'CustomerController',
			templateUrl: 'resources/html/partials/customer_search.html'
		})
		.otherwise({ title: 'Customer Library', redirectTo : "/main"});
});

app.run(['$location', '$rootScope', function($location, $rootScope) {
    $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
    	$rootScope.title = (current.$$route === undefined) ? "" : current.$$route.title;
    });
}]);