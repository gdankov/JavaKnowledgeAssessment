<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="bootstrap.min.css">   	
 <script src="jquery-1.12.1.min.js"></script>   	
        <script src="bootstrap.min.js"></script>   
         <link href="signin.css" rel="stylesheet">
<title>Logginin</title>
</head>
<body background="blue.jpg">
<div class="container">

      <form action="Servlet" method=get class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password">
        <button name="onreg" class="btn btn-lg btn-primary btn-block" type="submit"><i class="sign-in-button"></i>Sign in</button>
        <button name="noreg" class="btn btn-lg btn-primary btn-block" type="submit">Continue without signing</button>
      </form>

    </div>
</body>
</html>