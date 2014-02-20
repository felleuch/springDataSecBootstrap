<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Pet-Clinic-Bootstrap-Spring</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css"      rel="stylesheet"  type="text/css" />
    <script type="text/javascript" src="/resources/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
    <style type="text/css" title="currentStyle">
        @import "/resources/css/demo_table_jui.css";
        @import "/resources/css/jquery-ui-1.10.3.custom.min.css";
    </style>
    <style>
        .table-container{
            width:800px;
        }
        tr.odd{
            background: #EDE4D4 !important;
        }
        tr.odd td.sorting_1{
            background: #EDE4D4 !important;
        }
        tr.even td.sorting_1{
            background: #fff !important;
        }
    </style>

</head>

<body>
<div id="wrap">

    <c:import url="/WEB-INF/views/tags/navbar.jsp"/>

    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <div class="well sidebar-nav">
                    <c:import url="/WEB-INF/views/tags/menu.jsp"/>
                </div>
            </div>

            <div class="col-md-10">


                <div class="row">
                    <div class="col-md-12">
                        <div class="container">
                            <iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=priyatam&repo=springmvc-twitterbootstrap-showcase&type=watch&count=true" allowtransparency="true" frameborder="0" scrolling="0" width="100px" height="20px"></iframe>

                            <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://springmvc-twitterbootstrap-showcase.cloudfoundry.com" data-text="Spring MVC Twitter Bootstrap Showcase!">Tweet</a>
                            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
                        </div>

                        <hr class="soften">

                        <decorator:body />

                    </div>
                </div><!--/col-->
            </div><!--/row-->
        </div><!--/col-->
    </div><!--/row-->

    <hr class="soften">
</div>

<c:import url="/WEB-INF/views/tags/footer.jsp"/>
</body>
</html>
