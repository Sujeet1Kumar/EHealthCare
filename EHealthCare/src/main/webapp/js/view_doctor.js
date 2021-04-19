$(document).ready(function(){
$("#feedback").click(function(){
location.replace("view_feedback.jsp");
});

$("#deletedoctor").click(function(){
var did = $("#did").text();
alert("Deletion Successful");

$.post("doctor",{
opt:"5",
did:did,
});
location.reload();
});

$("#bookdoctor").click(function(){
var pid = $("#pid").text();
var did  = $("#did").text();
var status = "request";
alert("book doctor");
$.post("request",{
opt:"1",
pid:pid,
did:did,
status:status,

},function(response){
alert("Request Sent");
});

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