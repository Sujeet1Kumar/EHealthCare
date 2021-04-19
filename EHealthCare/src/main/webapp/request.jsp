<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<%@include file="nav.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>View Requests</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/request.js"></script>

</head>
<body>

<div class="container">
<label id="did">${sessionScope.role.id}</label>
  <h1 style="text-align:center">View Requests</h1>
<p:forEach items="${sessionScope.requests}" var="request">
  <div class="row">
  <div class="col-sm-6">
<p:choose>
  <p:when test="${patient.image!=null && patient.image!=''}">
  <img src="images/pat.jpg" width="100%" height="50%">
</p:when>
  <p:otherwise>
  <img src="images/pat.jpg" width="100%" height="50%">
  </p:otherwise>
  </p:choose>
  </div>

  <div class="col-sm-6">
  <p:choose>
<p:when test="${request.status=='request'}">
		
		
		<table class="table table-hover">
								<thead>
									<tr>
										<th>Patient ID</th>
										<th>Status</th>
										<th>Remove</th>
									</tr>
								</thead>
								<tbody>

										<tr class="tr">
											<td class="id">${request.pid}</td>
											<td><button class="btn btn-primary">Accept</button></td>
											<td>
												<button class="btn btn-danger">Delete</button>
											</td>
										</tr>


								</tbody>
							</table>

  </p:when>
<p:when test="${request.status=='accepted'}">

		<table class="table table-hover">
								<thead>
									<tr>
										<th>Patient ID</th>
										<th>Status</th>
										<th>Remove</th>
									</tr>
								</thead>
								<tbody>

										<tr class="tr">
											<td class="id">${request.pid}</td>
											<td><button class="btn btn-success">Chat</button></td>
											<td>
												<button class="btn btn-danger">Delete</button>
											</td>
										</tr>


								</tbody>
							</table>

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