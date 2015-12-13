<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="col-lg-10" style="float: none; margin: 0 auto;">
            <form method ="post" action = "submitphoto" >
                <div class="panel panel-default">
                    <div class="panel-heading"><h1>Welcome to our resume gallery</h1></div>
                    <table class="table" border="1">
                        <tbody>
                            <%
                                ArrayList rows = new ArrayList();

                                rows = (ArrayList) request.getAttribute("rows");

                                int i = 0;
                                while (i < rows.size()) {
                                    ArrayList row = (ArrayList) rows.get(i);
                                    out.print("<tr>");
                                    out.print("<td>");

                                    out.print("<img src='" + row.get(1) + "' style='width:240px;height:160px'></img>");
                                    out.print("</td>");

                                    out.print("<td>");
                                    out.print("<p>Score: " + row.get(2) + "</p>");
                                    out.print("<p>Description: " + row.get(3) + "</p>");

                                    out.print("</td>");

                                    if (i + 1 < rows.size()) {
                                        i = i + 1;
                                        row = (ArrayList) rows.get(i);
                                        out.print("<td>");

                                        out.print("<img src='" + row.get(1) + "' style='width:240px;height:160px'></img>");
                                        out.print("</td>");

                                        out.print("<td>");
                                        out.print("<p>Score: " + row.get(2) + "</p>");
                                        out.print("<p>Description: " + row.get(3) + "</p>");

                                        out.print("</td>");
                                    }
                                    else{
                                        out.print("<td></td>");
                                        out.print("<td></td>");

                                    }

                                    if (i + 1 < rows.size()) {
                                        i = i + 1;
                                        row = (ArrayList) rows.get(i);
                                        out.print("<td>");

                                        out.print("<img src='" + row.get(1) + "' style='width:240px;height:160px'></img>");
                                        out.print("</td>");

                                        out.print("<td>");
                                        out.print("<p>Score: " + row.get(2) + "</p>");
                                        out.print("<p>Description: " + row.get(3) + "</p>");

                                        out.print("</td>");
                                    } 
                                    else{
                                        out.print("<td></td>");
                                        out.print("<td></td>");
                                    }
                                    i=i+1;
                                    out.print("</tr>");
                                }
                            %>
                            
                            <tr>
                            <td colspan="6" style="color: red" align="center">
                                    <h4>Submit your resume
                                    <a href="index.jsp"> here</a>
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
