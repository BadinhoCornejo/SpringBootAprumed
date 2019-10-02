
$(document).ready(function () {

    $("#registrar-form").submit(function (event) {
        event.preventDefault();
        registrar_form_submit();

    });

}); 

$("#btn-registrar-usr-cancelar").click(()=>{
	$('#regUserModal').modal('hide');
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
    	    dni: $("#username").val(),
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
