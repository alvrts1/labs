<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Deals</title>
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
                <h3>Список deal</h3>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Код</th>
                        <th scope="col">agreement</th>
                        <th scope="col">tiker</th>
                        <th scope="col">order</th>
                        <th scope="col">number</th>
                        <th scope="col">date</th>
                        <th scope="col">quantity</th>
                        <th scope="col">price</th>
                        <th scope="col">totalCost</th>
                        <th scope="col">trader</th>
                        <th scope="col">commission</th>
                        <th scope="col">Редактировать</th>
                        <th scope="col">Удалить</th>
                    </tr>
                    </thead>
                    <tbody>
                    <jsp:useBean id="deals" scope="request" type="java.util.List"/>
                    <c:forEach var="accountPlan" items="${deals}">
                        <tr>
                            <td>${accountPlan.getId()}</td>
                            <td>${accountPlan.getAgreement()}</td>
                            <td>${accountPlan.getTiker()}</td>
                            <td>${accountPlan.getOrder()}</td>
                            <td>${accountPlan.getNumber()}</td>
                            <td>${accountPlan.getDate()}</td>
                            <td>${accountPlan.getQuantity()}</td>
                            <td>${accountPlan.getPrice()}</td>
                            <td>${accountPlan.getTotalCost()}</td>
                            <td>${accountPlan.getTrader()}</td>
                            <td>${accountPlan.getCommission()}</td>
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
                    <h3>Новый deal</h3>
                    <div class="mb-1">
                        <br> <label for="agreement"
                                    class="col-sm-3 col-form-label">agreement</label>
                        <div class="col-sm-6">
                            <input type="text" name="inputAgreement" class="form-control" id="agreement" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="tiker"
                                    class="col-sm-3 col-form-label">tiker</label>
                        <div class="col-sm-6">
                            <input type="text" name="inputTiker" class="form-control" id="tiker" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="order"
                                    class="col-sm-3 col-form-label">order</label>
                        <div class="col-sm-6">
                            <input type="text" name="inputOrder" class="form-control" id="order" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="number"
                                    class="col-sm-3 col-form-label">number</label>
                        <div class="col-sm-6">
                            <input type="number" name="inputNumber" class="form-control" id="number" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="date"
                                    class="col-sm-3 col-form-label">date</label>
                        <div class="col-sm-6">
                            <input type="text" name="inputDate" class="form-control" id="date" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="quantity"
                                    class="col-sm-3 col-form-label">quantity</label>
                        <div class="col-sm-6">
                            <input type="number" name="inputQuantity" class="form-control" id="quantity" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="price"
                                    class="col-sm-3 col-form-label">price</label>
                        <div class="col-sm-6">
                            <input type="number" step="any" name="inputPrice" class="form-control" id="price" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="totalCost"
                                    class="col-sm-3 col-form-label">totalCost</label>
                        <div class="col-sm-6">
                            <input type="number" step="any" name="inputTotalCost" class="form-control" id="totalCost" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="trader"
                                    class="col-sm-3 col-form-label">trader</label>
                        <div class="col-sm-6">
                            <input type="text" name="inputTrader" class="form-control" id="trader" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <br> <label for="commission"
                                    class="col-sm-3 col-form-label">commission</label>
                        <div class="col-sm-6">
                            <input type="number" step="any" name="inputCommission" class="form-control" id="commission" />
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
