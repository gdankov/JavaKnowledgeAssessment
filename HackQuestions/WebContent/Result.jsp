<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">   	
 <script src="jquery-1.12.1.min.js"></script>   	
 <script src="bootstrap.min.js"></script>   
 <link href="result.css" rel="stylesheet">
<title>Result</title>
</head>
<body background="blue.jpg">
<form action="Servlet" method="get" class="result">
	<div class="panel panel-primary">
	<div class="panel-heading">Result :)</div>
	
	<div class="panel-body">
	<label for="Level">Your level is:</label><br>
	<label for="Level">${level}</label></br>
    <label for="Level">Recommendations:</label></br>
	<label for="Level">${recomendations}</label></br>	
  		</div>
  </div>
	</div>
	</form>

</body>
</html>