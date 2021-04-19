$(document).ready(function(){
$("#submit").click(function(){
var id=$("#id").val();
var pwd=$("#pwd").val();
var role=$("#role").val();

if(id==""){
alert("Please Enter ID");
$("#id").focus();
}

else if(pwd==""){
alert("Please Enter Password");
$("#pwd").focus();
}

else if(role=="Select From Below:"){
alert("Please Select Role");
$("#role").focus();
}

else{
$.post("login",{
opt:"1",
id:id,
pwd:pwd,
role:role,
},function(response){
if(response=="Successfully Login"){
alert("Welcome");
location.replace("nav.jsp");
}
else{
alert(response);
}

});
}


});
});