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
        <script type="text/javascript">
            function myFunction() {
                var pass1 = document.getElementById("setPassword").value;
                var pass2 = document.getElementById("resetPassword").value;
                if (pass1 != pass2) {
                    var element = document.getElementById("spn_warning");
                    element.style.display = "block";
                    return false;
                }
                else {
                    var paramEmail = getQueryVariable("email");
                    var paramId = getQueryVariable("id");

                    $.ajax({
                        type: 'POST',
                        url: 'resetPassword',
                        data: {
                            'id': paramId,
                            'email': paramEmail,
                            'password': pass1// <-- the $ sign in the parameter name seems unusual, I would avoid it
                        },
                        success: function (msg) {
                            location.href = "http://localhost:8080/BikeOnRent/"
                        }
                    });
                    
                    return false;
                }
            }

            function getQueryVariable(variable) {
                var query = window.location.search.substring(1);
                var vars = query.split("&");
                for (var i = 0; i < vars.length; i++) {
                    var pair = vars[i].split("=");
                    if (pair[0] == variable) {
                        return pair[1];
                    }
                }
            }
        </script>
    </head>
    <body>
        <div class="mdl-layout mdl-js-layout">
            <main class="mdl-layout__content" >
                <div class="page-content">
                    <div class="mdl-layout mdl-js-layout mdl-color--indigo">
                        <main class="mdl-layout__content">
                            <div class="mdl-grid" style="padding: 2px 0px 0px 0px;">
                                <div class="mdl-layout-spacer"></div>
                                <div class="mdl-card mdl-shadow--6dp">
                                    <div class="mdl-card__title mdl-color--white mdl-color-text--primary" style="text-align:center">
                                        <span class="mdl-card__title-text center" style="padding:0 0 0 10%">BOR Reset Password </sspan>
                                    </div>
                                    <div class="mdl-card__supporting-text" >
                                        <form name="userForm" action="resetPassword" onsubmit="return myFunction()">
                                            <span style="color:red;display:none;"id="spn_warning">
                                                <span>Password Do Not Match</span>
                                            </span>
                                            <div class="mdl-textfield mdl-js-textfield left-inner-addon">
                                                <i class="material-icons">&#xE897;</i>
                                                <input class="mdl-textfield__input element-space" type="password" id="setPassword" autocomplete="off" value=""/>
                                                <label class="mdl-textfield__label element-space" for="setPassword">Password</label>
                                            </div><br>
                                            <div class="mdl-textfield mdl-js-textfield left-inner-addon">
                                                <i class="material-icons">&#xE897;</i>
                                                <input class="mdl-textfield__input element-space" type="password" id="resetPassword" value="" />
                                                <label class="mdl-textfield__label element-space" for="resetPassword" autocomplete="off">ConfirmPassword</label>
                                            </div>
                                            <div class="mdl-card__actions" style="text-align:center">
                                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
                                                    RESET
                                                </button>
                                            </div>
                                        </form>
                                    </div>

                                </div>
                                <div class="mdl-layout-spacer"></div>
                            </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
