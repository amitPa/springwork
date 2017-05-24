/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var eventsApp=angular.module('eventsApp',[]);

eventsApp.controller('SeatSelectionController',function($scope){
    
    $scope.settings={
        'rows':5,
        'cols':15,
        'rowCssPrefix': 'row-',
        'colCssPrefix': 'col-',
        'seatWidth': 35,
        'seatHeight': 35,
        'seatCss': 'seat',
        'selectedSeatCss': 'selectedSeat',
        'selectingSeatCss': 'selectingSeat'
    };
    
    $scope.init= function(bookedSeats){
        
    };
});


