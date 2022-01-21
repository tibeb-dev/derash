
var passwordMissmatchMessage = document.getElementById("error-message");  
var visibility = null
var color = null
var message = null


document.getElementById("submit")
    	.addEventListener("click", (event) => {
	
		var firstPassword = document.getElementById("password-1").value;  
		var secondPassword = document.getElementById("password-2").value;

	  	if(firstPassword != secondPassword)  {
		     	event.preventDefault()
		     	visibility = "visible"
				color = "red"
				message = "password miss match"
				setMessage(visibility,color,message)
		}
	 });



function setMessage(visibility,color,message)
{
	passwordMissmatchMessage.style.visibility = visibility
	  passwordMissmatchMessage.style.color = color
        passwordMissmatchMessage.innerText = message
}