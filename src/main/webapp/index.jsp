<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
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
      	<label>Maximum number of Total Discharges:</label>
        <input type="text" class="form-control" id="maxd">
        <label>Minimum number of Total Discharges:</label>
        <input type="text" class="form-control" id="mind">
        <label>Maximum Average Covered Charges:</label>
        <input type="text" class="form-control" id="maxacc">
        <label>Minimum Average Covered Charges:</label>
        <input type="text" class="form-control" id="minacc">
        <label>Maximum Average Medicare Payment:</label>
        <input type="text" class="form-control" id="maxamp">
        <label>Minimum Average Medicare Payment:</label>
        <input type="text" class="form-control" id="minamp">
             
        <div class="form-group">
          <label for="sel1">Select State:</label>
          <select class="form-control" id="sel1">
          	<option></option>
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
        </div> 		
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
    $("button").click(function(){
    
    var maxd = $("#maxd").val();
    var mind = $("#mind").val();
    var maxacc = $("#maxacc").val();
    var minacc = $("#minacc").val();
    var maxamp = $("#maxamp").val();
    var minamp = $("#minamp").val();
    var ps = $("#sel1").val();
    var vurl = "http://localhost:8080/health-care-provider/api/providers?max_discharges="+maxd+"&min_discharges="+mind+"&max_average_covered_charges="+maxacc+"&min_average_covered_charges="+minacc+"&max_average_medicare_payments="+maxamp+"&min_average_medicare_payments="+minamp+"&state="+ps;
    
        $.ajax({url: vurl, type:'GET', success: function(data){        	
        	var jsonStr = JSON.stringify(data);
        	var jsonObj = JSON.parse(jsonStr);
        	var jsonPretty = JSON.stringify(jsonObj, null, '\t');
        	$("pre").text(jsonPretty);
        	            
        }});
        
    });
});
</script>


</body>
</html>
