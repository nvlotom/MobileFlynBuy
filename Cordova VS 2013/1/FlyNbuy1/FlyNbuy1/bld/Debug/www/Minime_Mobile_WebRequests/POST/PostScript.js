function post_request(url, params, header, body, async) {
    this.url = url;
    this.params = params;
    this.header = header;
    this.body = body;
    this.async = async;
    this.send_request = function () {
        $.ajax({
            url: this.url,
            type: 'post',
            dataType: 'json',
            async: this.async,
            headers: { 'Authorization': this.header },
            success: function (data) {
                $("#response_from_server_text").html(JSON.stringify(data));
            },
            error: function (xhr) {
                $("#response_from_server_text").html("Wrong Credentials");
            }

        });

    };
}
