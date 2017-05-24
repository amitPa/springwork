<%-- 
    Document   : signup
    Created on : Jul 3, 2016, 12:18:33 PM
    Author     : AmitPandey
--%>

<div class="mdl-grid" style="padding: 2px 0px 0px 0px;">
    <div class="mdl-layout-spacer"></div>
    <div class="mdl-card mdl-shadow--6dp">
        <div class="mdl-card__title mdl-color--white mdl-color-text--primary" style="text-align:center">
            <span class="mdl-card__title-text center" style="padding:0 0 0 20%">Forgot Password </span>
        </div>
        <div class="mdl-card__supporting-text" ng-show="successMail">
            <span>Please check the mail to reset your password</span>
        </div>
        <div class="mdl-card__supporting-text" ng-show="!(successMail)">
            <form name="userForm" ng-submit="submitForgotEmail()">
                <div class="mdl-textfield mdl-js-textfield left-inner-addon">
                    <i class="material-icons">&#xE0BE;</i>
                    <input class="mdl-textfield__input element-space" type="text" id="sp_email" ng-model="User.userEmail" name="userEmail" required autocomplete="off"/>
                    <label class="mdl-textfield__label element-space" for="sp_email">Email</label>
                    <span style="color:red" ng-show="userForm.userEmail.$dirty && userForm.userEmail.$invalid">
                        <span ng-show="userForm.userEmail.$error.required">Email is required.</span>
                        <span ng-show="userForm.userEmail.$error.email">Invalid email address.</span>
                    </span>
                    <span style="color:red" ng-show="failMail">Mail Id Does not exist</span>
                </div><br>
                <div class="mdl-card__actions" style="text-align:center">
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" ng-disabled="userForm.$invalid" type="submit">
                        Submit
                    </button>
                </div>
                <div class="mdl-card__actions" style="text-align:center">
                    <span class="mdl-navigation__link"> Already Registered ?</span>
                    <a href="#login" style="text-decoration: none;" ng-click="cardSelect()">Sign In</a><br>
                    <a href="#signup" style="text-decoration: none;">Sign Up ?</a>
                </div>
            </form>
        </div>

    </div>
    <div class="mdl-layout-spacer"></div>
</div>