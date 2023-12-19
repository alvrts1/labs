<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Operations</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Curren</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- jQuery -->
    <script defer src="js/jquery-3.6.4.js"></script>
    <!-- Bootstrap JS + Popper JS -->
    <script defer src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="/views/header.jsp"/>
    <div class="container-fluid"  >
        <div class="row justify-content-start">
            <div class="col-8 border bg-light px-4">
                <h3>Список operation</h3>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Код</th>
                        <th scope="col">number</th>
                        <th scope="col">date</th>
                        <th scope="col">type</th>
                        <th scope="col">sum</th>
                        <th scope="col">saldoInput</th>
                        <th scope="col">saldoOutput</th>
                        <th scope="col">dealId</th>
                        <th scope="col">subAccountID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <jsp:useBean id="operations" scope="request" type="java.util.List"/>
                    <c:forEach var="operation" items="${operations}">
                        <tr>
                            <td>${operation.getId()}</td>
                            <td>${operation.getNumber()}</td>
                            <td>${operation.getDate()}</td>
                            <td>${operation.getType()}</td>
                            <td>${operation.getSum()}</td>
                            <td>${operation.getSaldoInput()}</td>
                            <td>${operation.getSaldoOutput()}</td>
                            <td>${operation.getDealId()}</td>
                            <td>${operation.getSubAccountId()}</td>

                            <td width="20"><a href="#" role="button" class="btn btn-outline-primary">
                                <img alt="Редактировать" src="${pageContext.request.contextPath}/images/icon-edit.png" width="20" height="20"></a></td>
                            <td width="20"><a href="#" role="button" class="btn btn-outline-primary">
                                <img alt="Удалить" src="${pageContext.request.contextPath}/images/icon-delete.png" width="20" height="20"></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-4 border px-4">
                <jsp:include page="/views/form.jsp" />
            </div>
        </div>
    </div>
    <jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>
