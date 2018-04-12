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
              <h3 class="flow-text">Credit:</h3><span class="curr-credit flow-text">150 euro</span><a href="#" class="btn add-money">Add</a>
            </div>
          </div>
          <h2 class="flow-text">Categories</h2>
          <div class="data-categories-row">
            <div class="data-categories">
              <select class="flow-text category-select">
                <option selected="selected">Choose category</option>
                <option value="1">option 1</option>
                <option value="2">option 2</option>
                <option value="3">option 3</option>
                <option value="4">option 4</option>
              </select>
              <input type="number" class="category-value"/>
            </div>
          </div>
        </section>
        <aside class="actions"></aside>
      </div>
    </div>
  </div>
  <script src="libs/jquery.min.js"></script>
  <script src="libs/materialize/js/materialize.min.js"></script>
  <script src="js/common.js"></script>
</body>