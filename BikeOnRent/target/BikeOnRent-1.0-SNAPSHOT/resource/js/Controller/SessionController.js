/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


userApp.controller('sessionController', ['$scope', '$location', 'authService', '$localStorage', '$sessionStorage', function ($scope, $location, authService, $localStorage, $sessionStorage) {

        $scope.user = $localStorage.user;
        
        $scope.setUserValue = function () {
            $scope.user = $localStorage.user;
        };
        $scope.getUser = function () {
            var getUserResp = authService.PushPullData('GET', '/BikeOnRent/getUser', '');
            getUserResp.then(function (response) {
                $localStorage.user = response.data;
                $scope.user = response.data;
                console.log($localStorage);
            }, function (response) {
                $localStorage.user = "inavlid user";
            }).finally(function () {
                $scope.user = $localStorage.user;
                //$localStorage.$reset();
            });
        };

        $scope.logout = function () {
            var getlogoutResp = authService.PushPullData('GET', '/BikeOnRent/logout', '');
            getlogoutResp.then(function (response) {
                delete $localStorage.user;
                $localStorage.$reset();
                window.location.href = '/BikeOnRent/';
                console.log($localStorage);
            }, function (response) {
                $localStorage.user = "inavlid user";
            });
        };

    }]);