/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var postApp = angular.module('postApp', ['ngRoute', 'ngStorage']);

postApp.config(function ($routeProvider) {
    $routeProvider
            .when('/', {
                templateUrl: 'login.jsp',
                controller: 'postController'
            })
            .when('/signup', {
                templateUrl: 'signup.jsp',
                controller: 'postController'
            })
            .when('/login', {
                templateUrl: 'login.jsp',
                controller: 'postController'
            })
            .when('/forgot', {
                templateUrl: 'forgot.jsp',
                controller: 'postController'

            }) .otherwise({
                templateUrl: 'login.jsp',
                controller: 'postController'
            });
            
           

});
