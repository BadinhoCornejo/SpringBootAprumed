var bookId = 0;

$("#add-ejemplar-form").submit((event) => {
        event.preventDefault();
        addEjemplar_form_submit();

    });

$('#addEjemplarModal').on('show.bs.modal', function(e) {

    //get data-id attribute of the clicked element
    bookId = $(e.relatedTarget).data('book-id');

});

function addEjemplar_form_submit(){
	
	let skuEjemplar = $("#ejemplar_sku").val();
	
	console.log(bookId);
	
	const libroRef = {
			libroID: bookId
	}
	
	const ejemplar = {
			sku: skuEjemplar,
			libro: libroRef
	}
	
	if(skuEjemplar == "" || skuEjemplar == null){
		console.log("No ingresaste sku");
	}
	else{
		$.ajax({
		    url: "/agregarEjemplar",
		    type: "POST",
		    contentType: "application/json",
		    dataType: 'json',
		    async: "false",
		    data: JSON.stringify(ejemplar),
		    cache: false,
		    success: (data) => {
		    	
		        if (data.msg == "EjemplarExist") {
		        	
		        	$("#portadaVal").removeClass("passive");
		        }
		        else {
		        	$("#addEjemplarModal").modal('hide');
		        	location.reload(true);
		        }

		    },

		    error: (errormessage) => {

		    }

		});
	}
	
	
}