/*
	© 2018 TienTV5
*/

// Set timeout page loader
$(function() {
	setTimeout(function () { $('.page-loader-wrapper').fadeOut(); }, 50);
});

// Call the dataTables jQuery plugin
$('#dataTable').dataTable({
	"ordering": false,
	//searching: false,
	//lengthChange: false,
	//pageLength: 10,
	bInfo : false,
});

$('#dataTable-listStudent').dataTable({
	"ordering": true,
	searching: true,
	lengthChange: true,
	pageLength: 2,
	bInfo : true,
});

//Confirm Delete
function confirmDelete() {
	var conf = confirm('Are you sure you want to delete this record?');
	if (conf == true) {
		// alert("Xóa thành công");
		return true;
	} else {
		return false;
	}
}


function validateFormBooking() {
	
}

$(document).ready(function() {
	
	startTime();

});

//add active
$(function() {
	var loc = window.location.pathname;
    $('#sidebarAdmin').find('a').each(function() {
    	if ($(this).attr('href') == loc) {
    		$(this).parent().addClass('active');
    	}
    	if (loc.indexOf('employee') != -1) {
    		$('#employee-mana').addClass('active');
    	}
    	if (loc.indexOf('cinema-room') != -1) {
    		$('#cinema-mana').addClass('active');
    	}
    });
});

// Drop down hover
$('ul.nav li.dropdown').hover(function() {
    $(this).find('.dropdown-menu').stop(true, true).delay(100).fadeIn(500);
}, function() {
    $(this).find('.dropdown-menu').stop(true, true).delay(10).fadeOut(10);
});

// Show datepicker bootstrap
$(function() {
	// $('#fromDate').datepicker({
	//
	// });
});

// Add class disabled when time current > showtime
/*$('#showtimes a span').each(function() {

	if (compareTime($(this).text(), startTime()) == -1) {
		$(this).parent('a').addClass('disabled');
	}
});*/

// Check time
function checkTime(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}

// Get current time
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    // add a zero in front of numbers<10
    m = checkTime(m);
    s = checkTime(s);
    t = setTimeout(function () {
        startTime()
    }, 500);
    return h + ":" + m;
}

// Compare time
function compareTime(str1, str2) {
    if (str1 === str2){
        return 0;
    }
    var time1 = str1.split(':');
    var time2 = str2.split(':');
    if (eval(time1[0]) > eval(time2[0])){
        return 1;
    } else if (eval(time1[0]) == eval(time2[0]) && eval(time1[1]) > eval(time2[1])) {
        return 1;
    } else {
        return -1;
    }
}
