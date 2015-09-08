/*make get request*/
var request = new get_request("http://192.168.10.42:15536/Plugins/Misc.WebServices/Remote/Products.svc/GetHomePageProducts", "Doe", 50, "blue", false);
var response = request.send_request(); //json string


if (response.localeCompare("error") != 0) { //fetch success
    var jsobjectresponse = JSON.parse(response); //create javascript object from JSON string


    /*create rows for each result*/
    for (var i = 0; i < jsobjectresponse.length; i++) {
        var row = $("<tr></tr>");
        var column = $("<td></td>");


        //picture

        var div_picture = $("<div></div>");
        var img_picture = document.createElement("IMG");
        img_picture.src = "data:image/gif;base64," + jsobjectresponse[i].PicturesBase64 + "";//convert base64 into an image - needs the prefix
        img_picture.style.width = "100px";
        img_picture.style.height = "100px";
        div_picture.append(img_picture);
        column.append(div_picture);


        //name
        var div_name = $("<div></div>");
        var p_name = $("<p></p>").text(jsobjectresponse[i].Name);
        div_name.append(p_name);
        column.append(div_name);

        //rating
        var div_rating = $("<div></div>");
        var p_rating = $("<p></p>").text(jsobjectresponse[i].id); ///need to change into rating
        div_rating.append(p_rating);
        column.append(div_rating);


        //price
        var div_price = $("<div></div>");
        var p_price = $("<p></p>").text(jsobjectresponse[i].Price);
        div_price.append(p_price);
        column.append(div_price);

        row.append(column);
        $("#body_results_id").append(row);

    }



}
else { //fetch failed
    $("#response_from_server_text").html("Fetch home page products failed");
}

