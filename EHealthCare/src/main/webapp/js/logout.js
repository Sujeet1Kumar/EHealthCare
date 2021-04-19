$(document).ready(function(){
$(".logout").click(function(){
$.post("login",{
opt:"3",
},function(response){
if(response="Successfully Logout"){
alert(response);
location.reload();
}
});
});
});