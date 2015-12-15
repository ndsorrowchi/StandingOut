<%-- 
    Document   : error
    Created on : 2015-12-13, 12:39:25
    Author     : chiming
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="include/css/bootstrap.min.css"/>
    <title>Oops...</title>
    <%
        String errmsg=(String)request.getAttribute("errmsg");
        if(errmsg==null)
            errmsg="Unexpected Error";
        String redirect=(String)request.getAttribute("redirect");
        if(redirect==null)
            redirect="home";
        String target=(String)request.getAttribute("target");
        if(target!=null)
            redirect=target;
                
        response.setHeader("Refresh", "5; URL="+redirect);
        
    %>
</head>
<body>
        <nav class="navbar navbar-inverse navbar-static-top" role="navigation" id="mynav">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" 
                    data-target="#navbar-collapse">
                <span class="sr-only">switch</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#mynav">StandingOut</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav navbar-right" style="margin-right: 10px;">
                <li><a href="home"><span class="glyphicon glyphicon-home"></span>Home</a></li>
                <li><a href="cv-builder.html"><span class="glyphicon glyphicon-pencil"></span>Resume Builder</a></li>
                <li><a href="photoGallery"><span class="glyphicon glyphicon-picture"></span>Gallery</a></li>
                <li><a href="howto.html"><span class="glyphicon glyphicon-info-sign"></span>Help</a></li>
            </ul>
        </div>
    </nav>
    <div class="container" style="height:100%;">
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-4">
                <img class="img-responsive center-block" src="include/img/shy-icon.png" alt="Sorry" style="margin-top:50%;"></img>
                <%--img source:http://icons.iconarchive.com/icons/bad-blood/yolks-2/256/shy-icon.png--%>
            </div>
            <div class="col-sm-6">
                <h3 class="text-center text-danger" style="margin-top:50%;"><%=errmsg%></h3>
                <h4 class="text-center text-warning">redirecting...</h4>
            </div>
            <div class="col-sm-1"></div>
        </div>
    </div>
    <script src="include/js/jquery-2.1.3.min.js"></script>
    <script src="include/js/bootstrap.min.js"></script>    
</body>
</html>
