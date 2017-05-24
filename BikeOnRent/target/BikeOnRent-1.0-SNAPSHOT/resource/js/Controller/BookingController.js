/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


userApp.controller('bookingController', ['$scope', '$location', 'authService', function ($scope, $location, authService) {

        $scope.bookings = {};
        $scope.bookDetail = {};
        $scope.indexing=null;
        $scope.formHidden=false;
        $scope.fetchBookings = function () {

            var getResp = authService.PushPullData('GET', '/BikeOnRent/fetchBooking', '');
            getResp.then(function mySuccess(response) {
                $scope.bookings = response.data;
            }, function myError(response) {
                $scope.bookings = response.statusText;
            });
            $scope.formHidden=false;
        };
        
        $scope.submitCancel = function(book,index){
             var subCancel = authService.PushPullData('POST', '/BikeOnRent/cancelBooking', book.id);
             $scope.hideDialog({},'');
             subCancel.then(function mySuccess(response){
                 $scope.fetchBookings();
             }, function myError(response) {
                $scope.bookings = response.statusText;
            });
        };
        

        $scope.hideDialog = function (book,index) {
            console.log(book);
            $scope.bookDetail = book;
            $scope.indexing=index;
            $scope.formHidden = !$scope.formHidden;
        };
    }]);