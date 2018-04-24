<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>
<%@ include file="/WEB-INF/jsp/includes/header.jsp"%>
  <section class="signup">
    <div class="wrapper">
      <div class="sign-form-row">
          <form class="sign-form" method="post" action="controller?action=registration">
            <div class="sign-errors">
                <c:forEach var="error" items="${errors}">
                    <p>${error}</p>
                </c:forEach>
            </div>
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
  <script src="libs/jquery.min.js"></script>
  <script src="libs/materialize/js/materialize.min.js"></script>
  <script src="js/common.js"></script>
</body>