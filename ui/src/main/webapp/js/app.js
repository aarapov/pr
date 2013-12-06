'use strict';

angular.module('app', ['app.services', 'app.directives']).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/main', {templateUrl : 'partials/main.html', controller: MainController}).
            when('/teacher', {templateUrl : 'partials/teacher.html'}).
            when('/projects', {templateUrl : 'partials/projects.html'}).
            when('/events', {templateUrl : 'partials/events.html'}).
            when('/webcast', {templateUrl : 'partials/webcast.html'}).
            when('/registration', {templateUrl : 'partials/registration.html', controller: RegistrationCtrl}).
            when('/accommodation', {templateUrl: 'partials/accommodation.html'}).
            otherwise({redirectTo: '/main'});
    }]);