$(document).ready(function() {

    $(function() {
        $("#dname").autocomplete({
            source: function(request, response) {
                $.ajax({
                    url: "doctor?opt=3",
                    type: "POST",
                    data: { term: request.term },

                    dataType: "json",

                    success: function(data) {
                        response(data);
                    }
               });              
            }   
        });
    });

	$("#submit").hide();
	$('.form-check-inline input[type="radio"]').click(function() {
		var demovalue = $(this).val();
		$("#submit").show();

	});

	$("#submit").click(function() {
		var pid = $("#pid").text();
		var rate = $("input:radio[name=optradio]:checked").val();
		var comment = $("#comment").val();
		var pname = $("#pname").text();
		var dname = $("#dname").val();
		var pimage = "";
		var dimage = "";
		
		if (dname == "") {
			alert("Please Enter Doctor Name");
			("#dname").focus();
		}

		else if (comment == "") {
			alert("Please Enter Some Feedback");
			("#comment").focus();
		}

		else {
			$.post("feedback", {
				opt: "1",
				pid: pid,
				rate: rate,
				comment: comment,
				pname: pname,
				dname: dname,
				pimage: pimage,
				dimage: dimage,
			}, function(response) {
				if (response == "") {
					alert("Feedback Post Successfully");
				}

				else {
					alert(response);
				}

			});
		}
	});
	
	    $(function() {
        $("#country").autocomplete({
            source: function(request, response) {
                $.ajax({
                    url: "country",
                    type: "POST",
                    data: { term: request.term },

                    dataType: "json",

                    success: function(data) {
                        response(data);
                    }
               });              
            }   
        });
    });
    
});