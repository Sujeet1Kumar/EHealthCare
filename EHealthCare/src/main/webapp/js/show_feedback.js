$(document).ready(function(){
$("#deletefeedback").click(function(){
var pid = $("#pid").text();
var did = $("#did").text();
$.post("feedback",{
opt:"3",
pid:pid,
did:did,
});

alert("deletion successful");
location.reload();

});

});