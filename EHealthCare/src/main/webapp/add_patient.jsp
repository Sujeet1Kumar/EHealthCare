<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<%@include file="nav.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Patient</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/patient.js">
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>

<div>
<h1 style="text-align: center;">Add Patient</h1>
  <div class="row">
    <div class="col-sm-6">
    <img src="images/addpatient.jpg">
    </div>
    <div class="col-sm-6" style="background-color:lavenderblush;">
    	    <div class="form-group">
    	    <h2>Add Patient Details:</h2>
      <label for="id">ID:</label>
      <input type="text" class="form-control" id="pid" placeholder="Enter Patient ID" name="pid">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter Patient Password" name="pswd">
    </div>
    <button type="button" class="btn btn-primary" id="addpatient">Add Patient</button>
  </div>
  </div>
</div>

</body>

</html>