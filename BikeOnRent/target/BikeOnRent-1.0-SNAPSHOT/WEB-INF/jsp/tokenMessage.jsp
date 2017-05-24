<%-- 
    Document   : changePassword
    Created on : Jul 19, 2016, 5:48:02 PM
    Author     : AmitPandey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>BOR</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="/BikeOnRent/resource/material.min.css" rel="stylesheet" type="text/css"/>
        <link href="/BikeOnRent/resource/css/Custom.css" rel="stylesheet" type="text/css"/>
        <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    </head>
    <body>
        <div class="mdl-layout mdl-js-layout">
            <main class="mdl-layout__content" >
                <form>
                    <div class="page-content">
                        <div class="mdl-layout mdl-js-layout mdl-color--indigo">
                            <main class="mdl-layout__content">
                                <div class="mdl-grid" style="padding: 2px 0px 0px 0px;">
                                    <div class="mdl-layout-spacer"></div>
                                    <div class="mdl-card mdl-shadow--6dp">
                                        <div class="mdl-card__title mdl-color--white mdl-color-text--primary" style="text-align:center">
                                            <span class="mdl-card__title-text center" style="padding:0 0 0 0%"><center>${data}</center></span>
                                        </div>
                                        <div class="mdl-card__supporting-text" >
                                        </div>
                                        <div class="mdl-card__actions" style="text-align:center">
<!--                                            <span class="mdl-navigation__link"> Already Registered ?</span>-->
                                            <a href="/BikeOnRent/#signup" style="text-decoration: none;" >Sign Up ?</a> 
                                            <a href="/BikeOnRent/#login" style="text-decoration: none;">Sign In </a><br>
                                            <a href="/BikeOnRent/#forgot" style="text-decoration: none;">Forgot Password ?</a>
                                        </div>
                                    </div>
                                    <div class="mdl-layout-spacer"></div>
                                </div>
                        </div>
                        <br>
                        <div class="mdl-card__actions" style="text-align:center">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" ng-disabled="userForm.$invalid" type="submit">
                                Submit
                            </button>
                        </div>
                        <div class="mdl-card__actions" style="text-align:center">
                            <span class="mdl-navigation__link"> Already Registered ?</span>
                            <a href="#login" style="text-decoration: none;">Sign In</a><br>
                            <a href="#signup" style="text-decoration: none;">Sign Up ?</a>
                        </div>
                    </div>
                </form>
            </main>
        </div>
    </body>
</html>
