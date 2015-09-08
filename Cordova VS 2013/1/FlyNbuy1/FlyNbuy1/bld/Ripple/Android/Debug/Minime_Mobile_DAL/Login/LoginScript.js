/*make post request*/
$("#login_button_id").click(function () {
    var username = $('#username_input_id').val();
    var password = $('#password_input_id').val();
    var authorization_string = make_base_auth(username, password);
    var request = new post_request("http://192.168.10.42:15536/Plugins/Misc.WebServices/Remote/NopService.svc/Login", "Doe", authorization_string, "blue", false);// (url, params, header, body, async)
    request.send_request();
});


/*create base64 encoding*/
function make_base_auth(user, pass) {
    var tok = user + ':' + pass;
    var hash = window.btoa(tok);
    return "Basic " + hash;
}