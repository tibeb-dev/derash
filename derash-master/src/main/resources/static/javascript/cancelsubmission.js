var unSubmit = document.getElementById("unsubmit")
var submitSuccessful = document.getElementById("succes")
var submitted = null
document.getElementById("submit")
      .addEventListener("click", (event) => {
  console.log("function1")
  event.preventDefault()
  submitted = "submited successful"
  
  var timeLeft = 10;
    var elem = document.getElementById('unsubmit');
    
    var timerId = setInterval(countdown, 1000);
    
    function countdown(event) {
      if (timeLeft == -1) {
        clearTimeout(timerId);
        message(submitted)
     
      } else {
        elem.innerHTML = "cancel submit " + timeLeft ;
        timeLeft--;
      }
    }});



function message(value){
  console.log("function3")
  submitSuccessful.innerText = value
  submitSuccessful.style.visibility = "visible"
}
