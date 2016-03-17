<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">   	
 <script src="jquery-1.12.1.min.js"></script>   	
 <script src="bootstrap.min.js"></script>   
 <link href="question.css" rel="stylesheet">
<title>Question</title>
</head>
<body>
<body background="blue.jpg";>
	<form action="Servlet" method="get" class="question">
	<div class="panel panel-primary">
	<div class="panel-heading">${name}</div>
	<div class="panel-body">
    	<input type="radio" name="sel" value="a"> ${ans1} <br>
  		<input type="radio" name="sel" value="b">${ans2} <br>
  		<input type="radio" name="sel" value="c"> ${ans3}<br>
  		<input type="radio" name="sel" value="d"> ${ans4}<br>
  		<div class="btn-group" role="group">
  		<button name="next" class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
  		</div>
  </div>
	</div>
	</form>
</body>
</html>