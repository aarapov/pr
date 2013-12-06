angular.module('app.services', ['ngResource'])
    .factory('AccommodationService', ['$resource',
        function($resource) {
            return $resource('/backend/registration/accommodation', {}, {
                accommodation : {
                    method : 'GET',
                    isArray : true
                }
            });
        }
    ])
    .factory('RegistrationService', ['$resource',
        function($resource) {
            return $resource('/backend/registration/save', {}, {
                save : {
                    method : 'POST',
                    isArray:false
                }
            });
        }
    ]);