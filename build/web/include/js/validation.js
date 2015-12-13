/* 
 * Bootstrap@ http://getbootstrap.com/
 * Glyphicon@ http://glyphicons.com/
 */

function initfield() {
document.getElementById("register-password").onchange = validatePassword;
document.getElementById("confirm-password").onchange = validatePassword;
}

function validatePassword(){
var pass2=document.getElementById("confirm-password").value;
var pass1=document.getElementById("register-password").value;

if(pass1!=pass2)
    document.getElementById("confirm-password").setCustomValidity("Passwords Don't Match");
else
    document.getElementById("confirm-password").setCustomValidity('');	 
//empty string means no validation error
}