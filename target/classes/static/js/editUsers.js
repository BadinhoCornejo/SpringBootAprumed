const goUser = document.getElementById("userLink");
const goAcc = document.getElementById("accLink");

const editUser = document.getElementById("editUser");
const editAcc = document.getElementById("editAcc");

goUser.addEventListener("click",()=>{
	if(editUser.classList.contains("hide")){
		editUser.classList.remove("hide");
		goUser.classList.add("active");
		goAcc.classList.remove("active");
		editAcc.classList.add("hide");
	}
	else
	{
		editUser.classList.add("hide");
		editAcc.classList.remove("hide");
		goUser.classList.remove("active");
		goAcc.classList.add("active");
	}
})

goAcc.addEventListener("click",()=>{
	if(editAcc.classList.contains("hide")){
		editAcc.classList.remove("hide");
		editUser.classList.add("hide");
		goAcc.classList.add("active");
		goUser.classList.remove("active");
	}
	else
	{
		editAcc.classList.add("hide");
		editUser.classList.remove("hide");
		goAcc.classList.add("active");
		goUser.classList.remove("active");
	}
})