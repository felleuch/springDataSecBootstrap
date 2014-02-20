$(document).ready(function() {

    $(".jqueryDataTable").dataTable( {
        "bProcessing": false,
        "bServerSide": false,
        "sAjaxSource": "/pets/allpets",
        "bJQueryUI": true,
        "aoColumns": [
            { "mData": "name" },
            { "mData": "color" }
            
        ]
    } ); 
} );

