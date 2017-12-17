'use strict';
var airportManagerApp = angular.module('airportManagerApp', ['ngRoute', 'managerControllers']);
var managerControllers = angular.module('managerControllers', []);

/* Configures URL fragment routing  */
airportManagerApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/main', {
                templateUrl: 'partials/main.html',
                controller: "MainCtrl"
            })
            .when('/flights', {
                templateUrl: 'partials//flight/flights.html',
                controller: 'FlightsCtrl'
            })
            .when('/flight/:flightId', {
                templateUrl: 'partials/flight/flight_detail.html',
                controller: 'FlightDetailCtrl'
            })
            .when('/newflight', {
                templateUrl: 'partials/flight/new_flight.html',
                controller: 'NewFlightCtrl'
            })
            .otherwise({redirectTo: '/main'});
    }
]);


/*
 * alert closing functions defined in root scope to be available in every template
 */
airportManagerApp.run(function ($rootScope) {
    $rootScope.hideSuccessAlert = function () {
        $rootScope.successAlert = undefined;
    };
    $rootScope.hideWarningAlert = function () {
        $rootScope.warningAlert = undefined;
    };
    $rootScope.hideErrorAlert = function () {
        $rootScope.errorAlert = undefined;
    };
});

/* Controllers */
managerControllers.controller('MainCtrl', function () {

});


managerControllers.controller('FlightsCtrl',
    function ($scope, $rootScope, $routeParams, $http) {
        $http.get('/pa165/api/flights').then(function (response) {
            $scope.flights = response.data._embedded.flights
        })
    }
);

managerControllers.controller('FlightDetailCtrl',
    function ($scope, $routeParams, $http) {
        var flightId = $routeParams.flightId;
        $http.get('/pa165/api/flights/' + flightId).then(function (response) {
            var flight = response.data;
            $scope.flight = flight;

        });
    }
);

managerControllers.controller('NewFlightCtrl',
    function ($scope, $routeParams, $http, $location, $rootScope) {
        $scope.flight = {
            'departureLocationId': '',
            'arrivalLocationId': '',
            'departureTime': '',
            'arrivalTime': '',
            'airplaneId': '',
            'stewardsIds': []
        };
    }
);

// defines new directive (HTML attribute "convert-to-int") for conversion between string and int
// of the value of a selection list in a form
// without this, the value of the selected option is always a string, not an integer
managerControllers.directive('convertToInt', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            ngModel.$parsers.push(function (val) {
                return parseInt(val, 10);
            });
            ngModel.$formatters.push(function (val) {
                return '' + val;
            });
        }
    };
});
