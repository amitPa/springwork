<%-- 
    Document   : welcome
    Created on : Jul 3, 2016, 12:04:32 PM
    Author     : AmitPandey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<html>
    <head>
        <title>BOR</title>
        <link rel="shortcut icon" href="images/1000000.png" type="image/png">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
         <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular-route.min.js"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/ngstorage/0.3.6/ngStorage.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.13/angular-animate.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.cyan-light_blue.min.css">
        <link href="/BikeOnRent/resource/material.min.css" rel="stylesheet" type="text/css"/>
        <link href="/BikeOnRent/resource/css/Custom.css" rel="stylesheet" type="text/css"/>
        <link href="/BikeOnRent/resource/css/CustomHome.css" rel="stylesheet" type="text/css"/>
        <script src="/BikeOnRent/resource/js/Model/app.js" type="text/javascript"></script>
        <script src="/BikeOnRent/resource/js/Directives/valueMatchdirective.js" type="text/javascript"></script>
        <script src="/BikeOnRent/resource/js/Services/DataService.js" type="text/javascript"></script>
        <script src="/BikeOnRent/resource/js/Controller/SignUp.js" type="text/javascript"></script>
    </head>
    <body ng-app="postApp">
        <div class="mdl-layout mdl-js-layout">
            <main class="mdl-layout__content" >
                <div class="page-content">
                    <div class="mdl-layout mdl-js-layout mdl-color--indigo">
                        <main class="mdl-layout__content">
                            <div ng-view>

                            </div>
                        </main>
                    </div>
                </div>
            </main>
        </div>
        <script src="https://code.getmdl.io/1.1.3/material.min.js"></script>
    </body>
</html>