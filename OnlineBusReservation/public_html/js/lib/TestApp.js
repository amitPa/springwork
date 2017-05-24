/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module('app', []);

app.controller('SeatSelectionController', function ($scope) {

    $scope.bookedSeats = ['A1', 'A2', 'C4', 'C3'];
    $scope.seatSelection = [];

    $scope.rowapha = ['A', 'B'];
    $scope.rowapha2=['C', 'D'];
    $scope.available="resources/images/available_seat_img.gif";
    $scope.selected="resources/images/selected_seat_img.gif";
    $scope.imag = [{
        'available': "resources/images/available_seat_img.gif",
        'selected': "resources/images/selected_seat_img.gif"
    }];
    $scope.imag = "resources/images/available_seat_img.gif";
    var rowcount = [];
    for (var i = 0; i < 4; i++) {
        rowcount.push(i);
    }

    $scope.seatselection = function (row, col) {
        var index = $scope.seatSelection.indexOf(row + col);
        if (index >= 0)
            $scope.seatSelection.splice(index, 1);
        else
            $scope.seatSelection.push(row + col);
        //$scope.imag = $scope.imag == "resources/images/available_seat_img.gif" ? "resources/images/selected_seat_img.gif" : "resources/images/available_seat_img.gif";
    };
    
    $scope.showBookedSteats = function(){
        alert($scope.bookedSeats);
    }
    
    $scope.getUrl=function(row,col) {
       
        if ($scope.bookedSeats.indexOf(row + col) >= 0)
            return "resources/images/booked_seat_img.gif";
      
        if ($scope.seatSelection.indexOf(row + col) >= 0)
            return "resources/images/selected_seat_img.gif";
        else
            return "resources/images/available_seat_img.gif"; 
        
    }
    
    $scope.rows = rowcount;

    var colcount = [];
    for (var i = 1; i <= 10; i++) {
        colcount.push(i);
    }
    $scope.cols = colcount;
});

