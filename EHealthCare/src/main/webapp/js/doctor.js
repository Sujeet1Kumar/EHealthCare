$(document).ready(function(){
$("#adddoctor").click(function(){
var id=$("#id").val();
var pwd=$("#pwd").val();
var role="Doctor";

if(id==""){
alert("Please Enter Doctor ID");
$("#id").focus();
}

else if(pwd==""){
alert("Please Enter Password");
$("#pwd").focus();
}

else{
$.post("login",{
opt:"2",
id:id,
pwd:pwd,
role:role,
},function(response){
alert(response);

});
}

});
});