<%-- 
    Document   : profile
    Created on : Aug 29, 2016, 7:13:07 PM
    Author     : AmitPandey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    $('#falseinput').click(function () {
        $("#file-input").click();
    });
</script>

<div class="mdl-grid" id="divProfile" >
    <div class="mdl-cell--middle mdl-cell--12-col-desktop mdl-cell--8-col mdl-cell--stretch" style="background-image:url('images/background.png');  height: 280px;vertical-align: middle;width:100%">
        <center style='padding:40px;'><form>  <img src="images/1000000.jpg" class="demo-avatar" style=''>
                <div class="image-upload">
                    <i class="material-icons" id="falseinput">create</i>
                    <input id="file-input" type="file" />
                </div>
                <div class="mdl-tooltip mdl-tooltip--large" for="btnEditImage">
                    Print

                </div>
            </form>
        </center>

    </div>

    <div class="mdl-cell--middle mdl-cell--6-col-desktop mdl-cell--2-col mdl-cell--stretch active demo-div" style='font-size: large; cursor:pointer;text-align:center;height:40px;width:50%' ng-class='classEditProfile'  ng-click="slideScreen()" >
        <span  style='color:red;vertical-align: middle;position:relative;top:30%;'>Edit Profile</span>
    </div>
    <div class="mdl-cell--middle mdl-cell--6-col-desktop mdl-cell--2-col mdl-cell--stretch demo-div"  ng-class='classPassword'  ng-click="slideScreen()" >
        <span href="" ng-cick="slideScreen()" style='color:red;vertical-align: middle;position:relative;top:30%;'>Change Password</span>
    </div>
    <div class="mdl-cell--middle mdl-cell--12-col-desktop mdl-cell--8-col  mdl-card__supporting-text animate-hide" style="width:100%" ng-hide='profile'>
        <header class="demo-drawer-header mdl-layout__header--transparent" style='font-size:large;height:auto;width:100%' id="hdrProfile">
            <span ng-show="names"><strong>Name: </strong>{{user.userName}}
                <button type='submit' id='btnEditImage' class="mdl-button mdl-js-button mdl-button--raised " style='background-color:transparent;box-shadow:0 0 0 0;padding: 0px' ng-click="names = !names" > <i class="material-icons">create</i></button>
            </span>

            <div class=" mdl-grid mdl-cell--12-col-desktop"  style="bottom:35px;padding:10px;" ng-hide="names">
                <div class="mdl-cell--6-col left-inner-addon">
                    <i class="material-icons">&#xE897;</i>
                    <input class="mdl-textfield__input element-space " type="text" id="setName" value="" id="inpName" placeholder='Name'  ng-model="user.userName"/>
                </div>
                <div class="mdl-cell--1-col" style="float:right;">
                    <label> <button type='submit' id='btnEditImage' class="mdl-button mdl-js-button mdl-button--raised" style='background-color:transparent;box-shadow:0 0 0 0;padding: 0px' ng-click="save('name', user.userName)" > <i class="material-icons">book</i></button> 
                    </label>
                </div>
            </div>
            <br>
            <span ng-show="emails"><strong>Email: </strong>{{user.userEmail}}
                <button type='submit' id='btnEditImage' class="mdl-button mdl-js-button mdl-button--raised " style='background-color:transparent;box-shadow:0 0 0 0;padding: 0px' ng-click="emails = !emails"> <i class="material-icons">create</i></button>
            </span>
            <div class=" mdl-grid mdl-cell--12-col-desktop"  ng-hide="emails">
                <div class="mdl-cell--6-col left-inner-addon">
                    <i class="material-icons">&#xE0CD;</i>
                    <input class="mdl-textfield__input element-space" type="email" id="setPhone" autocomplete="off" value="" placeholder="Email" ng-model="user.userEmail"/>
                </div>
                <div class="mdl-cell--1-col" style="float:right;">
                    <label> <button type='submit' id='btnEditImage' class="mdl-button mdl-js-button mdl-button--raised" style='background-color:transparent;box-shadow:0 0 0 0;padding: 0px' ng-click="save('email', user.userEmail)" > <i class="material-icons">book</i></button> 
                    </label>
                </div>
            </div>
            <br>
            <span ng-show="phones"><strong>Phone: </strong>{{user.userContact}}
                <button type='submit' id='btnEditImage' class="mdl-button mdl-js-button mdl-button--raised " style='background-color:transparent;box-shadow:0 0 0 0;padding: 0px' ng-click="phones = !phones"> <i class="material-icons">create</i></button>
            </span>
            <div class=" mdl-grid mdl-cell--12-col-desktop"  ng-hide="phones">
                <div class="mdl-cell--6-col left-inner-addon">
                    <i class="material-icons">&#xE897;</i>
                    <input class="mdl-textfield__input element-space" id="inpPhone" type="text" id="setPhone" autocomplete="off" value="" placeholder="Phone" ng-model="user.userContact"/>
                </div>
                <div class="mdl-cell--1-col" style="float:right;">
                    <label> <button type='submit' id='btnEditImage' class="mdl-button mdl-js-button mdl-button--raised" style='background-color:transparent;box-shadow:0 0 0 0;padding: 0px' ng-click="save('contact', user.userContact)" > <i class="material-icons">book</i></button> 
                    </label>
                </div>
            </div>

            <br>
        </header>
    </div>
    <div class="mdl-cell--middle mdl-cell--12-col-desktop mdl-cell--8-col mdl-cell--stretch mdl-card__supporting-text animate-hide" ng-hide='password' style="width:100%">
        <form name="userForm"  ng-submit="submitChangePassword(formPassword.password, formPassword.userConfirmpassword)">
            <span style="color:red;display:none;"id="spn_warning">
                <span>Password Do Not Match</span>
            </span>

            <div class="mdl-textfield mdl-js-textfield left-inner-addon">
                <i class="material-icons">&#xE897;</i>
                <input class="mdl-textfield__input element-space" type="password" id="setPassword" ng-Model="formPassword.password" name="userPassword" autocomplete="off" value="" placeholder="Password" required/><br>
                <span style="color:red;"id="spn_warning">
                    <span>{{message}}</span>
                </span>
            </div><br>
            <div class="mdl-textfield mdl-js-textfield left-inner-addon">
                <i class="material-icons">&#xE897;</i>
                <input class="mdl-textfield__input element-space" type="password" id="userNewPassword" ng-Model="formPassword.userNewpassword"  name="userNewPassword" autocomplete="off" value="" placeholder="NewPassword" required/>
            </div><br>
            <div class="mdl-textfield mdl-js-textfield left-inner-addon">
                <i class="material-icons">&#xE897;</i>
                <input class="mdl-textfield__input element-space" type="password" id="resetPassword" ng-Model="formPassword.userConfirmpassword" name="userConfirmPassword" value="" placeholder='ConfirmPassword' pw-check="userNewPassword" required/>
            </div>
            <div class="mdl-textfield mdl-js-textfield left-inner-addon" ng-show="userForm.userConfirmPassword.$dirty && userForm.userConfirmPassword.$invalid">
                <span ng-show="userForm.userConfirmPassword.$error.pwmatch" style="color:red">Passwords do not match</span>
            </div>
            <div class="mdl-card__actions" style="margin-left:8%;">
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" ng-disabled="userForm.$invalid">
                    RESET
                </button>
            </div>
        </form>
    </div>
</div>

