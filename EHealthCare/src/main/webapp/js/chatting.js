$(document).ready(function(){

$("#click").click(function(){
alert("hit");
var chatarea = $("#message").val();
$.post("chatting",{
opt:"1",
chatarea:"Doctor : " + chatarea,
},function(response){
$.post("chatting",{
opt:"2",
});
});
});

$("#click2").click(function(){
alert("hit");
var chatarea = $("#message").val();
$.post("chatting",{
opt:"1",
chatarea:"Patient : " + chatarea,
},function(response){
$.post("chatting",{
opt:"2",
});
});
});
});