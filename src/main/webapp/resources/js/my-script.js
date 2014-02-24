$(document).ready(function() {

    $(".petsDataTable").dataTable( {
        "bProcessing": false,
        "bFilter": false,
        "bServerSide": false,
        "sAjaxSource": "/pets/allpets",
        "bJQueryUI": true,
        "aoColumnDefs": [

            {
                "aTargets": [ 1 ],
                "mData": "name"
            },
            {
                "aTargets": [ 2 ],
                "mData": "color"
            },

            {
                "aTargets": [ 3 ],
                "mData": "id",
                "mRender": function ( data, type, full ) {
                    return '<a href="edit/'+data+'.html">Modify</a>';
                }
            },{
                "aTargets": [ 4 ],
                "mData": "id",
                "mRender": function ( data, type, full ) {
                    return '<a href="delete/'+data+'.html">Delete</a>';
                }
            },{
                "aTargets": [ 5 ],
                "mData": "id",
                "mRender": function ( data, type, full ) {
                    return '<button  id="dialog_link2" onclick="openMyDialog(\'detail/'+data+'.json\')"  >Detail</button>';
                }
            },{
                "aTargets": [0],
                "mData": "selected",
                "mRender": function (data, type, full) {
                    if (data == "1") {
                        return '<input type=\"checkbox\" checked value="' + data + '">';
                    } else {
                        return '<input type=\"checkbox\" value="' + data + '">';
                    }
                }
            }

        ]

    } );


    $(".ownersDataTable").dataTable( {
        "bProcessing": false,
        "bFilter": false,
        "bServerSide": false,
        "sAjaxSource": "/owners/allowners",
        "bJQueryUI": true,
        "aoColumnDefs": [

            {
                "aTargets": [ 1 ],
                "mData": "firstName"
            },
            {
                "aTargets": [ 2 ],
                "mData": "lastName"
            },

            {
                "aTargets": [ 3 ],
                "mData": "id",
                "mRender": function ( data, type, full ) {
                    return '<a href="edit/'+data+'.html">Modify</a>';
                }
            },{
                "aTargets": [ 4 ],
                "mData": "id",
                "mRender": function ( data, type, full ) {
                    return '<a href="delete/'+data+'.html">Delete</a>';
                }
            },{
                "aTargets": [ 5 ],
                "mData": "id",
                "mRender": function ( data, type, full ) {
                    return '<button  id="dialog_link2" onclick="openMyDialog(\'detail/'+data+'.json\')"  >Detail</button>';
                }
            },{
                "aTargets": [0],
                "mData": "selected",
                "mRender": function (data, type, full) {
                    if (data == "1") {
                        return '<input type=\"checkbox\" checked value="' + data + '">';
                    } else {
                        return '<input type=\"checkbox\" value="' + data + '">';
                    }
                }
            }

        ]

    } );



    $("#fileupload").fileupload({
        dataType: "json",
        done: function (e, data) {
            $.each(data.result, function (index, file) {
                $("#image").val(file.fileName);
            });

        },
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                    progress + '%'
            );
        }


    });

    $("#fileupload").change(function(){
        readURL(this);
    });

    $("#petdetail").dialog({
        position: "center",
        autoOpen: false,
        width: 400,
        height:400,
        buttons: {
            "Cancel": function() {

                $(this).dialog("close");
            }
        }
    });

} );

function openMyDialog(  myurl){


    $.ajax({
        type: "GET",
        dataType: "json",
        url: myurl,
        cache: false,
        success: function(data){
            $("#petdetail").html("<div></div>");
            $.each( data, function( key, val ) {
                $("#petdetail").append( "<div id ='detailPet' > ") ;

                if( key  == "name" ){
                    $("#petdetail").append("<p>Name : " + val + "</p> ") ;
                }
                if( key  == "color" ){
                    $("#petdetail").append("<p>Color : " + val + "</p> ") ;
                }
                if( key  == "image" ){
                    $("#petdetail").append("<p><img  width='200px' height='200px' src='/resources/images/" + val + "' /></p> ") ;
                }


                $("#petdetail").append("</div>" );
            });


        }
    });
    $("#petdetail").dialog("open");
}



function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#img2').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}



