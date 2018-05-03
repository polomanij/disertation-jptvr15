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
<%@ include file="/WEB-INF/jsp/includes/header.jsp" %>
  <section class="signin">
    <div class="wrapper">
      <div class="sign-form-row">
        <div class="site-desc">
          <p class="flow-text">Далеко-далеко за словесными горами в стране, гласных и согласных живут рыбные тексты. По всей текста проектах сих что запятой напоивший дорогу свой себя гор страна, приставка заманивший строчка решила деревни не повстречался заголовок, подзаголовок наш коварный языком маленький, речью даль за рекламных всемогущая?</p>
        </div>
          <form class="sign-form" method="post" action="controller?action=login">
            <div class="sign-errors">
                <c:forEach items="${errors}" var="error">
                    <p>${error}</p>
                </c:forEach>
            </div>
          <div class="input-field">
            <input id="login" type="text" placeholder="login" name="login" class="validate"/>
            <label for="login">Login</label>
          </div>
          <div class="input-field">
            <input id="password" type="password" placeholder="password" name="password" class="validate"/>
            <label for="password">Password</label>
          </div>
          <div class="input-field">
            <button type="submit" class="btn waves-effect">Sign in</button><span class="signin-notacc flow-text">If you have not account click <a href="signup.html">here</a></span>
          </div>
        </form>
      </div>
    </div>
  </section>
  <script src="libs/jquery.min.js"></script>
  <script src="libs/materialize/js/materialize.min.js"></script>
  <script src="js/common.js"></script>
</body>