angular.module('site', ['ui', 'ui.bootstrap', 'ui.directives']).
	config(['$routeProvider', function($routeProvider) {
		$routeProvider.
			when('/main', {templateUrl : 'partials/main.html', controller: MainController}).
			when('/teacher', {templateUrl : 'partials/teacher.html'}).
			when('/projects', {templateUrl : 'partials/projects.html'}).
			when('/events', {templateUrl : 'partials/events.html'}).
			when('/registration', {templateUrl : 'partials/registration.html'}).
			otherwise({redirectTo: '/main'});
	}]);