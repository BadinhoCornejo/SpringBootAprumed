const collapse = document.getElementById("sidebarCollapse");
const sidebar = document.getElementById("sidebar");

//Cuando se hace click en el boton
collapse.addEventListener("click",()=>{
		
	if(sidebar.classList.contains("active")){
		sidebar.classList.remove("active");
	}
	else
	{
		sidebar.classList.add("active");
	}
		
})


//Cuando cambia de tamaño la pantalla
window.addEventListener("resize", ()=>{
   if(window.innerWidth < 768){
	   if(!sidebar.classList.contains("active")){
			sidebar.classList.add("active");
		}
   }
});