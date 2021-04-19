<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<%@include file="nav.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>View Doctor</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/view_doctor.js"></script>
</head>
<body>

<div class="container">
  <h1 style="text-align:center">View Doctor</h1>

<p:forEach items="${sessionScope.doctors}" var="doctor">

  <div class="row">
  <div class="col-sm-4">
  <p:choose>
  <p:when test="${doctor.image!=null && doctor.image!=''}">
  
  <img src="images/back2.jpg" width="100%" height="50%">
  </p:when>
  <p:otherwise>
  <img src="images/doc.jpg" width="100%" height="50%">
  </p:otherwise>
  </p:choose>
  </div>
  <div class="col-sm-4">
  	  <label>Doctor Id :</label>
      <label for="id" id="did">${doctor.id}</label>
	  <br>
	  <label for="name">Name: ${doctor.name}</label>
	  <br>
	  <label for="email">Mobile: ${doctor.mobile}</label>
	  <br>
	  <label for="email">Email: ${doctor.email}</label>
	  <br>
	  <label for="experience">Experience: ${doctor.exp}</label>
	  <br>
	  <label for="qualification">Qualification: ${doctor.qual}</label>
	  <br>
	  <label for="specialization">Specialization: ${doctor.spec}</label>
 
  </div>
  <div class="col-sm-4">
  <p:choose>
<p:when test="${sessionScope.login.role=='Admin'}">
  <button type="button" class="btn btn-info" id="feedback">Feedback Doctor</button>
  <button type="button" class="btn btn-danger" id="deletedoctor">Delete Doctor</button>
</p:when>
<p:when test="${sessionScope.login.role=='Patient'}">
<label id="pid" style="display: none;">${sessionScope.login.id}</label>

  <button type="button" class="btn btn-success" id="bookdoctor">Book Doctor</button>
  <button type="button" class="btn btn-dark" id="feedback">Feedback Doctor</button>
  <button type="button" class="btn btn-info" id="chat">Chat</button>
</p:when>
  
  </p:choose>
  </div>
</div>

</p:forEach>

</div>

</body>
</html>