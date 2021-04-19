<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>E Health Care</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/logout.js"></script>
  <script src="js/nav.js"></script>
</head>

<body>

<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<p:choose>
<p:when test="${sessionScope.login.role=='Admin'}">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand navbar-right" href="#">
    <img src="images/admin.png" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="add_doctor.jsp">Add Doctor</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="viewdoc">View Doctor</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="viewpat">View Patient</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="feedback">Feedback</a>
    </li>
    <li class="nav-item">
      <a class="nav-link logout" href="index.jsp">Logout</a>
    </li>
  </ul>
</nav>
</p:when>

<p:when test="${sessionScope.login.role=='Doctor'}">
<label id="did" style="display: none;">${sessionScope.login.id}</label>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="images/doctor.png" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="doc_profile.jsp">Profile</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="add_patient.jsp">Add Patient</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="viewpat">View Patient</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="request">Request</a>
    </li>
    <li class="nav-item">
      <a class="nav-link logout" href="index.jsp">Logout</a>
    </li>
  </ul>
</nav>

</p:when>
<p:when test="${sessionScope.login.role=='Patient'}">

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="images/patient.png" alt="logo" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="pat_profile.jsp">Profile</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" id="viewdoc">View Doctor</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="feedback.jsp">Feedback</a>
    </li>
    <li class="nav-item">
      <a class="nav-link logout" href="index.jsp">Logout</a>
    </li>
  </ul>
</nav>

</p:when>
<p:otherwise>
Something went wrong, Try Again Later</p:otherwise>
</p:choose>
</body>
</html>
