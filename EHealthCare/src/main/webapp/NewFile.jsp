<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<div><%@include file="nav.jsp" %></div>
<script type="text/javascript" src="js/profile.js"></script>
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
	}
	});
	});
	});
</script>
<br>
<div>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-4">
<p align="center">
<p:choose>
<p:when test="${sessionScope.doctor.image!='')&&$(sessionScope.doctor.image!=null}">
<img src="images/doc.jpg" ${sessionScope.doctor.image}" id="image">
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

<p:choose>
<p:when test="$(sessionScope.doctor!=null}">
<div id="detail">
<h1 style="text-align: center">${sessionScope.doctor.name}</h1>
<hr>
<div class="hide">
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
<td>Experience</td>
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
<div align="center">
<input type="button" id="slideup" class="btn btn-primary" value="Edit Profile" />
</div>
</div>
</div>
</p:when>
<p:otherwise>

<div align="center">
<div align="center">
<i style='font-size:24px; border-color:green; background-color: black; color: white;' class='fas' id="down">&#xf358;</i>
</div>
<hr>
<h3 style="align:center" id="id">${sessionScope.login.id}</h3>
<hr>
<div class="row">
<div class="col-sm-6">
<div>
<label for="Name" style="color:#BA68C8">Full Name:</label>
    <input type="text" class="form-control" id="ename" placeholder="Enter Full Name" name="name">
	</div>
	</div>
<div class="col-sm-6">
<div>
<label for="mobile" style="color:#BA68C8">Mobile:</label>
    <input type="number" class="form-control" id="emobile" placeholder="Enter Mobile No." name="mobile">
	</div>
	</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="email" style="color:#BA68C8">Email:</label>
    <input type="email" class="form-control" id="eemail" placeholder="Enter Email" name="email">
	</div>
    </div>
<div class="col-sm-6">
<div>
<label for="exp" style="color:#BA68C8">Experience:</label>
    <input type="text" class="form-control" id="eexp" placeholder="Enter Experience" name="exp">
	</div>
	</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="qual" style="color:#BA68C8">Qualification:</label>
    <input type="text" class="form-control" id="equal" placeholder="Enter Qualification" name="qual">
	</div>
	</div>
<div class="col-sm-6">
<div>
 <label for="spec" style="color:#BA68C8">Specialization:</label>
    <input type="text" class="form-control" id="espec" placeholder="Enter Specialization" name="spec">
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

<div style="display : none;">
<div align="center">
<i style='font-size:24px; border-color:green; background-color: black; color: white;' class='fas' id="down">&#xf358;</i>

</div>
<hr>
<h3 style="text-align:center;" id="id">${sessionScope.login.in}</h3>
<hr>
<div class="row">
<div class="col-sm-6">
<div>

<label for="Name" style="color:#BA68C8">Full Name:</label>
    <input type="text" class="form-control" id="ename" placeholder="Enter Full Name" name="name" value="${sessionScope.doctor.name}">
</div>
</div>

<div class="col-sm-6">
<div>
<label for="mobile" style="color:#BA68C8">Mobile:</label>
    <input type="number" class="form-control" id="emobile" placeholder="Enter Mobile No." name="mobile" value="${sessionScope.doctor.mobile}">
</div>
</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="email" style="color:#BA68C8">Email:</label>
    <input type="email" class="form-control" id="eemail" placeholder="Enter Email" name="email" value="${sessionScope.doctor.email}">
</div>
</div>

<div class="col-sm-6">
<div>
<label for="exp" style="color:#BA68C8">Experience:</label>
    <input type="text" class="form-control" id="eexp" placeholder="Enter Experience" name="exp" value="${sessionScope.doctor.exp}">
</div>
</div>
</div>

<div class="row">
<div class="col-sm-6">
<div>
<label for="qual" style="color:#BA68C8">Qualification:</label>
    <input type="text" class="form-control" id="equal" placeholder="Enter Qualification" name="qual" value="${sessionScope.doctor.qual}">
</div>
</div>

<div class="col-sm-6">
<div>
<label for="spec" style="color:#BA68C8">Specialization:</label>
    <input type="text" class="form-control" id="espec" placeholder="Enter Specialization" name="spec" value="${sessionScope.doctor.spec}">
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

<div class="col-sm-1">
<hr>
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-8"> BLAH... BLAH...</div>
<div class="col-sm-2"></div>
</div>
</div>
</div>