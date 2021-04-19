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
  <script src="js/doc_profile.js"></script>
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
	url : "doctor?opt=2",
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
<p:when test="${sessionScope.doctor.image!=''&& sessionScope.doctor.image!=null}">
<img src="profileimages/doctor/${sessionScope.doctor.image}" id="image" style="background-size: cover; width: 100%; height: 100%;">
</p:when>
<p:otherwise>
<img src="images/doctor.png">
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
<p:when test="${sessionScope.doctor!=null}">

<div id="1">

<div id="div1">


<h6 style="text-align: center">${sessionScope.doctor.name}</h6>
<hr>
<div class="hide" align="center">
<table class="tcol1">
<tr>
<td>Mobile</td>
<td>${sessionScope.doctor.mobile}</td>
</tr>
<tr>
<td>Email</td>
<td>${sessionScope.doctor.email}</td>
</tr>
<tr>
<td>Experience in Years</td>
<td>${sessionScope.doctor.exp}
</tr>
<tr>
<td>Qualification</td>
<td>${sessionScope.doctor.qual}</td>
</tr>
<tr>
<td>Specialization</td>
<td>${sessionScope.doctor.spec}</td>
</tr>
</table>
<br>

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
<label for="exp" style="color:#BA68C8">Experience in Years:</label>
    <input type="number" class="form-control" id="exp" placeholder="Enter Experience" name="exp">
	</div>
	</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="qual" style="color:#BA68C8">Qualification:</label>
    <input type="text" class="form-control" id="qual" placeholder="Enter Qualification" name="qual">
	</div>
	</div>
<div class="col-sm-6">
<div>
 <label for="spec" style="color:#BA68C8">Specialization:</label>
    <input type="text" class="form-control" id="spec" placeholder="Enter Specialization" name="spec">
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
    <input type="text" class="form-control" id="name" placeholder="Enter Full Name" name="name" value="${sessionScope.doctor.name}">
</div>
</div>

<div class="col-sm-6">
<div>
<label for="mobile" style="color:#BA68C8">Mobile:</label>
    <input type="number" class="form-control" id="mobile" placeholder="Enter Mobile No." name="mobile" value="${sessionScope.doctor.mobile}">
</div>
</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="email" style="color:#BA68C8">Email:</label>
    <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" value="${sessionScope.doctor.email}">
</div>
</div>

<div class="col-sm-6">
<div>
<label for="exp" style="color:#BA68C8">Experience in Years:</label>
    <input type="number" class="form-control" id="exp" placeholder="Enter Experience" name="exp" value="${sessionScope.doctor.exp}">
</div>
</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="qual" style="color:#BA68C8">Qualification:</label>
    <input type="text" class="form-control" id="qual" placeholder="Enter Qualification" name="qual" value="${sessionScope.doctor.qual}">
</div>
</div>

<div class="col-sm-6">
<div>
<label for="spec" style="color:#BA68C8">Specialization:</label>
    <input type="text" class="form-control" id="spec" placeholder="Enter Specialization" name="spec" value="${sessionScope.doctor.spec}">
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

