/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


postApp.controller('postController', ['$scope','$location' ,'authService','$localStorage', '$sessionStorage', function ($scope, $location ,authService,$localStorage, $sessionStorage) {
        $scope.inputType = 'password';
        $scope.visibilty = true;
        $scope.isError = false;
        $scope.successMail = false;
        $scope.failMail = false;
        $scope.userAdded = false;
        $scope.userFailed = false;
        $scope.signUp = true;
        $scope.User = {};

        // Hide & show password function
        $scope.hideShowPassword = function () {
            if ($scope.inputType == 'password')
                $scope.inputType = 'text';
            else
                $scope.inputType = 'password';
        };

        $scope.cardSelect = function () {
            $scope.visibilty = !$scope.visibilty;
        };

        $scope.submitForgotEmail = function () {
            var getResp = authService.PushPullData('POST', '/BikeOnRent/forgotPassword', $scope.User.userEmail);
            getResp.success(function (data) {
                if (angular.equals("success", data)) {
                    // Showing errors.
                    $scope.successMail = true;
                    $scope.failMail = false;
                } else {
                    $scope.successMail = false;
                    $scope.failMail = true;
                }
            });
        }

        $scope.submitUser = function () {

            var getResp = authService.PushPullData('POST', '/BikeOnRent/addUser', $scope.User);
            getResp.success(function (data) {
                if (angular.equals("success", data)) {
                    $scope.userAdded = true;
                    $scope.signUp = false;
                    $scope.userFailed = false;
                } else {
                    $scope.userFailed = true;
                    $scope.signUp = true;
                    $scope.userAdded = false;
                }
            });
        };

        $scope.checkUser = function () {
            var getResp = authService.PushPullData('POST', '/BikeOnRent/checkUser', $scope.User);
//            getResp.success(function (data) {
//                if (angular.equals("failure", data)) {
//                    // Showing errors.
//                    $scope.userAdded = true;
//                    $scope.signUp = false;
//                    $scope.userFailed = false;
//                } else {
//                    $scope.userFailed = true;
//                    $scope.signUp = true;
//                    $scope.userAdded = false;
//                    window.location.href='#home';
//                }
//            });
            
             getResp.then(function mySuccess(response) {
                $localStorage.user = response.data;
                window.location.href='/BikeOnRent/checkSession';
               var getRespon = authService.PushPullData('GET', '/BikeOnRent/user', '');
            }, function myError(response) {
                $localStorage.user = response.statusText;
            });
        };
    }]);

