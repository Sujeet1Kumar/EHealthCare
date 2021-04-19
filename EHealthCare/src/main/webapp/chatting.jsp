<!DOCTYPE html>
<html lang="en">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<p:if test="${sessionScope.login==null}">
<p:redirect url="index.jsp"></p:redirect>
</p:if>
<%@include file="nav.jsp" %>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="js/chatting.js"></script>

<script type="text/javascript">
var socket = new WebSocket("ws://localhost:8080/EHealthCare/chat");

socket.onmessage = function(event) {
	var c=document.getElementById('chatfield');
	c.innerHTML+=event.data+"\n";
};

function send() {
	document.getElementById("click").click();
	var m = socket.send("	Doctor : "+document.getElementById('message').value);
	document.getElementById('message').value = "";
}

function send2() {
	document.getElementById("click2").click();
	var m = socket.send("	Patient : "+document.getElementById('message').value);
	document.getElementById('message').value = "";
}
</script>
</head>
<div class="container" style="text-align:center">

<br><br>
    <p:choose>
    <p:when test="${sessionScope.login.role=='Doctor'}">
	<textarea style="resize:none;text-align: right" id="chatfield" name="feed" rows="10" cols="50" placeholder="Your Chat will display here" readonly="readonly">
	<p:forEach items="${sessionScope.chattings}" var="chattings">
	${chattings.message}
	</p:forEach>
	</textarea>
    <br><br>
    <textarea style="resize:none" id="message" name="feed2" rows="1" cols="50" placeholder="Enter Your Message Here"></textarea>
    <br><br>
    <input type="button" class="btn btn-primary" value="Send" onclick="send()">
    <button type="submit" style="display: none;" class="btn btn-primary mb-2" id="click">Send</button>
    </p:when>
    </p:choose>
    
    <p:choose>
    <p:when test="${sessionScope.login.role=='Patient'}">
    <textarea style="resize:none;text-align: left" id="chatfield" name="feed" rows="10" cols="50" placeholder="Your Chat will display here" readonly="readonly">
	<p:forEach items="${sessionScope.chattings}" var="chattings">
	${chattings.message}
	</p:forEach>
	</textarea>
    <br><br>
    <textarea style="resize:none" id="message" name="feed2" rows="1" cols="50" placeholder="Enter Your Message Here"></textarea>
    <br><br>
    <input type="button" class="btn btn-primary" value="Send" onclick="send2()">
    <button type="submit" style="display: none;" class="btn btn-primary mb-2" id="click2">Send</button>
    </p:when>
    </p:choose>
</div>
</html>