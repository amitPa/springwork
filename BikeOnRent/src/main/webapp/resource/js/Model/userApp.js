/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var userApp = angular.module('userApp', ['ngRoute', 'ngStorage','ngAnimate']);

userApp.config(function ($routeProvider) {
    $routeProvider
            .when('/', {
                templateUrl: '/BikeOnRent/UserView/bicycle.jsp',
                controller: 'bicycleController'
            })
            .when('/booking', {
                templateUrl: '/BikeOnRent/UserView/bookingList.jsp',
                controller: 'bookingController'
            }).when('/profile', {
                templateUrl: '/BikeOnRent/UserView/profile.jsp',
                controller: 'profileController'
            }) .when('/editImage', {
                templateUrl: '/BikeOnRent/UserView/ImageEditor.jsp',
                controller: 'profileController'
            }).otherwise({
                templateUrl: '/BikeOnRent/UserView/bicycle.jsp',
                controller: 'bicycleController'
            });
});

