<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<%@include file="nav.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Doctor</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/doctor.js">
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>

<div class="container">
  <div class="row">
    <div class="col-sm-6" style="background-color:black; border:red; border-width:5px; border-style:solid;">
    <img src="images/adddoctor.jpg">
    </div>
    <div class="col-sm-6" style="background-color:black; border:red; border-width:5px; border-style:solid; align:center">
    	    <div class="form-group">
    	    <h2 style="color:#26C6DA">Add Doctor Details:</h2>
      <label for="id" style="color:#BA68C8">ID:</label>
      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
    </div>
    <div class="form-group">
      <label for="pwd" style="color:#BA68C8">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
    </div><button type="button" class="btn btn-primary" id="adddoctor">Add Doctor</button>
  </div>
  </div>
  </div>
</body>
</html>