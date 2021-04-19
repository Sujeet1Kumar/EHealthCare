$(document).ready(function(){
$("#review").click(function(){
location.replace("view_feedback.jsp");
});

$("#deletepatient").click(function(){
var pid = $("#pid").text();
alert("Deletion Successful");

$.post("patient",{
opt:"4",
pid:pid,
});
location.reload("view_patient.jsp");
});


$("#acceptpatient").click(function(){
alert("accepted");
});

$("#notnow").click(function(){
alert("denied");
});

$("#chat").click(function(){
alert("chat");

$.post("chatting",{
opt:"2",

},function(response){
location.replace("chatting.jsp");

});

});
});