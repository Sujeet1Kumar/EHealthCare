<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
	<p:redirect url="index.jsp"></p:redirect>
</p:if>
<%@include file="nav.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Feedback</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="js/feedback.js"></script>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>

	<div class="row">
		<div class="col-sm-1">
		</div>
		<div class="col-sm-5">
			<img src="images/feedback.jpeg" width=100% height=50%>
		</div>

		<div class="col-sm-5" style="text-align: center">
			<div>The feedback form is used for any type of user, clients,
				customer to rate an event and provide feedback by using this form.
				This event feedback form template captures all relevant feedback
				information and allows improving your event services.</div>
			<br>
			<div>
				<div>
					<label class="float-left">Patient Id : </label> <label for="pid"
						class="float-left" id="pid">${sessionScope.login.id}</label> <label
						for="pname" class="float-right" id="pname">${sessionScope.patient.name}</label>
					<label class="float-right">Patient Name : </label>
				</div><br>
					<div class="ui-widget">
		Doctor Name: <input id="dname" placeholder="Enter Doctor Name...">
	</div>
	
				<div style="text-align: center;">
				<label for="rate" id="rate">Please Select Your Rate Out Of 5 : </label>
				<br>
					<div class="form-check-inline">
						<input type="radio" class="form-check-input" id="radio1"
							name="optradio" value="1">1
					</div>
					<div class="form-check-inline">
						<input type="radio" class="form-check-input" id="radio2"
							name="optradio" value="2">2
					</div>
					<div class="form-check-inline">
						<input type="radio" class="form-check-input" id="radio3"
							name="optradio" value="3">3
					</div>
					<div class="form-check-inline">
						<input type="radio" class="form-check-input" id="radio4"
							name="optradio" value="4">4
					</div>
					<div class="form-check-inline">
						<input type="radio" class="form-check-input" id="radio5"
							name="optradio" value="5">5
					</div>
				</div>

				<div style="text-align: center">
					<textarea style="resize: none" id="comment" name="feed" rows="10"
						cols="80" placeholder="Enter Your Review Here"></textarea>
				</div>
				<br>
				<div style="text-align: center;">
					<button type="button" style="text-align: center;"
						class="btn btn-outline-primary" id="submit">Feedback</button>
				</div>
			</div>
		</div>
		<div class="col-sm-1">
		</div>
		
	</div>
</body>
</html>