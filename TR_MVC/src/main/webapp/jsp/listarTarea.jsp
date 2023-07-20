<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tasks</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>

    <header class="bg-dark d-flex flex-wrap justify-content-center px-4 py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">

            <span class="fs-4 text-white">Task List</span>
        </a>

        <ul class="nav nav-pills">
            <li class="nav-item"><a href="#" class="nav-link active" aria-current="page">Sign out</a></li>

        </ul>
    </header>

    <div class="d-flex justify-content-between px-3">
        <h3>Welcome Name</h3>
    </div>

    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Code</th>
                <th scope="col">Name</th>
                <th scope="col">State</th>
                <th scope="col">Settings</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Task 1</td>
                <td>To do</td>
                <td><input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"></td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Task 2</td>
                <td>To do</td>
                <td><input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"></td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Task 3</td>
                <td>Done</td>
                <td><input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"></td>
            </tr>
        </tbody>
    </table>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>

</html>