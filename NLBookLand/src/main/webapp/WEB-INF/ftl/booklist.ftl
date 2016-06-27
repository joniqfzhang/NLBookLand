<!DOCTYPE html >
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  	
<title>Bookland Book List</title>
</head>
<body>
<div class="container">
	<h2>${booklist_message}</h2>

		<table class="table table-bordered table-hover">
		<thead>
		    <tr>
		        <th width="80">Book ID</th>
		        <th width="120">Book Title</th>
		        <th width="120">Book Author</th>
		        <th width="150">Book ISBN</th>  
		    </tr>          		
        </thead>
		<tbody>	       			
			<#list booklist as book>			  
			 <tr>
			     <td>${book.id}</td>
			     <td>${book.title}</td>
			     <td>${book.author}</td>
			     <td>${book.isbn}</td>			           
			 </tr>		     
			 </#list>
		 </tbody>	    
		 </table>
		 <a href="/" class="btn btn-success" >Go Back to BookLand</a>
</div>		
</body>
</html>