var emailValid = false;

$(document).ready(() => {
	
	$("footer li a").attr("target","_blank");
	
	$("#login-form").submit((event) => {
        event.preventDefault();
        login_form_submit();

    });
	
    $("#registrar-form").submit((event) => {
        event.preventDefault();
        registrar_form_submit();

    });
    

}); 

function login_form_submit(){
	
	const tipoUsuarioCliente = {
			tipoUsuarioID: 0,
			nombreTipoUsuario: "none",
			estado: "none"
	}
	
	const usuario = {
    		nombre: "nombre",
    	    apellido: "apellido",
    	    username: "username",
    	    telefono: "123456789",
    	    usrPassword: $("#password-login").val(),
			email: $("#email-login").val(),
			estado: "Activo",
    	    sexo: "M",
    	    tipoUsuario: tipoUsuarioCliente
    }

    $.ajax({
        type: "POST",
        url: "/login",
        contentType: "application/json",
        data: JSON.stringify(usuario),
        dataType: 'json',
        cache: false,
        async: "false",
        success: (data) => {
         
        	
            if(data.result!=null){
            	 let email = data.result.email;
                 let domain = email.replace(/.*@/, "");
                 
                 if(domain == "aprumed.pe"){
                 	window.location.href = "/dashboard";
                 }
                 else{
                 	window.location.href = "/";
                 }
                 $("#loginVal").addClass("passive");
            }
            else{
            	 $("#loginVal").removeClass("passive");
            }
          

        },
        error: (e) => {
        	console.log(e);
        }
    });
}

function registrar_form_submit() {
	
	let email = $("#email").val();
	let domain = email.replace(/.*@/, "");
	
	var tipoUsuarioId = 1;
	
	if(domain == "aprumed.pe"){
		tipoUsuarioId = 2;
	}
	
	const tipoUsuarioCliente = {
			tipoUsuarioID: tipoUsuarioId,
			nombreTipoUsuario: "Cliente",
			estado: "Activo"
	}
	
	const usuario = {
    		nombre: $("#nombre").val(),
    	    apellido: $("#apellido").val(),
    	    username: $("#username").val(),
    	    telefono: $("#phone").val(),
    	    usrPassword: $("#password").val(),
			email: $("#email").val(),
			estado: "Activo",
    	    sexo: $("input[name='sex']").val(),
    	    tipoUsuario: tipoUsuarioCliente
    }

    if(!validarUsuario()){
    	$("#regVal").removeClass("passive");
    }
    else{
    	$("#regVal").addClass("passive");
    	$.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/registrarUsuario",
            data: JSON.stringify(usuario),
            dataType: 'json',
            cache: false,
            async: "false",
            success: (data) => {

            	$("#registrarAcc-form").append(`
                        <input type="hidden" class="form-control" id="usr" value="${usuario.dni}"/>
                         `);
                $("#btn-registrar-usr").prop("disabled", false);
                $("#regUserModal").modal('hide');
                $("#regUserAccModal").modal('show');

            },
            error: (e) => {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
                $("#btn-registrar-usr").prop("disabled", false);

            }
        });
    }
}

//Validar email
$("#email").blur(() => {
	
    let email = $("#email").val();

    if(email == "" || email == null){
    	$("#emailVal").removeClass("emailval");
    	$("#emailVal").removeClass("passive");
        $("#emailVal").addClass("required");
        $("#email").addClass("validator");
    }
    else{
    	$.ajax({
        url: "/verificarEmail",
        type: "POST",
        contentType: "application/json",
        async: "false",
        data: email,
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
    
    $("#emailVal.required").text("Complete este campo");
    $("#emailVal.emailval").text("Este email ya está en uso");
    
});

function validarUsuario(){
	let valid = false;
	nombre = $("#nombre").val();
    apellido = $("#apellido").val();
    telefono = $("#phone").val();
    usrPassword = $("#password").val();

    if(nombre == "" || nombre == null){
    	valid = false;
    }
    else if(apellido == "" || apellido == null){
    	valid = false;
    }
    else if(telefono == "" || telefono == null){
    	valid = false;
    }
    else if(usrPassword == "" || usrPassword == null){
    	valid = false;
    }
    else if(!emailVal){
    	valid = false;
    }
    else{
    	valid = true;
    }
    
    return valid;
}