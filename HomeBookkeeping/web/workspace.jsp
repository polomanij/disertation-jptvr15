<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Category"%>
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
      <div class="wrapper">
        <div class="nav-wrapper"><a href="#" class="brand-logo">Bookkeeping</a></div>
      </div>
    </nav>
  </header>
  <div class="content">
    <div class="wrapper">
      <div class="content-row">
        <section class="data">
          <h2 class="flow-text">Your current data</h2>
          <div class="data-common">
            <div class="data-common-item">
              <h3 class="flow-text">Credit:</h3><span class="curr-credit flow-text">150 euro</span>
              <div class="add-money-val">
                <input type="text"/>
              </div><a href="#" class="btn add-money">Add</a>
            </div>
          </div>
          <h2 class="flow-text">Categories</h2>
          <div class="data-categories-row">
            <form action="" method="get" class="data-categories">
              <div class="data-categories-item">
                <select class="flow-text category-select">
                  <option selected="selected">Choose category</option>
                  <c:forEach var="category" items="${categories}">
                      <option value="${category.id}">${category.name}</option>
                  </c:forEach>
                </select>
              </div>
              <div class="data-categories-item category-value">
                <input type="number"/>
              </div>
              <div class="data-categories-item data-categories-submit">
                <input type="submit" value="Add" class="btn"/>
              </div>
            </form>
          </div>
        </section>
        <aside class="actions flow-text">
          <div class="actions-hello">
              <p>Hello, ${sessionScope.user.name}</p><a href="#">Logout</a>
          </div>
          <div class="actions-list">
            <h3 class="actions-list-title">Actions</h3>
            <ul>
              <li><a href="#">Action 1</a></li>
              <li><a href="#">Action 2</a></li>
              <li><a href="#">Action 3</a></li>
            </ul>
          </div>
        </aside>
      </div>
    </div>
  </div>
  <script src="libs/jquery.min.js"></script>
  <script src="libs/materialize/js/materialize.min.js"></script>
  <script src="js/common.js"></script>
</body>