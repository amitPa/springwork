<%-- 
    Document   : signup
    Created on : Jul 3, 2016, 12:18:33 PM
    Author     : AmitPandey
--%>

<div class="mdl-grid" style="padding: 2px 0px 0px 0px;">
    <div class="mdl-layout-spacer"></div>
    <div class="mdl-card mdl-shadow--6dp">
        <div class="mdl-card__title mdl-color--white mdl-color-text--primary" style="text-align:center">
            <span class="mdl-card__title-text center" style="padding:0 0 0 30%">BOR Login </span>
        </div>
        <div class="mdl-card__supporting-text" ng-show="userAdded" style="text-align:center">
            <span>Succesfully Added click <a href="#login" style="text-decoration: none;">here</a> To Login</span>
        </div>
        <div class="mdl-card__supporting-text" ng-show="signUp">
            <form autocomplete="on" name="userForm" ng-submit="submitUser()" >
                <span ng-show="userFailed" style="color:red">User is already registered</span>
                <div class="mdl-textfield mdl-js-textfield left-inner-addon mdl-textfield--floating-label">
                    <i class="material-icons">&#xE7FF;</i>
                    <input class="mdl-textfield__input element-space" type="text" id="sp_username" ng-model="User.userName" name="userName" ng-minlength="3"  ng-maxlength="50" required autocomplete="off" placeholder="Username"/>
                </div>
                <span style="color:red" ng-show="userForm.userName.$dirty && userForm.userName.$invalid">
                    <span ng-show="userForm.userName.$error.required">Username is required.</span>
                    <span ng-show="userForm.userName.$error.minlength">Username is too short.</span>
                </span>
                <div class="mdl-textfield mdl-js-textfield left-inner-addon mdl-textfield--floating-label">
                    <i class="material-icons">&#xE0BE;</i>
                    <input class="mdl-textfield__input element-space" type="email" id="sp_email" ng-model="User.userEmail" name="userEmail" required autocomplete="off" placeholder="Email"/>
                    <span style="color:red" ng-show="userForm.userEmail.$dirty && userForm.userEmail.$invalid">
                        <span ng-show="userForm.userEmail.$error.required">Email is required.</span>
                        <span ng-show="userForm.userEmail.$error.email">Invalid email address.</span>
                    </span>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield left-inner-addon mdl-textfield--floating-label">
                    <i class="material-icons">&#xE0CD;</i>
                    <input class="mdl-textfield__input element-space" type="text" id="sp_phone" ng-pattern="/^\+?\d{2}[- ]?\d{3}[- ]?\d{5}$/" ng-model="User.userContact" name="userContact" required autocomplete="off" placeholder="Phone"/>
                </div>
                <span style="color:red" ng-show="userForm.userContact.$dirty && userForm.userContact.$invalid">
                    <span ng-show="userForm.userContact.$error.required">Mobile Number is required.</span>
                    <span ng-show="userForm.userContact.$error.pattern">Please enter a valid mobile number</span>
                </span>
                <br>
                <div class="mdl-textfield mdl-js-textfield left-inner-addon mdl-textfield--floating-label">
                    <i class="material-icons">&#xE897;</i>
                    <input class="mdl-textfield__input element-space" type="password" id="userpass" ng-model="User.userPassword" required autocomplete="off" placeholder="Password"/>
                </div>
                <div class="mdl-textfield mdl-js-textfield left-inner-addon mdl-textfield--floating-label">
                    <i class="material-icons">&#xE897;</i>
                    <input class="mdl-textfield__input element-space" type="password" id="userconfirmpass" name="userConfirmPassword" ng-model="User.userConfirmPassword" required autocomplete="off" pw-check="userpass" placeholder="ConfirmPassword"/>
                    <span ng-show="userForm.userConfirmPassword.$dirty && userForm.userConfirmPassword.$invalid"> <span ng-show="userForm.userConfirmPassword.$error.pwmatch" style="color:red">Passwords do not match</span></span>
                </div>

                <div class="mdl-card__actions" style="text-align:center">
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" ng-disabled="userForm.$invalid" type="submit">
                        Sign Up
                    </button>
                </div>
                <div class="mdl-card__actions" style="text-align:center">
                    <span class="mdl-navigation__link"> Already Registered ?</span>
                    <a href="#login" style="text-decoration: none;" ng-click="cardSelect()">Sign In</a><br>
                    <a href="#forgot" style="text-decoration: none;">Forgot Password ?</a>
                </div>
            </form>
        </div>

    </div>
    <div class="mdl-layout-spacer"></div>
</div>