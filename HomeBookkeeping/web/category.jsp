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
        <section class="data category-edit">
          <h2>Create category</h2>
          <div class="data-adding">
            <div class="data-adding-item">
              <label for="" class="data-adding-label">Title:</label>
              <div class="data-adding-input">
                  <input type="text" class="new-category-title"/>
              </div>
            </div>
            <div class="data-adding-item">
              <label for="" class="data-adding-label">Type:</label>
              <select class="category-type-select new-category-type">
                <option>Income</option>
                <option>Expense</option>
              </select>
            </div>
            <div class="data-adding-item">
                <button class="btn create-category">Create</button>
            </div>
          </div>
          <h2>Edit categories</h2>
          <div method="post" name="category-edit" class="category-change">
            <div class="category-type">
              <select class="category-type-select category-change-type">
                <option>Income</option>
                <option>Expense</option>
              </select>
            </div>
            <div class="category-change-select">
              <select class="category-select changing-category">
                  <c:forEach var="income" items="${incomesCategories}">
                      <option>${income.name}</option>
                  </c:forEach>
              </select>
            </div>
            <div class="category-rename">
              <div class="category-rename-val">
                <label for="" class="data-adding-label">New title:</label>
                <div class="category-rename-input">
                  <input type="text"/>
                </div>
              </div>
              <button class="btn send-rename">Rename</button>
            </div>
            <div class="category-delete">
              <button class="btn send-deactivate yellow darken-2">Deactivate</button>
              <button class="btn send-delete red darken-3">Delete</button>
            </div>
          </div>
          <h2>Inactive categories edit</h2>
          <div class="category-change">
            <div class="category-type">
              <select class="category-type-select category-deactivate-type">
                <option>Income</option>
                <option>Expense</option>
              </select>
            </div>
            <div class="category-change-select">
              <select class="category-select inactive-categories">
                  <c:forEach var="income" items="${inactiveCategories}">
                      <option>${income.name}</option>
                  </c:forEach>
              </select>
            </div>
            <div class="category-delete">
              <button class="btn send-activate yellow darken-3">Activate</button>
              <button class="btn send-inactivate-delete red darken-3">Delete</button>
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
              <li><a href="controller?action=workspace">Home</a></li>
              <li><a href="controller?action=category">Edit categories</a></li>
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
              <li><a href="controller?action=workspace">Home</a></li>
              <li><a href="controller?action=category">Edit categories</a></li>
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
