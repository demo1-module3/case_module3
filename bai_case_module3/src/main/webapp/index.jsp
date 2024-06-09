<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <style>
    /* Tùy chỉnh CSS */
    .search-box {
      position: relative;
    }
    .search-box input[type="text"] {
      width: 100%;
      padding: 10px;
      border-radius: 25px;
      border: 1px solid #ccc;
      outline: none;
    }
    .search-box button {
      position: absolute;
      right: 0;
      top: 0;
      padding: 10px;
      border: none;
      background-color: transparent;
      outline: none;
      cursor: pointer;
    }
  </style>
</head>
  <body>
  <%--<h1><%= "Hello World!" %></h1>--%>
  <%--<br/>--%>
  <%--<a href="hello-servlet">Hello Servlet</a>--%>
  <%--<hr>--%>
  <%--<a href="category/list">danh sách danh mục sản phẩm</a>--%>
  <%--<hr>--%>
  <%--<a href="supplier/list">danh sách Nhà sản xuất</a>--%>
  <%--<hr>--%>
  <%--<a href="verityMoney/list">danh sách Xác Nhận tiền</a>--%>
  <%--<hr>--%>
  <%--<a href="user/list">danh sách người dùng</a>--%>
  <%--<hr>--%>
  <%--<a href="billDetail//list">danh sách hóa đơn chi tiết</a>--%>
  <%--<hr>--%>
  <%--<a href="bill/list">danh sách hóa đơn</a>--%>
  <%--<hr>--%>
  <%--<a href="cart/list">danh sách giỏ hàng</a>--%>
  <%--<hr>--%>
  <%--<a href="cartDetail/list">danh sách chi tiết giỏ hàng</a>--%>
  <%--<hr>--%>
  <%--<a href="product/list">danh sách sản phẩm</a>--%>
  <%--<hr>--%>
  <%--<a href="auth/login">đăng nhập</a>--%>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container" style="background-color: rgb(251,85,49)">
      <a class="navbar-brand" href="#">
        <img src="image/img.png" alt="Logo">
      </a>
      <div class="search-box">
        <input type="text" placeholder="Tìm kiếm...">
        <button type="submit"><i class="bi bi-search"></i></button>
      </div>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <section>
    <div class="container mt-5 pt-5">
      <div class="row">
        <div class="col-12 col-sm-7 col-md-6 m-auto">
          <div class="card border-0 shadow">
            <div class="card-body">
              <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
              </svg>
              <form action="/auth/login" method="post">
                <input type="text" name="username" class="form-control my-4 py-2" placeholder="Username" />
                <input type="password" name="password" class="form-control my-4 py-2" placeholder="Password" />
                <div class="text-center mt-3">
                  <button type="submit" class="btn btn-primary">Login</button>
                  <a href="user/create" class="nav-link">Already have an account ?</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
  </body>
</html>