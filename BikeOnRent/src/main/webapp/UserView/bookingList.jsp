<%-- 
    Document   : bookingList
    Created on : Aug 23, 2016, 12:32:13 PM
    Author     : AmitPandey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="bookingList">
    <div id="overlay" class="mdl-cell--12-col-desktop mdl-cell--middle mdl-cell--8-col" ng-show="formHidden"></div>
    <div class="mdl-layout-spacer"></div>
    <div class="mdl-grid demo-content" ng-init="fetchBookings()">
        <div class="mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid" >
            <div class="mdl-grid" ng-repeat="book in bookings| orderBy : 'bicycleCreatedDateTime' : true ">
                <div class="demo-chart mdl-cell mdl-cell--4-col mdl-cell--2-col-desktop">
                    <center><strong><span style="color:black;line-height: 0px;"> {{book.bicycle.bicycleName}}</span></strong></center><br>
                    <center><img ng-src="images/{{book.bicycleId}}.png" width="160px" height="120px" alt="" id="imgBike" /></center>
                </div>

                <div class="demo-chart mdl-cell mdl-cell--4-col mdl-cell--3-col-desktop" style="color:#37474F" ><span><strong>Description : </strong>{{book.bicycle.biycleDescription}}</span></div>
                <div  class="demo-chart mdl-cell mdl-cell--4-col mdl-cell--2-col-desktop" style="color:#37474F" ><span><strong>Cost : </strong> {{book.bicyleCost}}</span></div>
                <div  class="demo-chart mdl-cell mdl-cell--4-col mdl-cell--3-col-desktop" style="color:#37474F"><span><strong>Booking Type : </strong> {{book.bicycleBookingType}} </span>
                    <br><span ><strong>Booking Time : </strong> {{book.bicycleCreatedDateTime}} </span>
                    <br><span><strong>Pick Up Time : </strong> {{book.bicyclePickUpTime}} </span></div>
                <div  class="demo-chart mdl-cell mdl-cell--4-col mdl-cell--1-col-desktop">
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" ng-click="hideDialog(book,$index)">
                        Cancel
                    </button>
                </div>
                <div class="demo-chart mdl-cell mdl-cell--12-col mdl-cell--12-col-desktop" >
                    <hr>
                </div>
            </div>
        </div>
    </div>
    <div class="mdl-layout-spacer"></div>
    <formmodal style="styleName" class="className " title="Book"  visible="formHidden" ng-visible="formHidden">
        <h4 class="modal-title" style="text-align: center;margin-bottom: 0"> Are you sure you want to cancel booking for {{bookDetail.bicycle.bicycleName}} </h4>
        <form autocomplete="on" name="userForm" ng-submit="submitCancel(bookDetail,indexing)" id="formCancel">
            <div class="mdl-card__actions" style="text-align:center">
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"  data-dismiss="modal" type="button">
                    No
                </button>
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"  type="submit">
                    Yes
                </button>
            </div>
        </form>
    </formmodal>
</div>
