<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photo Gallery</title>
        <script src="include/js/jquery-2.1.3.min.js"></script>

        <!-- Latest compiled and minified JavaScript -->
        <link rel="stylesheet" type="text/css" href="include/css/bootstrap.min.css"/>
        <script src="include/js/bootstrap.min.js"></script>
        <script src="include/js/gallery.js" ></script>   
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
                <li><a href="home.jsp"><span class="glyphicon glyphicon-home"></span>Home</a></li>
                <li><a href="cv-builder.html"><span class="glyphicon glyphicon-pen"></span>Resume Builder</a></li>
                <li><a href="photoGallery"><span class="glyphicon glyphicon-picture"></span>Gallery</a></li>
                <li><a href="#mynav"><span class="glyphicon glyphicon-info-sign"></span>Help</a></li>
            </ul>
        </div>
    </nav>
        <div class="col-lg-10" style="float: none; margin: 0 auto;">
            <form method ="post" action = "submitphoto" >
                <div class="panel panel-default">
                    <div class="panel-heading"><h1>Hello, Your submit result</h1></div>
                    <table class="table" border="1">
                        <tbody>
                            <tr>
                                <td>Score:</td>
                                <td><%= request.getParameter("score")%></td>
                            </tr>
                            <tr>
                                <td>Description:</td>
                                <td><%= request.getParameter("description")%></td>
                            </tr>
                            <tr>
                                <td>Status</td>
                                <td><%= request.getAttribute("status")%></td>
                            </tr>
                            <tr>
                                <td colspan="2" style="color:red" align="center">
                                    <h4>Go to photo gallery
                                    <a href="photoGallery"> here</a>
                                    </h4>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    
                </div>
            </form>
        </div>
    </body>
</html>
