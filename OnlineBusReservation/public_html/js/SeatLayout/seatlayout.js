/*
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/


var settings = {
    rows: 5,
        cols: 15,
        rowCssPrefix: 'row-',
        colCssPrefix: 'col-',
        seatWidth: 35,
        seatHeight: 35,
        seatCss: 'seat',
        selectedSeatCss: 'selectedSeat',
        selectingSeatCss: 'selectingSeat'
};


var init = function (reservedSeat) {
    var str = [], seatNo, className;
    for (i = 0; i < settings.rows; i++) {
        for (j = 0; j < settings.cols; j++) {
            seatNo = (i + j * settings.rows + 1);
            className = settings.seatCss + ' ' + settings.rowCssPrefix + i.toString() + ' ' + settings.colCssPrefix + j.toString();
            if ($.isArray(reservedSeat) && $.inArray(seatNo, reservedSeat) != -1) {
                className += ' ' + settings.selectedSeatCss;
            }
            str.push('<li class="' + className + '"' +
            'style="top:' + (i * settings.seatHeight).toString() + 'px;left:' + (j * settings.seatWidth).toString() + 'px">' +
            '<a title="' + seatNo + '">' + seatNo + '</a>' +
            '</li>');
        }
    }
    $('#place').html(str.join(''));
};
//case I: Show from starting
//init();

//Case II: If already booked
var bookedSeats = [5, 10, 25];
init(bookedSeats);