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
<form method="POST" action="">
  <h3>Новый operation</h3>
  <div class="">
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
    <br> <label for="type"
                class="col-sm-3 col-form-label">type</label>
    <div class="col-sm-6">
      <input type="text" name="inputType" class="form-control" id="type" />
    </div>
  </div>
  <div class="mb-3">
    <br> <label for="sum"
                class="col-sm-3 col-form-label">sum</label>
    <div class="col-sm-6">
      <input type="number" step="any" name="inputSum" class="form-control" id="sum" />
    </div>
  </div>
  <div class="mb-3">
    <br> <label for="saldoInput"
                class="col-sm-3 col-form-label">saldoInput</label>
    <div class="col-sm-6">
      <input type="number" step="any" name="inputSaldoInput" class="form-control" id="saldoInput" />
    </div>
  </div>
  <div class="mb-3">
    <br> <label for="saldoOutput"
                class="col-sm-3 col-form-label">saldoOutput</label>
    <div class="col-sm-6">
      <input type="number" step="any" name="inputSaldoOutput" class="form-control" id="saldoOutput" />
    </div>
  </div>
  <div class="mb-3">
    <br> <label for="deal"
                class="col-sm-3 col-form-label">deal agreement</label>
    <div class="col-sm-6">
      <select name="deal" class="form-control" id="deal">
        <option>Выберите deal agreement</option>
        <jsp:useBean id="deals" scope="request" type="java.util.List"/>
        <c:forEach var="deal" items="${deals}">
          <option value="${deal}">
            <c:out value="${deal.getAgreement()}"></c:out>
          </option>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="mb-3">
    <br> <label for="subAccount"
                class="col-sm-3 col-form-label">sub account name</label>
    <div class="col-sm-6">
      <select name="subAccount" class="form-control" id="subAccount">
        <option>Выберите sub account name</option>
        <jsp:useBean id="subAccounts" scope="request" type="java.util.List"/>
        <c:forEach var="subAccount" items="${subAccounts}">
          <option value="${subAccount}">
            <c:out value="${subAccount.getName()}"></c:out>
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
</body>
</html>