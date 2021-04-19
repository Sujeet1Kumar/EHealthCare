<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<%@include file="nav.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>View Patient</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/view_patient.js"></script>
</head>
<body>
<div class="container">
  <h1 style="text-align:center">View Patient</h1>
<p:forEach items="${sessionScope.patients}" var="patient">
  <div class="row">
  <div class="col-sm-4">
<p:choose>
  <p:when test="${patient.image!=null && patient.image!=''}">
  <img src="images/pat.jpg" width="100%" height="50%">
</p:when>
  <p:otherwise>
  <img src="images/pat.jpg" width="100%" height="50%">
  </p:otherwise>
  </p:choose>
  </div>
  <div class="col-sm-4">
  	  <label>Patient Id :</label>
      <label for="pid" id="pid">${patient.id}</label>
	  <br>
	  <label for="name">Name: ${patient.name}</label>
	  <br>
	  <label for="mobile">Mobile: ${patient.mobile}</label>
	  <br>
	  <label for="email">Email: ${patient.email}</label>
	  <br>
	  <label for="address">Address: ${patient.address}</label>
	  <br>
	  <label for="gender">Gender: ${patient.gender}</label>
	  <br>
	  <label for="issue">Issue: ${patient.issue}</label>
  </div>
  <div class="col-sm-4">
  <p:choose>
<p:when test="${sessionScope.login.role=='Admin'}">
  <button type="button" class="btn btn-info" id="review">Review Patient</button>
  <button type="button" class="btn btn-danger" id="deletepatient">Delete Patient</button>
  </p:when>
<p:when test="${sessionScope.login.role=='Doctor'}">
  <button type="button" class="btn btn-success" id="acceptpatient">Accept Patient</button>
  <button type="button" class="btn btn-dark" id="notnow">Not Now</button>
  <button type="button" class="btn btn-info" id="chat">Chat</button>
</p:when>
<p:otherwise>
Something went wrong , Try Again Later
  </p:otherwise>
  </p:choose>
  </div>
</div>
</p:forEach>

</div>

</body>
</html>