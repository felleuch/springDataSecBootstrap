$(document).ready(function() {

    $(".jqueryDataTable").dataTable( {
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

} );



function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#img2').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

