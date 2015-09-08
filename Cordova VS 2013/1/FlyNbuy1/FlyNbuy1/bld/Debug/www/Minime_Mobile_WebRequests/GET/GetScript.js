function get_request (url,params,header,body,async) {
    this.url = url;
    this.params = params;
    this.header = header;
    this.body = body;
    this.async = async;
    this.send_request = function() {
        $.ajax({
            url: this.url,
            type: 'get',
            dataType: 'json',
            async: this.async,
            success: function (data) {
                $("#response_from_server_text").html(JSON.stringify(data));
            }
            
        });

    };
}
    