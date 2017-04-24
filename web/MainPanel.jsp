<%-- 
    Document   : MainPanel
    Created on : Oct 31, 2016, 9:13:17 PM
    Author     : toni
--%>

<%@page import="model.AdminModel"%>
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


        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">
        <script src="assets/js/jquery-3.1.1.js" type="text/javascript"></script>


    </head>

    <body>


        <%

            AdminModel am = null;

            if (session.getAttribute("admin") == null) {

                response.sendRedirect("login.jsp");

            } else {
                am = (AdminModel) session.getAttribute("admin");
            }

        %>

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="index.html" class="logo"><b>Patient Management Admin Panel</b></a>
                <!--logo end-->
               
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li><a class="logout" href="login.html">Logout</a></li>
                    </ul>
                </div>
            </header>

            <aside>
                <div id="sidebar"  class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">

                        <!--                        <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>-->
                        <h5 class="centered"><%= am.getUsername()%></h5>

                        <li class="mt">
                            <a class="active" href="MainPanel.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Dashboard</span>
                            </a>
                        </li>

                        <li class="sub-menu">
                            <a href="./PopulateTableServlate?action=populateDoctors" >
                                <!--                                <i class="fa fa-desktop"></i>-->
                                <span>Doctors</span>
                            </a>

                        </li>

                        <li class="sub-menu">
                            <a href="./PopulateTableServlate?action=populateReceptionists" >
                                <!--                                <i class="fa fa-cogs"></i>-->
                                <span>Receptionist</span>
                            </a>

                        </li>
                        <li class="sub-menu">
                            <a href="./PopulateTableServlate?action=populatePharmacist">
                                <!--                                <i class="fa fa-book"></i>-->
                                <span>Pharmacist</span>
                            </a>

                        </li>
                        <li class="sub-menu">
                            <a href="./PopulateTableServlate?action=populateTec" >
                                <!--                                <i class="fa fa-tasks"></i>-->
                                <span>Laboratory Technicians</span>
                            </a>

                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <!--                                <i class="fa fa-th"></i>-->
                                <span>Reports</span>
                            </a>

                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >

                                <span>My Account</span>
                            </a>

                        </li>

                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper site-min-height">
                    <h3 class="text-info" style="width: 50%;"> Actions</h3>
                    <div class="row mt">
                        <div class="col-lg-12">

                            <div class="row">


                                <div class="col-lg-6 col-md-6 col-sm-6 mb">

                                    <!--                                    DOCTORS PANEL-->
                                    <div class="white-panel pn">
                                        <div class="white-header">
                                            <h5 style="color: black;">DOCTORS</h5>
                                        </div>
                                        <div style="margin-top: 40px;">
                                            <p class="text-info" width="50">Total number of doctors</p>
                                            <p>${admin.getNumber()}</p>
                                            <p><b></b></p>
                                            <div class="row">
                                                <div class="col-md-6">

                                                    <button data-toggle="modal" href="MainPanel.jsp#doctorsModel" type="button" class="btn btn-round btn-primary">ADD DOCTOR</button> 
                                                </div>
                                                <div class="col-md-6">
                                                    <a  class="btn btn-round btn-info" href="./PopulateTableServlate?action=populateDocView">VIEW DOCTORS</a>
                                                   
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- /col-md-6 -->

                                <div class="col-lg-6 col-md-6 col-sm-6 mb">
                                    
                                    
                                   
                                    <!--Doctors Modal -->
                                    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="doctorsModel" class="modal fade">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                    <h4 class="modal-title">Enter Doctor Details</h4>
                                                </div>

                                                <form id="doc_form" class="form-horizontal tasi-form" action="./AddDoctorServlet" method="post" enctype="multipart/form-data">

                                                    <div class="modal-body">

                                                        <div class="form-group" id="err">

                                                        </div>


                                                        <div class="form-group has-success">
                                                            <label class="col-sm-2 control-label col-lg-3" for="doctorID">Doctor ID</label>
                                                            <div class="col-lg-9">
                                                                <input name="doc_ID" type="text" class="form-control" id="doctorID">
                                                            </div>
                                                        </div>
                                                        <div class="form-group has-success">
                                                            <label  class="col-sm-2 control-label col-lg-3" for="fName">First Name</label>
                                                            <div class="col-lg-9">
                                                                <input name="doc_fName" type="text" class="form-control" id="doc_fName">
                                                            </div>
                                                        </div>
                                                        <div class="form-group has-success">
                                                            <label class="col-sm-2 control-label col-lg-3" for="sName">Second Name</label>
                                                            <div class="col-lg-9">
                                                                <input name="doc_sName" type="text" class="form-control" id="doc_sName">
                                                            </div>
                                                        </div>
                                                        <div class="form-group has-success">
                                                            <label class="col-sm-2 control-label col-lg-3" for="doc_dob">Date Of Birth</label>
                                                            <div class="col-lg-9">
                                                                <input name="doc_DOB" type="date" class="form-control" id="doc_dob">
                                                            </div>
                                                        </div>

                                                        <div class="form-group has-success">
                                                            <label class="col-sm-2 control-label col-lg-3" for="doc_pass">Password</label>
                                                            <div class="col-lg-9">
                                                                <input name="doc_pass" type="text" class="form-control" id="doc_pass">
                                                            </div>
                                                        </div>

                                                    </div>
                                                    <div class="modal-footer">
                                                        <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                                                        <button class="btn btn-theme" type="submit" id="submitDoc">Submit</button>
                                                    </div>
                                                </form>


                                                <script type="text/javascript">

                                                    $(document).ready(function () {

                                                        $('#submitDoc').click(function (event) {
                                                            event.preventDefault();

                                                            $.ajax({
                                                                type: 'POST',
                                                                data: $("#doc_form").serialize(),
                                                                url: "AddDoctorServlet",
                                                                enctype: 'multipart/form-data',
                                                                success: function (result) {
                                                                    $('#err').html(result);
                                                                }

                                                            });
                                                        });
                                                    });

                                                </script>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- modal -->
                                    <!--                                    Pharmacist PANEL-->
                                    <div class="white-panel pn">
                                        <div class="white-header">
                                            <h5 style="color: black;">PHARMACIST</h5>
                                        </div>
                                        <div style="margin-top: 40px;">
                                            <p class="text-info" width="50">Total number of Pharmacist</p>
                                            <p>${admin.getP_Number()}</p>
                                            <p><b></b></p>
                                            <div class="row">
                                                <div class="col-md-6">

                                                    <button data-toggle="modal" href="MainPanel.jsp#pModel" type="button" class="btn btn-round btn-primary">ADD PHARMACIST</button> 
                                                </div>
                                                <div class="col-md-6">
                                                    <button type="button" class="btn btn-round btn-info">VIEW PHARMACIST</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- /col-md-4 -->


                                <!--Pharmacist Modal -->
                                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="pModel" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">Enter Pharmacist Details</h4>
                                            </div>

                                            <form id="p_form" class="form-horizontal tasi-form" method="POST" >
                                                <div class="modal-body">

                                                    <div class="form-group" id="err_p">

                                                    </div>

                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="p_id">Pharmacist ID</label>
                                                        <div class="col-lg-9">
                                                            <input name="p_ID"type="text" class="form-control" id="p_id">
                                                        </div>
                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="p_fName">First Name</label>
                                                        <div class="col-lg-9">
                                                            <input name="p_fName" type="text" class="form-control" id="p_fName">
                                                        </div>
                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="p_lName">Second Name</label>
                                                        <div class="col-lg-9">
                                                            <input name="p_lName" type="text" class="form-control" id="p_lName">
                                                        </div>
                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="dob">Date Of Birth</label>
                                                        <div class="col-lg-9">
                                                            <input name="p_dob" type="date" class="form-control" id="dob">
                                                        </div>
                                                    </div>

                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="pass">Password</label>
                                                        <div class="col-lg-9">
                                                            <input name="p_pass" type="text" class="form-control" id="pass">
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="modal-footer">
                                                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                                                    <button class="btn btn-theme" type="submit" id="submitP">Submit</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- modal -->
                                <script type="text/javascript">

                                    $(document).ready(function () {

                                        $('#submitP').click(function (event) {
                                            event.preventDefault();

                                            $.ajax({
                                                type: 'POST',
                                                data: $("#p_form").serialize(),
                                                url: "AddPharmacist",
                                                success: function (result) {
                                                    $('#err_p').html(result);
                                                }

                                            });
                                        });
                                    });

                                </script>



                                <div class="col-lg-6 col-md-6 col-sm-6 mb">

                                    <!--                                    Technician PANEL-->
                                    <div class="white-panel pn">
                                        <div class="white-header">
                                            <h5 style="color: black;">LAB TECHNICIAN</h5>
                                        </div>
                                        <div style="margin-top: 40px;">
                                            <p class="text-info" width="50">Total number of Technicians</p>
                                            <p>${admin.getT_Number()}</p>
                                            <p><b></b></p>
                                            <div class="row">
                                                <div class="col-md-6">

                                                    <button type="button" data-toggle="modal" href="MainPanel.jsp#technicianModel" class="btn btn-round btn-primary">ADD TECHNICIAN</button> 
                                                </div>
                                                <div class="col-md-6">
                                                    <button type="button" class="btn btn-round btn-info">VIEW TECHNICIANS</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- /col-md-4 -->


                                <!--Technician Modal -->
                                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="technicianModel" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">Enter Lab Technician Details</h4>
                                            </div>

                                            <form id="tec_form" class="form-horizontal tasi-form" method="POST">
                                                <div class="modal-body">

                                                    <div class="form-group" id="err_t">

                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="tec_id">Technician ID</label>
                                                        <div class="col-lg-9">
                                                            <input name="tec_id" type="text" class="form-control" id="tec_id">
                                                        </div>
                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="inputSuccess">First Name</label>
                                                        <div class="col-lg-9">
                                                            <input name="tec_fName" type="text" class="form-control" id="tec_fName">
                                                        </div>
                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="inputError">Second Name</label>
                                                        <div class="col-lg-9">
                                                            <input name="tec_sName" type="text" class="form-control" id="tec_sName">
                                                        </div>
                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="tec_dob">Date Of Birth</label>
                                                        <div class="col-lg-9">
                                                            <input name="tec_dob" type="date" class="form-control" id="tec_dob">
                                                        </div>
                                                    </div>

                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="tec_pass">Password</label>
                                                        <div class="col-lg-9">
                                                            <input name="tec_pass" type="text" class="form-control" id="tec_pass">
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="modal-footer">
                                                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                                                    <button class="btn btn-theme" type="submit" id="submitTec">Submit</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <!-- modal -->


                                <script type="text/javascript">

                                    $(document).ready(function () {

                                        $('#submitTec').click(function (event) {
                                            event.preventDefault();

                                            $.ajax({
                                                type: 'POST',
                                                data: $("#tec_form").serialize(),
                                                url: "AddTechnicianServlet",

                                                success: function (result) {
                                                    $('#err_t').html(result);
                                                }

                                            });
                                        });
                                    });

                                </script>

                                <div class="col-lg-6 col-md-6 col-sm-6 mb">

                                    <!--                                    Receptionist PANEL-->
                                    <div class="white-panel pn">
                                        <div class="white-header">
                                            <h5 style="color: black;">RECEPTIONISTS</h5>
                                        </div>
                                        <div style="margin-top: 40px;">
                                            <p class="text-info" width="50">Total number of Receptionists</p>
                                            <p>${admin.getR_number()}</p>
                                            <p><b></b></p>
                                            <div class="row">
                                                <div class="col-md-6">

                                                    <button data-toggle="modal" href="MainPanel.jsp#receptionistModel" type="button" class="btn btn-round btn-primary">ADD RECEPTIONIST</button> 
                                                </div>
                                                <div class="col-md-6">
                                                    <button type="button" class="btn btn-round btn-info">VIEW RECEPTIONISTS</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- /col-md-4 -->

                                <!--Receptionist Modal -->
                                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="receptionistModel" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">Enter Receptionist Details</h4>
                                            </div>

                                            <form id="rec_form" class="form-horizontal tasi-form" method="get">
                                                <div class="modal-body">

                                                    <div class="form-group" id="err_r">

                                                    </div>

                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="rec_ID">Receptionist ID</label>
                                                        <div class="col-lg-9">
                                                            <input name="rec_ID" type="text" class="form-control" id="rec_ID">
                                                        </div>
                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="rec_fName">First Name</label>
                                                        <div class="col-lg-9">
                                                            <input name="rec_fName" type="text" class="form-control" id="rec_fName">
                                                        </div>
                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="rec_sName">Second Name</label>
                                                        <div class="col-lg-9">
                                                            <input name="rec_sName" type="text" class="form-control" id="rec_sName">
                                                        </div>
                                                    </div>
                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="inputError">Date Of Birth</label>
                                                        <div class="col-lg-9">
                                                            <input name="rec_DOB" type="date" class="form-control" id="inputSuccess">
                                                        </div>
                                                    </div>

                                                    <div class="form-group has-success">
                                                        <label class="col-sm-2 control-label col-lg-3" for="inputError">Password</label>
                                                        <div class="col-lg-9">
                                                            <input name="rec_pass" type="text" class="form-control" id="">
                                                        </div>
                                                    </div>

                                                </div>
                                                <div class="modal-footer">
                                                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                                                    <button id="submitRec" class="btn btn-theme" type="submit">Submit</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <!-- modal -->


                                    <script type="text/javascript">

                                        $(document).ready(function () {

                                            $('#submitRec').click(function (event) {
                                                event.preventDefault();

                                                $.ajax({
                                                    type: 'POST',
                                                    data: $("#rec_form").serialize(),
                                                    url: "AddReceptionistServlet",

                                                    success: function (result) {
                                                        $('#err_r').html(result);
                                                    }

                                                });
                                            });
                                        });

                                    </script>


                                </div>
                            </div>
                        </div>

                </section><! --/wrapper -->
            </section><!-- /MAIN CONTENT -->

            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    2016
                    <a href="MainPanel.jsp#" class="go-top">
                        <i class="fa fa-angle-up"></i>
                    </a>
                </div>
            </footer>
            <!--footer end-->
        </section>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>
        <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
        <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


        <!--common script for all pages-->
        <script src="assets/js/common-scripts.js"></script>

        <!--script for this page-->

        <script>
                                        //custom select box

                                        $(function () {
                                            $('select.styled').customSelect();
                                        });

        </script>

    </body>
</html>

