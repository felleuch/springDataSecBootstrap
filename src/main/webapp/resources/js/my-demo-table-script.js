$(document).ready(function() {

    $(".jqueryDataTable").dataTable( {
        "bProcessing": false,
        "bFilter": false,
        "bServerSide": false,
        "sAjaxSource": "/pets/allpets",
        "bJQueryUI": true,
        "aoColumns": [
            { "mData": "name" },
            { "mData": "color" }

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

