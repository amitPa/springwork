/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


userApp.controller('profileController', ['$scope', '$location', 'authService', '$localStorage', '$sessionStorage', function ($scope, $location, authService, $localStorage, $sessionStorage) {

        $scope.user = $localStorage.user;
        $scope.message = "";
        $scope.profile = false;
        $scope.password = true;
        $scope.names = true;
        $scope.emails = true;
        $scope.phones = true;
        $scope.classPassword = "";
        $scope.classEditProfile = "active";
        $scope.formPassword = {};



        $scope.slideScreen = function () {
            if ($scope.classEditProfile == "active") {
                $scope.classEditProfile = "";
                $scope.classPassword = "active";
            } else {
                $scope.classEditProfile = "active";
                $scope.classPassword = "";
            }
            $scope.message = "";
            $scope.profile = !$scope.profile;
            $scope.password = !$scope.password;
            $scope.formPassword = {};
        };

        $scope.submitChangePassword = function (password, confirmPassword) {
            var data = "?password=" + password + "&confirmPassword=" + confirmPassword;
            var updateChangePassword = authService.PushPullData('POST', '/BikeOnRent/updateChangePassword' + data, '');
            updateChangePassword.then(function mySuccess(response) {
                if (response.data.respon == false) {
                    $scope.message = "Password Entered is Incorrect";
                    return false;
                }
                $scope.message = "";
                $scope.formPassword = {};
                $scope.slideScreen();
                $scope.reset();
            }, function myError(response) {
            }).finally(function () {
            });

        };

        $scope.save = function (field, value) {
            var data = "?field=" + field + "&value=" + value;
            var updateProfile;
            switch (field) {
                case 'name':
                    updateProfile = authService.PushPullData('POST', '/BikeOnRent/updateProfile' + data, '');
                    break;
                case 'email':
                    updateProfile = authService.PushPullData('POST', '/BikeOnRent/updateProfile' + data, '');
                    break;
                case 'contact':
                    updateProfile = authService.PushPullData('POST', '/BikeOnRent/updateProfile' + data, '');
                    break;
            }
            $scope.phones = true;
            $scope.emails = true;
            $scope.names = true;
            updateProfile.then(function mySuccess(response) {
            }, function myError(response) {
            }).finally(function () {
            });
        };
        
        $scope.uploadFile=function(){
            
        };
    }]);


