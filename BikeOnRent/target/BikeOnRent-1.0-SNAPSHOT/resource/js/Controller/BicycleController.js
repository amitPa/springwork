/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

userApp.controller('bicycleController', ['$scope', '$location', 'authService','$localStorage', '$sessionStorage', function ($scope, $location, authService,$localStorage, $sessionStorage) {

        $scope.bicycles = {};
        $scope.bookResult = null;
        $scope.dialogHidden = false;
        $scope.formHidden = false;
        $scope.bookBicycle = {
            bicycleBookingType: 'perhour'
            , bicyleCost: 0
            , biclycleDayNumber: 0
            , bicycleHourNumber: 0
            , bicycleId: ""
            , bicyclePickUpTime: null
        };
        $scope.initial = {
            bicycleBookingType: 'perhour'
            , bicyleCost: 0
            , biclycleDayNumber: 0
            , bicycleHourNumber: 0
            , bicycleId: ""
            , bicyclePickUpTime: null
        };
        $scope.bookBicycle.bicycleBookingType = 'perhour';


        $scope.$watch('bookBicycle.bicycleBookingType', function (value) {
            $scope.bookBicycle.bicyleCost = 0;
            $scope.bookBicycle.daySelected = 0;
            $scope.bookBicycle.bicycleHourNumber = 0;
        });

        $scope.hoursSelected = function () {
            $scope.bookBicycle.bicycleId = $scope.bicyleDetail.bicyleId;
            $scope.bookBicycle.daySelected = 0;
            $scope.bookBicycle.bicyleCost = 0;
            if ($scope.bookBicycle.bicycleHourNumber != "")
                $scope.bookBicycle.bicyleCost = $scope.bicyleDetail.bicyclePricePerHour * $scope.bookBicycle.bicycleHourNumber;
            else
                $scope.bookBicycle.cost = 0;
        };

        $scope.daysSelected = function () {
            $scope.bookBicycle.bicycleId = $scope.bicyleDetail.bicyleId;
            $scope.bookBicycle.bicycleHourNumber = 0;
            $scope.bookBicycle.bicyleCost = 0;
            if ($scope.bookBicycle.bicyclePricePerDay != "")
                $scope.bookBicycle.bicyleCost = $scope.bicyleDetail.bicyclePricePerDay * $scope.bookBicycle.biclycleDayNumber;
            else
                $scope.bookBicycle.bicyleCost = 0;
        };

        $scope.fetchBicycles = function () {
            console.log($localStorage.user);
            var getResp = authService.PushPullData('GET', '/BikeOnRent/fetchBicycles', '');
            getResp.then(function mySuccess(response) {
                $scope.bicycles = response.data;
            }, function myError(response) {
                $scope.bicycles = response.statusText;
            }).finally(function(){
                $scope.users=$localStorage.user;
            });
        };
        
//        $scope.getUser = function () {
//            var getUserResp=authService.PushPullData('GET', '/BikeOnRent/getUser', '');
//            getUserResp.then(function (response){
//                $localStorage.user=response.data;
//                console.log($localStorage);
//            },function (response){
//                $localStorage.user="inavlid user";
//            }).finally(function(){
//                $localStorage.$reset();
//                console.log($localStorage);
//            });
//            
//           
//        };
        
        $scope.submitBooking = function () {
            $scope.bookBicycle.bicyclePickUpTime = $("#datetimepicker1").data('date');
            var subReq = authService.PushPullData('POST', '/BikeOnRent/booking', $scope.bookBicycle);
            subReq.then(function success(response) {
                $scope.bookResult = response.data;
                if ($scope.bookResult.booked == "false") {
                    return false;
                }
                playSound('Unique');
                $location.path('booking');
            }, function error(response) {
                alert(response);
            });
        };

        $scope.playSound = function (filename) {
            document.getElementById("sound").innerHTML = '<audio autoplay="autoplay"><source src="/BikeOnRent/audio/' + filename + '.mp3" type="audio/mpeg" /><source src="' + filename + '.ogg" type="audio/ogg" /><embed hidden="true" autostart="true" loop="false" src="/BikeOnRent/audio/' + filename + '.mp3" /></audio>';
        };

        $scope.hideDialog = function (bicycle) {
            $scope.formHidden = !$scope.formHidden;
            $scope.bicyleDetail = angular.copy(bicycle);
            $scope.bookBicycle.bicycleId = $scope.bicyleDetail.bicyleId;

            $(function () {
                $('#datetimepicker1').datetimepicker({
                    format: 'YYYY-MM-DD HH:mm',
                    minDate: new Date(),
                    maxDate: new Date(new Date().getTime() + (30 * 24 * 60 * 60 * 1000)),
                    ignoreReadonly: true,
                    toolbarPlacement: 'top',
                    showClose: true
                });
            });

            $scope.bookBicycle = angular.copy($scope.initial);
            $('#bookBicycle').trigger("reset");


        };
    }]);
