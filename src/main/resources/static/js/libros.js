$(".card-img-top").click((e)=>{
	let id = e.target.id;
	verLibro(id);
});

function verLibro(id){
	$.ajax({
	    url: "/verLibro",
	    type: "POST",
	    contentType: "application/json",
	    dataType: 'json',
	    async: "false",
	    data: id,
	    cache: false,
	    success: (data) => {
	    	
	        const libro = data.result.libro;
	        
	        $("#img-libro-detalle").prop("src",libro.portada.url);
	        $("#img-libro-detalle").prop("alt",libro.portada.nombrePortada);
	        $("#card-lbrAutor span").text(libro.autor);
	        $("#card-lbrDate span").text(libro.fechaPublicacion);
	        $("#card-lbrStock span").text(libro.stock);
	        $("#libroModalLabelTitle").text(libro.titulo)
	        
	        $("#libroModal").modal("show");

	    },

	    error: (errormessage) => {

	    }

	});
}