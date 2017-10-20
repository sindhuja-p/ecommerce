<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>Sign-Up</h1>
 </head>
 <script>
</script>
         <form class="form-horizontal" action="<c:url value='/Registration/permitAll' />" method="post">
        <div class="form-group">
            <label for="inputUsername" class="control-label col-xs-2">User Name</label>
            <div class="col-xs-2">
                <input type="text" class="form-control" id="inputUsername" placeholder="Username" required>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Password</label>
            <div class="col-xs-2">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <div class="checkbox">
                    <label><input type="checkbox">Remember me</label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary">Login</button>
                <input type="submit" name="submit" value="Login" />
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="{_$csrf.token}"/>
        
         </form>

</body>
</html>
