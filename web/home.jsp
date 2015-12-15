<%-- 
    Document   : home
    Created on : 2015-12-15, 15:48:14
    Author     : chiming
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <meta name="viewport" content="width=device-width,height=device-height, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="include/css/bootstrap.min.css"/>
    <%
        if(session.getAttribute("usrbn")==null)
            response.setHeader("Refresh", "1; URL=index.jsp");
    %> 
    <jsp:useBean id="usrbn" class="beans.userbean" scope="session"/>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-static-top" role="navigation" id="mynav" style="margin-bottom: 0px;">
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
                <li><a href="home.jsp"><span class="glyphicon glyphicon-home"></span>Home</a></li>
                <li><a href="cv-builder.html"><span class="glyphicon glyphicon-pencil"></span>Resume Builder</a></li>
                <li><a href="photoGallery"><span class="glyphicon glyphicon-picture"></span>Gallery</a></li>
                <li><a href="howto.html"><span class="glyphicon glyphicon-info-sign"></span>Help</a></li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <div class="page-header">
                    <h1 class="text-success" style="margin-top:20%;"><big>Welcome, <jsp:getProperty name="usrbn" property="uname"/></big></h1> 
                    <h5 class="text-info"><big>Submit your resume design
                            <br> and interact with other resume designers.</big></h5>
                    </div>
                <br><br><br>
                <a href="upload.jsp" class="btn btn-default pull-left" style="margin-right: 5px;">Upload new resume</a>
                <a href="photoGallery" class="btn btn-warning pull-left" style="margin-right: 5px;">Go To Gallery</a>
                <a href="Logout" class="btn btn-danger pull-right">Logout</a>
            </div>
            <div class="col-sm-1"></div>
    </div>

        
<script src="include/js/jquery-2.1.3.min.js"></script>
<script src="include/js/bootstrap.min.js"></script>
</body>
</html>
