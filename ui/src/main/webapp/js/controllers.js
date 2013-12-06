'use strict';

/* Controllers */

function MainController($scope) {
    console.log('MainController');
    $('.carousel').carousel();
}

MainController.$inject = ['$scope'];

function AboutController($scope) {
}
AboutController.$inject = ['$scope'];

var RegistrationCtrl = function ($scope, AccommodationService, RegistrationService, $http) {
    'use strict';

    $scope.participant = {};
    $scope.isRegistered = false;
    $scope.isError = false;

    console.log(encodeURIComponent("тили тили трали вали"));

    AccommodationService.accommodation(function(response) {
        $scope.accommodationList = response;
        console.log('accommodationList', $scope.accommodationList);
    });

    $scope.save = function() {
        $scope.participant.firstName = encodeURIComponent($scope.firstName);
        $scope.participant.lastName = encodeURIComponent($scope.lastName);
        $scope.participant.city = encodeURIComponent($scope.city);
        $scope.participant.notes = encodeURIComponent($scope.notes);

        RegistrationService.save({}, $scope.participant,
            function(response) {
                $scope.isError = false;
                $scope.isRegistered = true;
            },
            function() {
                $scope.isError = true;
            });
    };

    $scope.clear = function() {
        $scope.firstName = "";
        $scope.lastName = "";
        $scope.city = "";
        $scope.notes = "";
        $scope.participant = {};
    };
}
RegistrationCtrl.$inject = ['$scope', 'AccommodationService', 'RegistrationService', '$http'];