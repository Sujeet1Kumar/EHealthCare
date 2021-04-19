<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<%@include file="nav.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Feedback</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/show_feedback.js"></script>
</head>
<body>

<div class="container">
  <h1 style="text-align:center">Feedback</h1>

<p:forEach items="${sessionScope.feedbacks}" var="feedback">

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
  	  <label for="feedback">Patient Name : ${feedback.pname}</label>
 	  <br>
 	  <label>Patient Id :</label>
      <label for="pid" id="pid">${feedback.pid}</label>
	  <br>
	  <label for="feedback">Doctor Name : ${feedback.dname}</label>
	  <br>
	  <label>Doctor Id :</label>
	  <label for="did" id="did">${feedback.did}</label>
	  <br>
	  <label for="rate">Rate out of 5 : ${feedback.rate}</label>
	  <br>
	  <label for="feedback">Comment : ${feedback.comment}</label>
 
  </div>
  <div class="col-sm-4">
  <p:choose>
<p:when test="${sessionScope.login.role=='Admin'}">
  <button type="button" class="btn btn-info" id="feedback">Feedback Doctor</button>
  <button type="button" class="btn btn-danger" id="deletefeedback">Delete Feedback</button>
</p:when>

  </p:choose>
  </div>
</div>

</p:forEach>

</div>

</body>
</html>