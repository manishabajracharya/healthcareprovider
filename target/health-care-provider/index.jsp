<!DOCTYPE html>
<html lang="en">
<head>
  <title>Health Care Provider</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
  </style>
</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Search Provider</h4>
		<br>
      <div class="input-group">
      	<label>Maximum Number Of Total Discharges:</label>
        <input type="text" class="form-control integernumber" id="maxd">
        <label>Minimum Number Of Total Discharges:</label>
        <input type="text" class="form-control integernumber" id="mind">
        <label>Maximum Average Covered Charges:</label>
        <input type="text" class="form-control floatnumber" id="maxacc">
        <label>Minimum Average Covered Charges:</label>
        <input type="text" class="form-control floatnumber" id="minacc">
        <label>Maximum Average Medicare Payment:</label>
        <input type="text" class="form-control floatnumber" id="maxamp">
        <label>Minimum Average Medicare Payment:</label>
        <input type="text" class="form-control floatnumber" id="minamp">
		<br/>
          <label for="sel1">Select State:</label>
          <select class="form-control" id="sel1">
            <option>AL</option>
            <option>AK</option>
            <option>AZ</option>
            <option>AR</option>
            <option>CA</option>
            <option>CO</option>
            <option>CT</option>
            <option>DE</option>
            <option>DC</option>
            <option>FL</option>
            <option>GA</option>
            <option>HI</option>
            <option>ID</option>
            <option>IL</option>
            <option>IN</option>
            <option>IA</option>
            <option>KS</option>
            <option>KY</option>
            <option>LA</option>
            <option>ME</option>
            <option>MD</option>
            <option>MA</option>
            <option>MI</option>
            <option>MN</option>
            <option>MS</option>
            <option>TX</option>
            <option>MO</option>
            <option>MT</option>
            <option>NE</option>
            <option>NV</option>
            <option>NH</option>
            <option>NJ</option>
            <option>NM</option>
            <option>NY</option>
            <option>NC</option>
            <option>ND</option>
            <option>OH</option>
            <option>OK</option>
            <option>OR</option>
            <option>PA</option>
            <option>RI</option>
            <option>SC</option>
            <option>SD</option>
            <option>TN</option>
            <option>UT</option>
            <option>VT</option>
            <option>VA</option>
            <option>WA</option>
            <option>WV</option>
            <option>WI</option>
            <option>WY</option>
          </select>
          <br/>
          <label for="sel2">Select Fields For Result:</label>
          <select class="form-control" id="sel2" required>
          <option value="drgDefinition">DRG Definition</option>
          <option value="providerId">Provider_Id</option>
          <option value="providerName">Provider_Name</option>
          <option value="providerStreetAddress">Provider_Street_Address</option>
          <option value="providerCity">Provider_City</option>
          <option value="providerState">Provider_State</option>
          <option value="providerZipCode">Provider_Zip_Code</option>
          <option value="hospitalReferralRegionDescription">Hospital_Referral_Region_Description</option>
          <option value="totalDischarges">Total_Discharges</option>
          <option value="averageCoveredCharges">Average_Covered_Charges</option>
          <option value="averageTotalPayments">Average_Total_Payments</option>
          <option value="averageMedicarePayments">Average_Medicare_Payments</option>
          </select>
		
      </div>
      <div>
      <br/>
      	<button type="button" class="btn btn-primary btn-md btn-block">Search</button>
      </div>
    </div>

    <div class="col-sm-9">
      <h4><small>Search Result</small></h4>
      <hr>      
      <pre> Search result appears here</pre>
    </div>
  </div>
</div>


<script>
$(document).ready(function(){
	
	//multi select for chosing columns
	$("#sel2").attr({
		'multiple':true,
		'size':12
	});
	//by default select all from multiselect
	$("#sel2 option").prop('selected', true);
	
    $("button").click(function(){
    
    var maxd = $("#maxd").val();
    var mind = $("#mind").val();
    var maxacc = $("#maxacc").val();
    var minacc = $("#minacc").val();
    var maxamp = $("#maxamp").val();
    var minamp = $("#minamp").val();
    var ps = $("#sel1").val();
    var f = $("#sel2").val();
    //var vurl = "http://healthcareprovid420201.eastus.cloudapp.azure.com:26174/health-care-provider/api/providers?max_discharges="+maxd+"&min_discharges="+mind+"&max_average_covered_charges="+maxacc+"&min_average_covered_charges="+minacc+"&max_average_medicare_payments="+maxamp+"&min_average_medicare_payments="+minamp+"&state="+ps+"&fields="+f;
    var vurl="https://healthcareprovider.azurewebsites.net/api/providers?max_discharges="+maxd+"&min_discharges="+mind+"&max_average_covered_charges="+maxacc+"&min_average_covered_charges="+minacc+"&max_average_medicare_payments="+maxamp+"&min_average_medicare_payments="+minamp+"&state="+ps+"&fields="+f;
        $.ajax({url: vurl, type:'GET', success: function(data){        	
        	var jsonStr = JSON.stringify(data);
        	var jsonObj = JSON.parse(jsonStr);
        	/*
        	for(var i=0;i<jsonObj.length;i++){delete jsonObj[i]['providerId'];}
        	*/
        	
        	var jsonPretty = JSON.stringify(jsonObj, null, '\t');
        	$("pre").text(jsonPretty);
        	            
        }});
        
    });
    
    
    //number validation
    $(".integernumber").on("keyup blur", function(){
    	$(this).val($(this).val().replace(/[^0-9]/g,''));
    });
    
    $(".floatnumber").on("keyup blur", function(){
    	$(this).val($(this).val().replace(/[^0-9\.]/g,''));
    });
    
    
    
    
});
</script>


</body>
</html>
