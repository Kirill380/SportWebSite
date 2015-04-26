/**
 * Created by Nout on 26/04/2015.
 */

$(document).ready( function() {

    $.getJSON( "/NewsController", function( data ) {
        for(var i = 0; i < 3; i++) {
            $("div.new-"+ (i+1) +" > a").html(data[i].title);
            $("div.new-" + (i+1) + " > div").html(data[i].content);
        }
    }).fail(function() {
        console.log( "error" );
    });


})