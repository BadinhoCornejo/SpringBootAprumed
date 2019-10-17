
	$("#portada-form").submit((event) => {
        event.preventDefault();
        portada_form_submit();

    });


function portada_form_submit(){
	
	let portadaString = $("#portada_url").val();
	
	console.log(portadaString);
	
	if(portadaString == "" || portadaString == null){
		console.log("Nel perro");
	}
	else{
		$.ajax({
		    url: "/buscarPortada",
		    type: "POST",
		    contentType: "application/json",
		    async: "false",
		    data: portadaString,
		    cache: false,
		    success: (data) => {
		    	
		        if (data.result != null) {
		        	
		            $("#libro-portada").prop("src",data.result.url);
		            $("#urlPortada").val(data.result.url);
		        }
		        else {
		        	$("#portadaVal").removeClass("passive");
		        }

		    },

		    error: (errormessage) => {

		    }

		});
	}
	
	
}


