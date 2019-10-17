/* Otras validaciones de usuario */
$("#nombre").blur(()=>{
	nombre = $("#nombre").val();
	if(nombre == "" || nombre == null){
    	$("#nombreVal").removeClass("passive");
        $("#nombreVal").addClass("required");
        $("#nombre").addClass("validator");
    }
	else{
		$("#nombreVal").removeClass("required");
        $("#nombreVal").addClass("passive");
        $("#nombre").removeClass("validator");
	}
})

$("#apellido").blur(()=>{
	apellido = $("#apellido").val();
	if(apellido == "" || apellido == null){
    	$("#apellidoVal").removeClass("passive");
        $("#apellidoVal").addClass("required");
        $("#apellido").addClass("validator");
    }
	else{
		$("#apellidoVal").removeClass("required");
        $("#apellidoVal").addClass("passive");
        $("#apellido").removeClass("validator");
	}
})

$("#phone").blur(()=>{
	telefono = $("#phone").val();
	if(telefono == "" || telefono == null){
    	$("#phoneVal").removeClass("passive");
        $("#phoneVal").addClass("required");
        $("#phone").addClass("validator");
    }
	else{
		$("#phoneVal").removeClass("required");
        $("#phoneVal").addClass("passive");
        $("#phone").removeClass("validator");
	}
})

$("#password").blur(()=>{
	usrPassword = $("#password").val();
	if(usrPassword == "" || usrPassword == null){
    	$("#passwordVal").removeClass("passive");
        $("#passwordVal").addClass("required");
        $("#password").addClass("validator");
    }
	else{
		$("#passwordVal").removeClass("required");
        $("#passwordVal").addClass("passive");
        $("#password").removeClass("validator");
	}
})
