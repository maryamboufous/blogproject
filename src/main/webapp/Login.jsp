<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<script> 
function validate()
{ 
     var username = document.form.username.value; 
     var password = document.form.password.value;
 
     if (username==null || username=="")
     { 
     alert("Username cannot be blank"); 
     return false; 
     }
     else if(password==null || password=="")
     { 
     alert("Password cannot be blank"); 
     return false; 
     } 
}
</script> 
</head>
<body class ="loginpage">
    <div style="text-align:center" class="container">
    <br>
    <form name="form" action="login" method="post" onsubmit="return validate()">
        <h1>Login</h1>

      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="userName" required>

      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="password" required>


         <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span></td>
         </tr>
      <button type="submit" value="Login">Login</button>

    </form>
    </div>
    
    
    
    
<style>
@charset "ISO-8859-1";
*{
	margin : 0%;
	padding : 0%;
	font-family: Poppins , sans-serif;
}
nav {
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    background-color: #333;
    color: #fff;
    padding: 10px;
    margin-bottom: 20px ;
  }
  
.header  h1{
    background-color: black;
    text-align: center;
    color: #fff;
    padding: 10px;
  }
  nav a {
    color: #fff;
    text-decoration: none;
    margin-right: 10px;
  }

  nav a:hover{
    color: #45a049;
    text-decoration: none;
    margin-right: 10px;
  }
  
    /*==================LOGIN Page=====================*/
  * {
  box-sizing: border-box;
}

.loginpage  {
  background-color: #f1f1f1;
}

.loginpage .container {
  margin-top: 80px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.loginpage form {
  border: 3px solid #f1f1f1;
  background-color: #fff;
  padding: 20px;
  width: 400px;
}

.loginpage input[type=text], .loginpage input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

.loginpage button[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

 .loginpage button[type=submit]:hover {
  background-color: #45a049;
}

.loginpage h1 {
  text-align: center;
  font-size: 40px;
  margin-bottom: 50px;
}
  
  /*==================Home Page=====================*/
  
.body{
width : 100%;
height :100%;
}

.content{
	background :  #eafaf1 ;
	margin : 15px 3%;
	min-height: 400px;
	border-radius: 10px;
}

.content span{
	text-align: center;
}
  
/*================= CreateBlog page =================*/
form {
  display: flex;
  flex-direction: column;
  align-items: center;
}

label {
  margin-top: 10px;
  margin-bottom: 5px;
  font-weight: bold;
}

input[type="text"],
textarea {
  width: 300px;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  border: 1px solid #ccc;
  font-size: 16px;
}

input[type="submit"] {
  width: 150px;
  padding: 10px;
  margin-top: 10px;
  border-radius: 5px;
  border: none;
  background-color: #3498db;
  color: #fff;
  font-size: 16px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #2980b9;
}


  
</style>
</body>
</html>