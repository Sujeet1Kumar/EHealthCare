<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<%@include file="nav.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Profile</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="js/pat_profile.js"></script>
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<script type="text/javascript">
$(function(){
	$("#btnFile").click(function(){
	$("#file").trigger("click");
	});
	});

	$(document).ready(function(){
	$('#file').change(function(evt){

	var file = $(this).val();

	var form_data = new FormData();
	form_data.append("file", document.getElementById('file').files[0]);

	$.ajax({
	url : "patient?opt=2",
	type : "POST",
	cache : false,
	enctype : "multipart/form-data",
	contentType : false,
	processData : false,
	data : form_data,
	success : function(response){
	location.reload();
	alert(response);
	if(response="success"){
		location.reload();
	}
	}
	});
	});
	});
</script>
<br>
<div class="container">
<div class="row">
<div class="col-sm-6" style="height: 500px">
<p align="center">
<p:choose>
<p:when test="${sessionScope.patient.image!=''&& sessionScope.patient.image!=null}">
<img src="profileimages/patient/${sessionScope.patient.image}" id="image" style="background-size: cover; width: 100%; height: 100%;">
</p:when>
<p:otherwise>
<img src="images/patient.png">
</p:otherwise>
</p:choose>
</p>
<p align="center">
<input type="file" id="file" name="file" class="btn btn-primary"
value="Change Image" hidden style="width: 300px;"
onchange="PreviewImage()" /> <input type="button" id="btnFile"
class="btn btn-primary" value="Change Image" style="width: 300px;" />
</p>
</div>
<div class="col-sm-6">
<div style="display:none;" id="id">${sessionScope.login.id}</div>
<p:choose>
<p:when test="${sessionScope.patient!=null}">

<div id="1">

<div id="div1">


<h6 style="text-align: center">${sessionScope.patient.name}</h6>
<hr>
<div class="hide" align="center">
<table class="tcol1">
<tr>
<td>Mobile</td>
<td>${sessionScope.patient.mobile}</td>
</tr>
<tr>
<td>Email</td>
<td>${sessionScope.patient.email}</td>
</tr>
<tr>
<td>Address</td>
<td>${sessionScope.patient.address}
</tr>
<tr>
<td>Gender</td>
<td>${sessionScope.patient.gender}</td>
</tr>
<tr>
<td>Issue</td>
<td>${sessionScope.patient.issue}</td>
</tr>
</table><br>

</div>

<div align="center">
<i style='font-size:24px; border-color:green; background-color: black; color: white;' class='fas' id="toggle">&#xf0b2;</i>
</div>



</p:when>
<p:otherwise>

<div align="center" id="first">
<h3 style="align:center" id="id">${sessionScope.login.id}</h3>
<hr>
<div class="row">
<div class="col-sm-6">
<div>
<label for="Name" style="color:#BA68C8">Full Name:</label>
    <input type="text" class="form-control" id="name" placeholder="Enter Full Name" name="name">
</div>
</div>
<div class="col-sm-6">
<div>
<label for="mobile" style="color:#BA68C8">Mobile:</label>
    <input type="number" class="form-control" id="mobile" placeholder="Enter Mobile No." name="mobile">
</div>
</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="email" style="color:#BA68C8">Email:</label>
    <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email">
</div>
    </div>
<div class="col-sm-6">
<div>
<label for="address" style="color:#BA68C8">Address:</label>
    <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
</div>
</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="gender" style="color:#BA68C8">Gender:</label>
    <input type="text" class="form-control" id="gender" placeholder="Enter Gender" name="gender">
</div>
</div>
<div class="col-sm-6">
<div>
 <label for="issue" style="color:#BA68C8">Issue:</label>
    <input type="text" class="form-control" id="issue" placeholder="Enter Issue" name="issue">
</div>
</div>
</div>

<br>
<div align="center">
<button type="button" class="btn btn-primary" id="update">Update Profile</button>
</div>
</div>
</p:otherwise>
</p:choose>



</div>

</div>


<div id="2" style="display:none;">


<div id="div2">


<div align="center">
</div>


<div class="row">
<div class="col-sm-6">
<div>

<label for="Name" style="color:#BA68C8">Full Name:</label>
    <input type="text" class="form-control" id="name" placeholder="Enter Full Name" name="name" value="${sessionScope.patient.name}">
</div>
</div>

<div class="col-sm-6">
<div>
<label for="mobile" style="color:#BA68C8">Mobile:</label>
    <input type="number" class="form-control" id="mobile" placeholder="Enter Mobile No." name="mobile" value="${sessionScope.patient.mobile}">
</div>
</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="email" style="color:#BA68C8">Email:</label>
    <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" value="${sessionScope.patient.email}">
</div>
</div>

<div class="col-sm-6">
<div>
<label for="address" style="color:#BA68C8">Address:</label>
    <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address" value="${sessionScope.patient.address}">
</div>
</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="gender" style="color:#BA68C8">Gender:</label>
    <input type="text" class="form-control" id="gender" placeholder="Enter Gender" name="gender" value="${sessionScope.patient.gender}">
</div>
</div>

<div class="col-sm-6">
<div>
<label for="issue" style="color:#BA68C8">Issue:</label>
    <input type="text" class="form-control" id="issue" placeholder="Enter Issue" name="issue" value="${sessionScope.patient.issue}">
</div>
</div>
</div>

<br>
<div align="center">
<button type="button" class="btn btn-primary" id="update">Update Profile</button>
</div>


</div>

</div>

</div>
</div>

</div>

</html>