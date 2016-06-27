<!DOCTYPE html >
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script>
  	$(document).ready(function(){
  		$("button").click(function(){ var divId = "books-"+$(this).attr('id');//alert(divId); 
  			$.ajax({ 
  				url: "personbooks?id="+ $(this).attr('id'),  				
  				success: function(data) {//alert(data);
  						$("#"+divId).html("<p>Book lent:</p>" + data);	  						
  						},
      			error: function() {alert("Retrive data error.");}
  				});
  		}); 
  	});	 					
  </script>  
  		
<title>Bookland Person List</title>
</head>
<body>
<div class="container">
	<h2>${message}</h2>
	
		<table class="table table-bordered table-hover" >
		<thead>
		    <tr>
		        <th width="80">Person ID</th>
		        <th width="120">Person Name</th>
		        <th width="120">Person phone</th>
		        <th width="60">Person email address</th>
		        <th width="60">Click Button for Books</th>        		
        	</tr>			       
		</thead>
		<tbody>	    
			    <#list personlist as person>
			        <tr>
			            <td>${person.id}</td>
			            <td>${person.name}</td>
			            <td>${person.phone}</td>
			            <td>${person.email}</td>
					<td><button type="button" class="btn btn-info"
							data-toggle="collapse" data-target="#books-${person.id}"
							id="${person.id}">Books Lent</button></td>
				</tr>
			        <tr>
			        	<td colspan=5 style="padding: 0px">
			        		<div id="books-${person.id}" class="collapse" ></div>
			        	</td>
			        </tr>		
			      </#list>
		</tbody>	    
		</table>
		<a href="/" class="btn btn-success" >Go Back to BookLand</a>
</div>		
</body>
</html>