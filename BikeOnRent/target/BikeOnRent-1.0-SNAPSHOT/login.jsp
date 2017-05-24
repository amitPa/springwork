<%-- 
    Document   : login
    Created on : Jul 3, 2016, 12:15:11 PM
    Author     : AmitPandey
--%>

<!DOCTYPE html>
<div class="mdl-grid" style="padding: 2px 0px 0px 0px;" ng-show="visibilty">
    <div class="mdl-layout-spacer"></div>
    <div class="mdl-card mdl-shadow--6dp">
        <div class="mdl-card__title mdl-color--white mdl-color-text--primary" style="text-align:center">
            <span class="mdl-card__title-text center" style="padding:0 0 0 30%">BOR Login </span>
        </div>
        <div class="mdl-card__supporting-text" >
            <form  name='userForm'  action="checkUser" method="POST">
                <div class="mdl-textfield mdl-js-textfield left-inner-addon">
                    <i class="material-icons">&#xE7FF;</i>
                    <input class="mdl-textfield__input element-space" type="text" id="username" name="userEmail" autocomplete="off" value="" ng-model="User.userEmail" placeholder="Useremail"/>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield left-inner-addon">
                    <i class="material-icons">&#xE897;</i>
                    <input class="mdl-textfield__input element-space" type="{{inputType}}" id="userpass" value=""  ng-model="User.userPassword" name="userPassword" placeholder="Password"/>
                </div>
                <div class="mdl-textfield mdl-js-textfield left-inner-addon">
                    <input type="checkbox" id="checkbox" ng-model="passwordCheckbox" ng-click="hideShowPassword()" />
                    <label for="checkbox" class=" mdl-js-ripple-effect"  ng-if="passwordCheckbox">Show password</label>
                    <label for="checkbox" class="mdl-js-ripple-effect" ng-if="!passwordCheckbox">Show password</label>
                </div>
                <div class="mdl-card__actions" style="text-align:center">
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
                        Log In
                    </button>
                </div>
                <div class="mdl-card__actions" style="text-align:center">
                    <span class="mdl-navigation__link"> Not Registered ?</span>
                    <a href="#signup" style="text-decoration: none;" >Sign Up</a><br>
                    <a href="#forgot" style="text-decoration: none;">Forgot Password ?</a>
                </div>
            </form>
        </div>

    </div>
    <div class="mdl-layout-spacer"></div>
</div>

