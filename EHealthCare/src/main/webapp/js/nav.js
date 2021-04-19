$(document).ready(function(){
$("#viewdoc").click(function(){
alert("view doctor");

var id1 = $("#id").text();


$.post("doctor",{
opt:"4",
id:id1,

},function(response){
location.replace("view_doctor.jsp");
});


});

$("#viewpat").click(function(){
alert("view patient");
var id2 = $("#id").text();


$.post("patient",{
opt:"3",
id:id2,

},function(response){
location.replace("view_patient.jsp");
});

});

$("#feedback").click(function(){
alert("feedback");

$.post("feedback",{
opt:"2",

},function(response){
location.replace("show_feedback.jsp");
});

});

$("#request").click(function(){
alert("request");
var did = $("#did").text();
$.post("request",{
opt:"2",
did:did,

},function(response){
location.replace("request.jsp");
});

});

});