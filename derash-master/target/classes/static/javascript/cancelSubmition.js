var unSubmit = document.getElementById("unsubmit")
var submitSuccessful = document.getElementById("succes")
var submitted = null
document.getElementById("submit")
      .addEventListener("click", (event) => {

  submitted = "submited successful"
  message(submitted)

     });



function message(value){
  
  submitSuccessful.innerText = value
  submitSuccessful.style.visibility = "visible"
}