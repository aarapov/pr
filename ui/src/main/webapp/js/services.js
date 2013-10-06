angular.module('app.services', ['ngResource'])
/*    .config(function($httpProvider){
        $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8'
    })*/
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