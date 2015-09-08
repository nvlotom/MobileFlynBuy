/*make post request*/
$("#login_button_id").click(function () {
    var username = $('#username_input_id').val();
    var password = $('#password_input_id').val();
    var authorization_string = make_base_auth(username, password);
    var request = new post_request("http://192.168.10.42:15536/Plugins/Misc.WebServices/Remote/Customers.svc/Login", "Doe", authorization_string, "blue", false);// (url, params, header, body, async)
    var response = request.send_request();//json string

    if (response.localeCompare("error")!=0) { //login success
        var jsobjectresponse = JSON.parse(response); //create javascript object from JSON string
        $("#response_from_server_text").html(jsobjectresponse.BillingAddress.FirstName + " " + jsobjectresponse.BillingAddress.LastName + " " + jsobjectresponse.BillingAddress.PhoneNumber + " " + jsobjectresponse.Username);
    }
    else { //login failed
        $("#response_from_server_text").html("Login failed");
    }
    


});









/*create base64 encoding*/
function make_base_auth(user, pass) {
    var tok = user + ':' + pass;
    var hash = window.btoa(tok);
    return "Basic " + hash;
}