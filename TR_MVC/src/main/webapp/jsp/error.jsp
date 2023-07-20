<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>

<body>

    <header class="bg-dark d-flex flex-wrap justify-content-center px-4 py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            <span class="fs-4 text-white">Gestion Talento Humano</span>
        </a>


    </header>


    <div class="text-center">
        <h1 class="fs-1 text-secondary">Algo fue mal!!</h1>
        <p class="fs-4 text-danger">
            <c:out value="${mensaje}" />
        <p>

            <a href="index.html">Regresar al Menu principal</a>
    </div>

</body>

</html>