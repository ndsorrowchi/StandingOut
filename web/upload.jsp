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
        <!-- Latest compiled and minified CSS -->
        <script src="include/js/jquery-2.1.3.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="include/css/bootstrap.min.css"/>
        <script src="include/js/bootstrap.min.js"></script>
        <script src="js/gallery.js" ></script>

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
                <li><a href="howto.html"><span class="glyphicon glyphicon-info-sign"></span>Help</a></li>
            </ul>
        </div>
    </nav>
    <div class="col-lg-10" style="float: none; margin: 0 auto;">
        <form method ="post" action = "submitphoto"  enctype="multipart/form-data">
            <div class="panel panel-default">
                <div class="panel-heading"><h1>Submit your resume</h1></div>
                <table class="table" border="1">
                    <tbody>
                        <tr>
                            <td>Upload your pdf:</td>
                            <td><input type="file" name="image" value="" /></td>
                        </tr>
                        <tr>
                            <td>Score:</td>
                            <td><input type="number" name="score" value="" min="0" max="100"/></td>
                        </tr>
                        <tr>
                            <td>Description:</td>
                            <td><textarea name="description" rows="8" cols="50">
                                </textarea></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Submit" name="Submit" /></td>
                        </tr>

                    <td colspan="2" style="color: red" align="center">
                        <h4>Go to resume gallery
                            <a href="photoGallery"> here</a>
                        </h4>
                    </td>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</body>
</html>
