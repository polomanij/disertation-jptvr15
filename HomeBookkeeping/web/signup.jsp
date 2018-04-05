<%-- 
    Document   : signup
    Created on : Apr 5, 2018, 2:38:17 PM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"></html>
<head>
  <meta charset="UTF-8"/>
  <title>signin</title>
  <!--Import Google Icon Font-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"/>
  <!--Import materialize.css-->
  <link rel="stylesheet" href="libs/materialize/css/materialize.min.css"/>
  <!--my styles-->
  <link rel="stylesheet" href="css/style.css"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body class="blue-grey lighten-2">
  <header class="header">
    <nav class="teal">
      <div class="container">
        <div class="nav-wrapper"><a href="#" class="brand-logo">Bookkeeping</a><a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
          <ul class="right hide-on-med-and-down">
            <li><a href="index.jsp">Signin</a></li>
            <li><a href="signup.jsp">Signup</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <ul id="mobile-demo" class="sidenav">
      <li><a href="index.jsp">Signin</a></li>
      <li><a href="signup.jsp">Signup</a></li>
    </ul>
  </header>
  <section class="signup">
    <div class="wrapper">
      <div class="sign-form-row">
          <form class="sign-form blue-grey lighten-5" action="controller?command=registration" method="post">
          <div class="input-field">
            <input id="login" type="text" placeholder="login" name="login" class="validate"/>
            <label for="login">Login</label>
          </div>
          <div class="input-field">
            <input id="name" type="text" placeholder="name" name="name" class="validate"/>
            <label for="name">Name</label>
          </div>
          <div class="input-field">
            <input id="surname" type="text" placeholder="surname" name="surname" class="validate"/>
            <label for="surname">Surname</label>
          </div>
          <div class="input-field">
            <input id="email" type="email" placeholder="email" name="email" class="validate"/>
            <label for="email">Email</label>
          </div>
          <div class="input-field">
            <input id="password" type="password" placeholder="password" name="password" class="validate"/>
            <label for="password">Password</label>
          </div>
          <div class="input-field">
            <button type="submit" class="btn waves-effect">Signup</button>
          </div>
        </form>
      </div>
    </div>
  </section>
  <script src="libs/materialize/js/materialize.min.js"></script>
  <script src="js/common.js"></script>
</body>