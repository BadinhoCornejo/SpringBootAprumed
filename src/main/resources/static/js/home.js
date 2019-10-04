
$(document).ready(function () {
	
	$("#login-form").submit(function (event) {
        event.preventDefault();
        login_form_submit();

    });
	
    $("#registrar-form").submit(function (event) {
        event.preventDefault();
        registrar_form_submit();

    });

}); 

$("#btn-registrar-usr-cancelar").click(()=>{
	$('#regUserModal').modal('hide');
})

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

    $("#btn-login-usr").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/login",
        data: JSON.stringify(usuario),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {


            $("#btn-registrar-usr").prop("disabled", false);
            
            let email = data.result.email;
            let domain = email.replace(/.*@/, "");
            
            if(domain == "aprumed.pe"){
            	window.location.href = "/dashboard";
            }
            else{
            	window.location.href = "/";
            }

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-registrar-usr").prop("disabled", false);

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

    $("#btn-registrar-usr").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/registrarUsuario",
        data: JSON.stringify(usuario),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

        	$("#registrarAcc-form").append(`
                    <input type="hidden" class="form-control" id="usr" value="${usuario.dni}"/>
                     `);
            $("#btn-registrar-usr").prop("disabled", false);
            $("#regUserModal").modal('hide');
            $("#regUserAccModal").modal('show');

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-registrar-usr").prop("disabled", false);

        }
    });
}
