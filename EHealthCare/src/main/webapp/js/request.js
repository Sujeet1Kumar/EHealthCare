$(document).ready(function(){
  var id;
  var did = $("#did").text();
  $("table tbody .tr td").click(function() {
  	var text = $(this).find("button").text();
  	if (text == "") {

  	} else {
  		 id= $(this).closest(".tr").find('td.id').text();

  		if (text == "Accept") {
  			alert("Accept");
  			
$.post("request",{
opt:"3",
pid:id,
did:did,
status:"accepted",
},function(response){
location.reload();
});
  		}
  		else if (text == "Chat") {
  			alert("Chat");
  			
  			
  			
$.post("chatting",{
opt:"2",
},function(response){
location.replace("chatting.jsp");
});
  		}
  		else{
  			alert("Remove");
  			$.post("request",{
opt:"4",
pid:id,
did:did,
},function(response){
location.reload();
});
  		}
  }
  });

});