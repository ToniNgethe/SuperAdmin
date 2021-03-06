<%-- 
    Document   : login
    Created on : Oct 31, 2016, 9:13:04 PM
    Author     : toni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>Patient Management System</title>

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">



    </head>

    <body>

        <%

            String msg = (String) request.getAttribute("message");
            if (msg == null) {
                msg = "";
            }

        %>
        <div id="login-page">
            <div class="container">

                <form class="form-login" action="./LoginServlet" method="POST">
                    <h2 class="form-login-heading">sign in now</h2>

                    <%= msg%>
                    <div class="login-wrap">
                        <input name="user_id" type="text" class="form-control" placeholder="User ID" autofocus>
                        <br>
                        <input name="password" type="password" class="form-control" placeholder="Password">
                        <label class="checkbox">
                            <span class="pull-right">
                                <a data-toggle="modal" href="login.jsp#myModal"> Forgot Password?</a>

                            </span>
                        </label>
                        <input class="btn btn-theme btn-block" type="submit" value="SIGN IN"<i class="fa fa-lock"></i>
                        <hr>

                    </div>

                    <!-- Modal -->
                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title">Forgot Password ?</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Enter your e-mail address below to reset your password.</p>
                                    <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                                </div>
                                <div class="modal-footer">
                                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                                    <button class="btn btn-theme" type="button">Submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- modal -->

                </form>	  	

            </div>
        </div>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>

        <!--BACKSTRETCH-->
        <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
        <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
        <script>
//            $.backstretch("assets/img/login-bg.jpg", {speed: 500});
        </script>


    </body>
</html>
