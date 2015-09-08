function post_request(url, params, header, body, async) {
    this.url = url;
    this.params = params;
    this.header = header;
    this.body = body;
    this.async = async;
    this.send_request = function () {

        var response;
        $.ajax({
            url: this.url,
            type: 'post',
            dataType: 'json',
            async: this.async,
            headers: { 'Authorization': this.header },
            success: function (data) {
                //$("#response_from_server_text").html(JSON.stringify(data));
                response = JSON.stringify(data); //create json string
            },
            error: function (xhr) {
                //$("#response_from_server_text").html("Wrong Credentials");
                response = "error";
            }

        });

        return response;

    };
}
