<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Sub Accounts</title>
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
    <jsp:include page="/views/header.jsp" />
    <div class="container-fluid">
        <div class="row justify-content-start ">
            <div class="col-8 border bg-light px-4">
                <h3>Список sub account</h3>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Код</th>
                        <th scope="col">name</th>
                        <th scope="col">number</th>
                        <th scope="col">account plan id</th>
                        <th scope="col">Редактировать</th>
                        <th scope="col">Удалить</th>
                    </tr>
                    </thead>
                    <tbody>
                    <jsp:useBean id="subAccounts" scope="request" type="java.util.List"/>
                    <c:forEach var="subAccount" items="${subAccounts}">
                        <tr>
                            <td>${subAccount.getId()}</td>
                            <td>${subAccount.getName()}</td>
                            <td>${subAccount.getNumber()}</td>
                            <td>${subAccount.getAccountId()}</td>
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
                <form method="POST" action="">
                    <h3>Новый sub account</h3>
                    <div class="mb-1">
                        <br> <label for="name"
                                    class="col-sm-3 col-form-label">Name</label>
                        <div class="col-sm-6">
                            <input type="text" name="inputName" class="form-control" id="name" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="number"
                                    class="col-sm-3 col-form-label">Number</label>
                        <div class="col-sm-6">
                            <input type="number" name="inputNumber" class="form-control" id="number" />
                        </div>
                    </div>
                    <div class="mb-1">
                        <br> <label for="accountPlan"
                                    class="col-sm-3 col-form-label">Account name</label>
                        <div class="col-sm-6">
                            <select name="accountPlan" class="form-control" id="accountPlan">
                                <option>Выберите Account name</option>
                                <jsp:useBean id="accountPlans" scope="request" type="java.util.List"/>
                                <c:forEach var="accountPlan" items="${accountPlans}">
                                    <option value="${accountPlan}">
                                        <c:out value="${accountPlan.getName()}"></c:out>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>


                    <p>
                        <br> <br> <br>
                        <button type="submit" class="btn btn-primary">Добавить</button>
                        <br>
                    </p>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>
