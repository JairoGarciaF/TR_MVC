<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <title>Create Task</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">


</head>

<body class="">
    <header class="bg-dark d-flex flex-wrap justify-content-center px-4 py-3 mb-4 border-bottom">
        <a href="../AdminTareasController" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">

            <span class="fs-4 text-white">Administration</span>
        </a>

        <ul class="nav nav-pills">
            <li class="nav-item"><a href="#" class="nav-link active" aria-current="page">Sign out</a></li>

        </ul>
    </header>
    <main class="form-signin w-100 m-auto">
        <form action="EditarTareaController" method="POST">

            <h1 class="h3 mb-3 fw-normal">Edit task</h1>
			<input type="hidden" name="code" value="${code}">
            <div class="form-floating">
                <input type="text" name="nombre" class="form-control rounded" value="${nombreTarea}" id="floatingInput" placeholder="Name">
                <label for="floatingInput">Name</label>
            </div>
            <br>
            <select class="form-select" name="seleccion" aria-label="Default select example">
                
                <c:forEach items="${empleados}" var="empleado" varStatus="loop">
					<option value="${empleado.nombre}">${empleado.nombre}</option>
		         </c:forEach>
                
            </select>
            <br>


            <button class="btn btn-primary w-100 py-2" type="submit">Save</button>

        </form>
    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>



</body>

</html>