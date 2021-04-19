$(document).ready(function(){
$("#addpatient").click(function(){
var id=$("#pid").val();
var pwd=$("#pwd").val();
var role="Patient";

if(id==""){
alert("Please Enter Patient ID");
$("#pid").focus();
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