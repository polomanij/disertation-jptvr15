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
<body class="blue-grey lighten-2">
  <header class="header">
    <nav class="teal">
      <div class="wrapper">
        <div class="nav-wrapper"><a href="#" class="left brand-logo">Bookkeeping</a><a href="#" data-target="slide-out" class="right sidenav-trigger"><i class="material-icons">menu</i></a></div>
      </div>
    </nav>
  </header>
  <div class="content flow-text">
    <div class="wrapper">
      <div class="content-row">
        <section class="data">
          <h2>Your current data</h2>
          <div class="data-common">
            <div class="data-common-item">
              <p class="data-common-title">Credit: <span class="data-common-val">${credit} EUR</span></p>
            </div>
            <div class="data-common-item">
              <p class="data-common-title">Last expense: <span class="data-common-val">Title of expense, 150 EUR</span></p>
            </div>
            <div class="data-common-item">
              <p class="data-common-title">Last income: <span class="data-common-val">Title of income, 150 EUR</span></p>
            </div>
          </div>
          <h2>Add Income</h2>
          <div class="data-errors"></div>
          <div class="data-adding">
            <div class="data-adding-item">
                <select class="category-select income-adding-select">
                  <c:forEach var="income" items="${incomesCategories}">
                      <option>${income.name}</option>
                  </c:forEach>
              </select>
            </div>
            <div class="data-adding-item">
              <label for="income-sum" class="data-adding-label">Sum:</label>
              <div class="data-adding-input">
                <input id="income-sum" type="number" class="income-sum"/>
              </div>
            </div>
            <div class="data-adding-item">
              <input type="submit" value="Add income" class="btn income-send"/>
            </div>
          </div>
          <h2>Add expense</h2>
          <div class="data-errors"></div>
          <div class="data-adding">
            <div class="data-adding-item">
              <select class="category-select">
                  <c:forEach var="expense" items="${expensesCategories}">
                      <option>${expense.name}</option>
                  </c:forEach>
              </select>
            </div>
            <div class="data-adding-item">
              <label for="" class="data-adding-label">Sum:</label>
              <div class="data-adding-input">
                <input type="number" class="expense-sum"/>
              </div>
            </div>
            <div class="data-adding-item">
              <input type="submit" value="Add expense" class="btn expense-send"/>
            </div>
          </div>
        </section>
        <aside class="actions">
          <div class="actions-hello">
            <p>Hello, Name</p><a href="#">Logout</a>
          </div>
          <div class="actions-list">
            <h3 class="actions-list-title">Actions</h3>
            <ul>
              <li><a href="workspace.jsp">Home</a></li>
              <li><a href="category.jsp">Edit categories</a></li>
              <li><a href="#">Watch incomes</a></li>
              <li><a href="#">Watch expenses</a></li>
            </ul>
          </div>
        </aside>
        <aside id="slide-out" class="actions-mob sidenav">
          <div class="actions-hello">
            <p>Hello, Name</p><a href="#">Logout</a>
          </div>
          <div class="actions-list">
            <h3 class="actions-list-title">Actions</h3>
            <ul>
              <li><a href="workspace.html">Home</a></li>
              <li><a href="category.html">Edit categories</a></li>
              <li><a href="#">Watch incomes</a></li>
              <li><a href="#">Watch expenses</a></li>
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