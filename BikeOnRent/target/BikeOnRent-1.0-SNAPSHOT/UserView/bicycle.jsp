<%-- 
    Document   : bicycle
    Created on : Aug 3, 2016, 5:36:11 PM
    Author     : AmitPandey
--%>
<%@page import="com.bike.model.User"%>

<style>
    .bootstrap-datetimepicker-widget .dropdown-menu {z-index: 100000000 !important;bottom:0; }
    .ui-datepicker { width: 15em; padding: .2em .2em 0; z-index: 100000000 !important; }
</style>
<div class="mdl-grid demo-content" ng-init="fetchBicycles()" id="bicycleList">

    <div id="overlay" class="mdl-cell--12-col-desktop mdl-cell--middle mdl-cell--8-col"ng-show="formHidden"></div>
    <div class="mdl-color--white mdl-shadow--3dp mdl-cell mdl-cell--4-col mdl-grid" ng-repeat="bicyle in bicycles">
        <div class="mdl-cell--12-col" style="text-align:center;"><header class="mdl-layout--fixed-header"><span ><strong>{{bicyle.bicycleName}}</strong></span></header></div>
        <br><br>
        <div class="mdl-cell--12-col"><span><strong>Description : </strong> {{bicyle.biycleDescription}}</span></div>
        <br>
        <div class="mdl-cell--8-col"><span><strong>PricePerHour : </strong> {{bicyle.bicyclePricePerHour}}</span></div>
        <br>
        <div class="mdl-cell--8-col"><span><strong>PricePerDay : </strong> {{bicyle.bicyclePricePerDay}}</span></div>
        <img ng-src="images/1000000.png" width="200px" height="150px" alt="" id="imgBike" class="mdl-cell mdl-cell--6-col mdl-cell--6-col-desktop"/>
        <div class="mdl-card__actions mdl-cell--6-col mdl-cell--middle" style="text-align:right">
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" ng-click="hideDialog(bicyle)">
                Book
            </button>
        </div>
    </div>
    <div>
        <formmodal style="styleName" class="className " title="Book"  visible="formHidden" ng-show="formHidden">
            <h5 class="modal-title" style="text-align: center;margin-bottom: 0">{{bicyleDetail.bicycleName}}</h5><br>
            <h6 class="modal-title" style="margin-bottom: 0"><strong>Price Per Hour :</strong>{{bicyleDetail.bicyclePricePerHour}}</h6>
            <h6 class="modal-title" style="margin-bottom: 0"><strong>Price Per Day :</strong>{{bicyleDetail.bicyclePricePerDay}}</h6>
            <center><img src="/BikeOnRent/images/1000000.png"    class="mdl-cell mdl-cell--8-col mdl-cell--12-col-desktop img-responsive" alt="image" style="width:200px;height:200px"/></center>
            <div class="form-group">
                <form id="bookBicycle" class="mdl-grid" name="book" ng-submit="submitBooking()">
                    <div class="mdl-radio mdl-cell mdl-cell--5-col mdl-cell--6-col-desktop" style="line-height:70px;">
                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-1">
                            <input type="radio" id="option-1" class="mdl-radio__button" name="options" ng-change="resetCost"  ng-model="bookBicycle.bicycleBookingType" value="perhour" ng-checked="true">
                            <span class="mdl-radio__label">PerHour</span>
                        </label>
                        <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="option-2">
                            <input type="radio" id="option-2" class="mdl-radio__button" name="options" ng-change="resetCost" ng-model="bookBicycle.bicycleBookingType" value="perday">
                            <span class="mdl-radio__label">PerDay</span>
                        </label>
                    </div>
                    <div class="mdl-cell--2-col-desktop"></div>
                    <div class="mdl-select mdl-select--floating-label left-inner-addon mdl-cell mdl-cell--5-col mdl-cell--5-col-desktop" style="text-align:right" ng-show="(bookBicycle.bicycleBookingType == 'perhour')">
                        <select class="mdl-select__input" id="hours" name="hours" ng-change="hoursSelected()" ng-model="bookBicycle.bicycleHourNumber" placeholder="Hours">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                        </select>
                    </div>
                    <div class="mdl-select mdl-select--floating-label  mdl-cell mdl-cell--5-col mdl-cell--5-col-desktop" ng-show="(bookBicycle.bicycleBookingType == 'perday')">
                        <select class="mdl-select__input" id="inpDays" name="days" ng-change="daysSelected()" ng-model="bookBicycle.biclycleDayNumber" placeholder="Days">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>
                    </div>
                    <div class='mdl-cell mdl-cell--5-col mdl-cell--6-col-desktop' style="margin-top:10px;" >
                        <div class="form-group">
                            <div class='input-group date' id='datetimepicker1'>
                                <input type='text' class="form-control" placeholder="Pick Up Time" readonly="readonly"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="mdl-cell--2-col-desktop"></div>
                    <div class="mdl-cell mdl-cell--5-col mdl-cell--5-col-desktop" style="display:block;line-height: 40px;">
                        <span style="font-size:medium">Cost :{{bookBicycle.bicyleCost}}</span>
                    </div>
                    <div class="mdl-card__actions" style="text-align:center">
                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" data-dismiss="modal" type="button">
                            Cancel
                        </button>
                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect"  type="submit">
                            Proceed
                        </button>
                    </div>
                </form>
            </div>
        </formmodal>
        <formmodal style="styleName" class="className " title="Book"  visible="formHidden" ng-show="dialogHidden">
            Your Booking is successful 
            <div class="mdl-card__actions" style="text-align:center">
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" data-dismiss="modal" type="button">
                    View List
                </button>
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect"  type="submit">
                    Continue
                </button>
            </div>
        </formmodal>
    </div>
</div>
