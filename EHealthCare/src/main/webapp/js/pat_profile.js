$(document).ready(function(){
  $("#toggle").click(function(){
  alert("hit");
    $("#2").slideToggle();
  });
  
$("#update").click(function(){
var id=$("#id").text();
var name=$("#name").val();
var mobile=$("#mobile").val();
var email=$("#email").val();
var address=$("#address").val();
var gender=$("#gender").val();
var issue=$("#issue").val();

if(name==""){
alert("Please Enter Name");
$("#name").focus();
}

else if(mobile==""){
alert("Please Enter Mobile");
$("#mobile").focus();
}

else if(email==""){
alert("Please Enter Email");
$("#email").focus();
}

else if(address==""){
alert("Please Enter Address");
$("#address").focus();
}

else if(gender==""){
alert("Please Enter Gender");
$("#gender").focus();
}

else if(issue==""){
alert("Please Enter Issue");
$("#issue").focus();
}

else{
$.post("patient",{
opt:"1",
id:id,
name:name,
mobile:mobile,
email:email,
address:address,
gender:gender,
issue:issue,
},function(response){
alert(response);
location.reload();
});
}
});
});