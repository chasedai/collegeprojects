// JavaScript Document
var rootUrl = "http://localhost:8080/Motorbikes/rest/motors";
var findAll = function() {
	$.ajax({
		type : 'GET',
		url : rootUrl,
		dataType : "json",
		success : renderList
	});
};

var findPics = function(make) {
	$.ajax({
		type : 'GET',
		url : rootUrl + '/pic/' + make,
		dataType : "json",
		success : renderGallery
	});

}

var renderList = function(data) {
	$('#tBody').empty();
	$.each(data, function(index, motors) {
		$('#tBody').append(
				'<tr><td>' + motors.id + '</td><td>' + motors.make
						+ '</td><td>' + motors.year + '</td><td>'
						+ motors.mileage + '</td><td>' + motors.colour
						+ '</td><td>' + motors.engine + '</td><td><a id='
						+ motors.id
						+ ' data-toggle="modal" href="#motorDescription">'
						+ "Description " + '</a></td><td><a id=' + motors.id
						+ ' data-toggle="modal" href="#motorEdit">' + "Edit "
						+ '</a></td></tr>');

	});
	$('#THETABLE').DataTable();
}

var renderDescription = function(motors) {
	$('#motorId').val(motors.id);
	$('#make').val(motors.make);
	$('#year').val(motors.year);
	$('#mileage').val(motors.mileage);
	$('#colour').val(motors.colour);
	$('#engine').val(motors.engine);
	$('#picture').attr('src', 'images/' + motors.picture);
	$('#description').val(motors.description);
	$('#pictureedit').val(motors.picture);
	$('#descriptionedit').val(motors.description);
}

var renderGallery = function(motors) {
	$('#galleryContent').empty();
	$('#galleryContent').append(
				'<div class="img"><a href="images/' + motors.picture
						+ '"> <img src="images/' + motors.picture
						+ '" width="300" height="200"></a></div>');

}

var findById = function(id) {
	$.ajax({
		type : 'GET',
		url : rootUrl + '/' + id,
		dataType : "json",
		success : renderDescription
	});
};

var newMotor = function(data) {
	$('#motorId').val('');
	$('#make').val('');
	$('#year').val('');
	$('#mileage').val('');
	$('#colour').val('');
	$('#engine').val('');
	$('#descriptionedit').val('');
	$('#pictureedit').val('');
}

var updateMotor = function() {
	console.log('updateMotor');
	$.ajax({
		type : 'PUT',
		contentType : 'application/json',
		url : rootUrl + '/' + $('#motorId').val(),
		dataType : "json",
		data : formToJSON(),
		success : function(data, textStatus, jqXHR) {
			alert('Motor updated successfully');
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('updateMotor error: ' + textStatus);
		}
	});
};

var addMotor = function() {
	console.log('addMotor');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootUrl,
		dataType : "json",
		data : formToJSON(),
		success : function(data, textStatus, jqXHR) {
			alert('Motor created successfully');
			$('#motorId').val(data.id);
			$("#motorEdit").modal('hide');
			findAll();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('addMotor error: ' + textStatus);
		}
	});
};

var formToJSON = function() {

	return JSON.stringify({
		"id" : $('#motorId').val(),
		"make" : $('#make').val(),
		"year" : $('#year').val(),
		"mileage" : $('#mileage').val(),
		"colour" : $('#colour').val(),
		"engine" : $('#engine').val(),
		"description" : $('#descriptionedit').val(),
		"picture" : $('#pictureedit').val()
	});
};

var deleteMotor = function() {
	console.log('deleteMotor');
	$.ajax({
		type : 'DELETE',
		url : rootUrl + '/' + $('#motorId').val(),
		success : function(data, textStatus, jqXHR) {
			alert('Motor deleted successfully');
			$("#motorEdit").modal('hide');
			findAll();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('deleteMotor error');
		}
	});
};

$(document).on('click', '#delete', function() {
	deleteMotor();
	newMotor();
});

$(document).on('click', '#newmotor', function() {
	newMotor();
});

$(document).on('click', '#save', function() {

	if ($('#motorId').val() == '')
		addMotor();
	else {
		alert("The Description:" + $('#descriptionedit').val());
		updateMotor();
	}
	return false;
});

$(document).on("click", "#tBody a", function() {
	findById(this.id);
});

$(document).ready(function() {
	findAll();
	$("#select_k1").change(function() {
		if ($("#select_k1").val() == 'YAMAHA') {
			findPics('YAMAHA');
		}
		if ($("#select_k1").val() == 'Honda') {
			findPics('Honda');
		}
	});
});