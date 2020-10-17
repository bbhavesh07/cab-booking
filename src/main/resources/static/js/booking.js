$(document).ready(function () {
	$("#booking-form button").click(function (event) {
    //$("#booking-form btn-submit").submit(function (event) {
    	
        event.preventDefault();
        
        if($(this).attr("id") == "btn-submit"){
        	get_driver();
        }
        
        if($(this).attr("id") == "btn-list-drivers"){
        	list_drivers();
        }
        

    });

});

function get_driver() {

    var order = {}
    order["orderId"] = null;
    order["custName"] = $("#name").val();
    order["custLatitude"] = Number($("#latitude").val());
    order["custLongitude"] = Number($("#longitude").val());
    order["driver"] = null;

    $("#btn-submit").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/cab-booking/book",
        data: JSON.stringify(order),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Booking is succesful, Your driver is: <b>" + data.name + "</b></h4>";
            $('#response').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-submit").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Booking failed " + e.responseText.message + "</h4>";
            $('#response').html(json);

            console.log("ERROR : ", e);
            $("#btn-submit").prop("disabled", false);

        }
    });

}

function list_drivers(){
	
	$("#btn-list-drivers").prop("disabled", false);
	
	$.ajax({
	  type : "GET",
	  url: "/cab-booking/driver",
      cache: false,
      timeout: 600000,
	  success: function(result){
		console.log(result);
		$('#response-list').empty();
		$('#response-list').append(`<table id="customerTable" class="table table-bordered table-hover">
        <thead>
        <tr>
          <th>Driver Name</th>
          <th>Customer Name</th>
          <th>Driver Status</th>
        </tr>
      </thead>
      <tbody>
      </tbody>
    </table>`)
	    $.each(result, function(i, driver){
	    	if(driver.booking != null) var cust = driver.booking.custName; else var cust = "-";
	      var driverRow = '<tr>' +
	                '<td>' + driver.name + '</td>' +
	                '<td>' + cust + '</td>' +
	                '<td>' + driver.status + '</td>' +
	                '</tr>';
	      
	      $('#response-list tbody').append(driverRow);
	      
	        });
	    
	    $( "#response-list tbody tr:odd" ).addClass("info");
	    $( "#response-list tbody tr:even" ).addClass("success");
	    
	    $("#btn-list-drivers").prop("disabled", false);
	  },
	  error : function(e) {
		  var json = "<h4>Could not get the list of Drivers " + e.responseText.message + "</h4>";
          $('#response-list').html(json);

          console.log("ERROR : ", e);
          $("#btn-list-drivers").prop("disabled", false);
	   }
	});  
}