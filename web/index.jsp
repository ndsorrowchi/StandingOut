<%-- 
    Document   : index
    Created on : 2015-12-13, 17:56:54
    Author     : chiming
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.sql.*,beans.userbean"%>
<!DOCTYPE html>
<html>
<head>
    <title>StandingOut Social CV</title>
    <meta charset="UTF-8">
       <meta name="viewport" content="width=device-width,height=device-height, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="include/css/bootstrap.min.css"/>
    <%
        if(session.getAttribute("usrbn")!=null)
        {
            userbean ub=(userbean)session.getAttribute("usrbn");
            if(ub.getUname()!=null&&ub.getUid()!=null&&!ub.getUid().equals("")&&!ub.getUname().equals(""))
            {
                response.setHeader("Refresh", "1; URL=home");
            }
        }      
    %>    
</head>
<body onload="initfield()" 
      style="background-image: url('include/img/bg.jpg');
      -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;">
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
                <li><a href="home"><span class="glyphicon glyphicon-home"></span>Home</a></li>
                <li><a href="cv-builder.html"><span class="glyphicon glyphicon-pencil"></span>Resume Builder</a></li>
                <li><a href="photoGallery"><span class="glyphicon glyphicon-picture"></span>Gallery</a></li>
                <li><a href="howto.html"><span class="glyphicon glyphicon-info-sign"></span>Help</a></li>
            </ul>
        </div>
    </nav>

    <div style="width:100%;">
        <div class="container">
            <div class="row">
                <div class="col-sm-8">
                    <h1 style="margin-top:20%;color: #FF9933"><big>StandingOut</big></h1> 
                    <h5 style="color: #FF9933"><big>Submit your resume design
                            <br> and interact with other resume designers.</big></h5>                 
                </div>
                <div class="col-sm-4">
                    <ul class="nav nav-tabs" style="margin-top:20px;">
                        <li class="active"><a data-toggle="tab" href="#tab-login">Login</a></li>
                        <li><a data-toggle="tab" href="#tab-register">Register</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="tab-login" class="tab-pane fade in active">
                            <br/>
                            <form role="form" action="Login" method="post">
                                <div class="form-group">
                                    <label for="login-username">Email Address</label>
                                    <input id="login-username" type="email" name="username" class="form-control" required />
                                </div>
                                <div class="form-group">
                                    <label for="login-password">Password</label>
                                    <input id="login-password" type="password" name="password" class="form-control" required />
                                </div>
                                <input type="submit" value="sign in" class="btn btn-primary pull-right"/>
                            </form>
                        </div>
                        <div id="tab-register" class="tab-pane fade">
                            <br/>
                            <form role="form" action="Register" method="post">
                                <div class="form-group">
                                    <label for="register-username">Email Address</label>
                                    <input id="register-username" maxlength="40" type="email" name="username" class="form-control" required />
                                </div>
                                <div class="form-group">
                                    <label for="register-nickname">Display Name</label>
                                    <input id="register-nickname" type="text" name="nickname" maxlength="30" class="form-control" required />
                                </div>
                                <div class="form-group">
                                    <label for="register-password">Password</label>
                                    <input maxlength="16" id="register-password" type="password" name="password" class="form-control" required />
                                </div>
                                <div class="form-group">
                                    <label for="confirm-password">Confirm Password</label>
                                    <input maxlength="16" id="confirm-password" type="password" name="confirm-password" class="form-control" required />
                                </div>
                                <input type="submit" value="sign up" class="btn btn-success pull-right"/>
                            </form>                        
                        </div>
                    </div>
                </div>
            </div>
        </div>
            
    </div>

        
<script src="include/js/jquery-2.1.3.min.js"></script>
<script src="include/js/bootstrap.min.js"></script>
<script src="include/js/validation.js"></script>
</body>
</html>
