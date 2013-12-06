angular.module('app.directives', [])
    .directive('numberRestriction', [ function() {
    var regexp = new RegExp('^((\\d+(\\.\\d+)?)|(\\.\\d+))$');

    return {
        restrict : 'A',
        require: 'ngModel',
        link : function(scope, elm, attrs, ctrl) {
            var validator = function (viewValue) {
                var valid = true;
                if (viewValue) {
                    valid = regexp.test(viewValue);
                    if (valid && attrs.forbidZero && scope.$eval(attrs.forbidZero) && parseFloat(viewValue) === 0) {
                        valid = false;
                    }
                }
                ctrl.$setValidity('format', valid);
                return valid ? parseFloat(viewValue) : undefined;
            };

            ctrl.$formatters.push(validator);
            ctrl.$parsers.unshift(validator);
        }
    };
} ]);