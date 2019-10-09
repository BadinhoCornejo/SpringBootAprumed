$(document).ready(() => {
	
	$("#portada-form").submit((event) => {
        event.preventDefault();
        portada_form_submit();

    });


}); 

function portada_form_submit(){
	
	let url = $("#portada_url").val();
	
	$.ajax({
	    url: "/buscarPortada",
	    type: "POST",
	    contentType: "application/json",
	    async: "false",
	    data: url,
	    cache: false,
	    success: (data) => {
	    	
	        if (data.result != null) {
	        	
	            $("#emailVal").addClass("emailval");
	            $("#emailVal").removeClass("required");
	            $("#emailVal").removeClass("passive");
	            $("#email").addClass("validator");
	            
	            emailVal = false;
	        }
	        else {
	        	$("#emailVal").removeClass("emailval");
	            $("#emailVal").addClass("required");
	            $("#emailVal").addClass("passive");
	            $("#email").removeClass("validator");
	            
	            emailVal = true;
	        }

	    },

	    error: (errormessage) => {

	    }

	});
}

