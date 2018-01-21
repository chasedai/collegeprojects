function testSubmit()
{
var username1 = document.forms["myForm"]["username"];
var password1 = document.forms["myForm"]["password"];
if(username1.value =="" || password1.value=="" )
{
alert('You must enter username and password!');
return false;
}
return true;
}
function validateForm()
{
if(testSubmit())
{
document.forms["myForm"].submit(); //first submit
document.forms["myForm"].reset(); //and then reset the form values
}
}