/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



mymodal.controller('MainCtrl', function ($scope) {
    $scope.showModal = false;
    $scope.toggleModal = function () {
        $scope.showModal = !$scope.showModal;
    };
    
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

mymodal.directive('modal', function () {
    return {
        template: '<div class="modal fade">' +
                '<div class="modal-dialog">' +
                '<div class="modal-content">' +
                '<div class="modal-header">' +
                '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
                '<h4 class="modal-title">{{ title }}</h4>' +
                '</div>' +
                '<div class="modal-body" ng-transclude></div>' +
                '</div>' +
                '</div>' +
                '</div>',
        restrict: 'E',
        transclude: true,
        replace: true,
        scope: true,
        link: function postLink(scope, element, attrs) {
            scope.title = attrs.title;

            scope.$watch(attrs.visible, function (value) {
                if (value == true)
                    $(element).modal('show');
                else
                    $(element).modal('hide');
            });

            $(element).on('shown.bs.modal', function () {
                scope.$apply(function () {
                    scope.$parent[attrs.visible] = true;
                });
            });

            $(element).on('hidden.bs.modal', function () {
                scope.$apply(function () {
                    scope.$parent[attrs.visible] = false;
                });
            });
        }
    };
});


mymodal.controller('SeatSelectionController', function ($scope,modal) {

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

