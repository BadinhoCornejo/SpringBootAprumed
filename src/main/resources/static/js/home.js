//Prevent modal close background
$('#regUserAccModal').modal({
    backdrop: 'static',
    keyboard: false,
    show: false
});

$(document).ready(function () {

    $("#registrar-form").submit(function (event) {
        event.preventDefault();
        registrar_form_submit();

    });

}); 

$("#btn-registrar-usr-acc").click(function (){
	registrarAcc_form_submit();
})

function registrar_form_submit() {

	const tipoUsuarioCliente = {
			tipoUsuarioID: 1,
			nombreTipoUsuario: "Cliente",
			estado: "Activo"
	}
	
	const usuario = {
    		nombre: $("#nombre").val(),
    	    apellido: $("#apellido").val(),
    	    dni: $("#dni").val(),
    	    telefono: $("#phone").val(),
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

function registrarAcc_form_submit() {
	
	const usuarioCuenta = {
    	    dni: $("#usr").val()
    }
	
	const cuenta = {
			usrPassword: $("#password").val(),
			email: $("#email").val(),
			estado: "Activo",
			usuario: usuarioCuenta
	}

    $("#btn-registrar-usr").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/registrarCuenta",
        data: JSON.stringify(cuenta),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

        	$("#usr").remove();
            $("#regUserAccModal").modal('hide');
            $(".alert_info").append(
                    `<div class="alert alert-dismissible alert-success">
                <strong>Bienvenido!</strong> Se completó el registro.
                </div>`
                );

                setTimeout(() => {
                    $('.alert_info').remove();
                }, 3000);

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