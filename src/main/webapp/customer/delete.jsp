
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <p><a href="/customers">Back to list customer</a></p>
    <h1>Delete customer</h1>
    <form action="/customers?action=delete&id=${customer.getId()}" method="post">
        <div class="mb-3">
            <label  for="id" class="form-label">Id</label>
            <input name="id" type="text" class="form-control" id="id" value="${customer.getId()}" disabled>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input name="name" type="text" class="form-control" id="name" value="${customer.getName()}" disabled>
        </div>
        <div class="mb-3">
            <label class="form-label" for="email">Email</label>
            <input name="email" type="email" class="form-control" id="email" value="${customer.getEmail()}" disabled>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input name="address" type="text" class="form-control" id="address" value="${customer.getAddress()}" disabled>
        </div>
        <button type="submit" class="btn btn-danger">Delete</button>
    </form>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>

