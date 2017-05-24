
<%@page import="com.bike.model.User"%>
<%@page session="true"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="A front-end template that helps you build fast, modern mobile web apps.">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>BOR</title>
        <link rel="shortcut icon" href="images/1000000.png" type="image/png">
        <!-- Add to homescreen for Chrome on Android -->
        <meta name="mobile-web-app-capable" content="yes">


        <!-- Add to homescreen for Safari on iOS -->
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-title" content="Material Design Lite">


        <!-- Tile icon for Win8 (144x144 + tile color) -->
        <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
        <meta name="msapplication-TileColor" content="#3372DF">


        <!-- SEO: If your mobile URL is different from the desktop URL, add a canonical link to the desktop page https://developers.google.com/webmasters/smartphone-sites/feature-phones -->
        <!--
        <link rel="canonical" href="http://www.example.com/">
        -->

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">

        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.cyan-light_blue.min.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <link href="resource/css/datepicker.css" rel="stylesheet" type="text/css"/>
        <link href="resource/css/CustomHome.css" rel="stylesheet" type="text/css"/>
        <link href="resource/css/Slide.css" rel="stylesheet" type="text/css"/>
        <link href="/BikeOnRent/resource/css/Custom.css" rel="stylesheet" type="text/css"/>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/ngstorage/0.3.6/ngStorage.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular-route.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular-animate.js"></script>
        <script src="resource/js/Model/userApp.js" type="text/javascript"></script>
        <script src="/BikeOnRent/resource/js/Services/UserDataService.js" type="text/javascript"></script>
        <script src="/BikeOnRent/resource/js/Controller/BookingController.js" type="text/javascript"></script>
        <script src="resource/js/Controller/BicycleController.js" type="text/javascript"></script>
        <script src="resource/js/Controller/SessionController.js" type="text/javascript"></script>
        <script src="resource/js/Controller/ProfileController.js" type="text/javascript"></script>
        <script src="resource/js/Directives/formModal.js" type="text/javascript"></script>
        <script src="/BikeOnRent/resource/js/Directives/valueMatchUserDirective.js" type="text/javascript"></script>
        <script src="/BikeOnRent/resource/js/Directives/imageEditor.js" type="text/javascript"></script>
        <script type="text/javascript">
            /**
             * @param {string} filename The name of the file WITHOUT ending
             */
            function playSound(filename) {
                document.getElementById("sound").innerHTML = '<audio autoplay="autoplay"><source src="/BikeOnRent/audio/' + filename + '.mp3" type="audio/mpeg" /><source src="' + filename + '.ogg" type="audio/ogg" /><embed hidden="true" autostart="true" loop="false" src="/BikeOnRent/audio/' + filename + '.mp3" /></audio>';
            }

        </script>
        <style>
            #view-source {
                position: fixed;
                display: block;
                right: 0;
                bottom: 0;
                margin-right: 40px;
                margin-bottom: 40px;
                z-index: 900;
            }
            .bootstrap-datetimepicker-widget{z-index: 100000000 !important; }
        </style>
    </head>
    <body ng-app="userApp">
        <div id="sound"></div>
        <div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header ">
            <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">Home</span>
                    <div class="mdl-layout-spacer"></div>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                        <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
                            <i class="material-icons">search</i>
                        </label>
                        <div class="mdl-textfield__expandable-holder">
                            <input class="mdl-textfield__input" type="text" id="search">
                            <label class="mdl-textfield__label" for="search">Enter your query...</label>
                        </div>
                    </div>
                    <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
                        <i class="material-icons">more_vert</i>
                    </button>
                    <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
                        <li class="mdl-menu__item">About</li>
                        <li class="mdl-menu__item">Contact</li>
                        <li class="mdl-menu__item">Legal information</li>
                    </ul>
                </div>
            </header>
            <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50" ng-controller="sessionController" ng-init="getUser()">
                <header class="demo-drawer-header" >
                    <img src="images/1000000.jpg" class="demo-avatar" >
                    <div class="demo-avatar-dropdown" >
                        <span>{{user.userName}}</span>
                        <div class="mdl-layout-spacer"></div>
                        <button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
                            <i class="material-icons" role="presentation">arrow_drop_down</i>
                            <span class="visuallyhidden">Accounts</span>
                        </button>
                        <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">
                            <li class="mdl-menu__item">{{user.userEmail}}</li>
                            <li class="mdl-menu__item" ng-click="editImage()"><a href="#editImage">Edit Image</a></li>
                        </ul>
                    </div>
                </header>
                <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
                    <a class="mdl-navigation__link" href="#/"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">home</i>Home</a>
                    <a class="mdl-navigation__link" href="#profile"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">face</i>Profile</a>
                    <a class="mdl-navigation__link" href=""><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">local_offer</i>Promos</a>
                    <a class="mdl-navigation__link" href="#booking"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">shopping_cart</i>Purchases</a>
                    <a class="mdl-navigation__link" href="" ng-click="logout()"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">lock_open</i>LogOut</a>
                    <div class="mdl-layout-spacer"></div>
                    <a class="mdl-navigation__link" href=""><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">help_outline</i><span class="visuallyhidden">Help</span></a>
                </nav>
            </div>
            <main class="mdl-layout__content">
                
                <div ng-view></div>
            </main>
        </div>
        <script src="https://code.getmdl.io/1.1.3/material.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
        <script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>
    </body>
</html>

