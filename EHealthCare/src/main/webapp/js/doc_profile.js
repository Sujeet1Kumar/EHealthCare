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
var exp=$("#exp").val();
var qual=$("#qual").val();
var spec=$("#spec").val();

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

else if(exp==""){
alert("Please Enter Experience");
$("#exp").focus();
}

else if(qual==""){
alert("Please Enter Qualification");
$("#qual").focus();
}

else if(spec==""){
alert("Please Enter Specialization");
$("#spec").focus();
}

else{
$.post("doctor",{
opt:"1",
id:id,
name:name,
mobile:mobile,
email:email,
exp:exp,
qual:qual,
spec:spec,
},function(response){
alert(response);
location.reload();
});
}
});
});