/*make get request*/
var request = new get_request("http://192.168.10.42:15536/Plugins/Misc.WebServices/Remote/NopService.svc/GetHomePageProducts", "Doe", 50, "blue", false);
request.send_request();
