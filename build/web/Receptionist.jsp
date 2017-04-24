<%-- 
    Document   : MainPanel
    Created on : Oct 31, 2016, 9:13:17 PM
    Author     : toni
--%>

<%@page import="model.AdminModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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


                        <h5 class="centered">${ admin.getUsername()}</h5>

                        <li class="mt">
                            <a  href="MainPanel.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Dashboard</span>
                            </a>
                        </li>

                        <li class="sub-menu">
                            <a  href="./PopulateTableServlate?action=populateDoctors"  >

                                <span>Doctors</span>
                            </a>

                        </li>

                        <li class="sub-menu">
                            <a class="active"  href="./PopulateTableServlate?action=populateReceptionists" >
                                <!--                                <i class="fa fa-cogs"></i>-->
                                <span>Receptionist</span>
                            </a>

                        </li>
                        <li class="sub-menu">
                            <a  href="./PopulateTableServlate?action=populatePharmacist" >
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
                             
                                <span>Reports</span>
                            </a>
                            <ul class="sub">
                                <li><a  href="basic_table.html">M</a></li>
                                <li><a  href="responsive_table.html"></a></li>
                            </ul>
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

                    <div class="row mt">
                        <div class="col-lg-12">

                            <div class="alert alert-success" >
                                <div class="text-center text-capitalize">
                                    <b>Hallo ${admin.getUsername() }</b> Select Receptionist in table to edit
                                </div>
                            </div>

                            <div class="row">

                                <div class="col-lg-6 col-md-6 col-sm-6 mb">

                                    <div class="input-group has-success" style=" margin-bottom: 20px;">
                                        <input type="text" class="form-control" placeholder="Search for..."/>
                                        <span class="input-group-btn" style="margin-left: 10px;">
                                            <button class="btn btn-primary" type="button">Go!</button>
                                        </span>
                                    </div>
                                    <div class="content-panel">

                                        <section id="unseen">
                                            <div class="table-responsive">

                                                <table class="table table-bordered table-striped table-condensed table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th>Receptionist ID</th>
                                                            <th>First Name</th>
                                                            <th>Last Name</th>
                                                            <th>Date of Birth</th>
                                                            <th>Password</th>
                                                            <th>Date added</th>

                                                        </tr>
                                                    </thead>
                                                    <tbody>

                                                        <c:forEach items="${recs}" var="rec">

                                                            <tr onclick="javascript:showRow(this);">
                                                                <td><c:out value="${rec.docID}" /></td>
                                                                <td><c:out value="${rec.fName}" /></td>
                                                                <td ><c:out value="${rec.sName}" /></td>
                                                                <td ><c:out value="${rec.dob}" /></td>
                                                                <td ><c:out value="${rec.pass}" /></td>
                                                                <td ><c:out value="${rec.dateCreated}" /></td>

                                                            </tr>
                                                        </c:forEach>



                                                    </tbody>
                                                </table>


                                                <script type="text/javascript">

                                                    function showRow(row) {
                                                        var x = row.cells;
                                                        document.getElementById('id').value = x[0].innerHTML;
                                                        document.getElementById('fName').value = x[1].innerHTML;
                                                        document.getElementById('sName').value = x[2].innerHTML;
                                                        document.getElementById('dob').value = x[3].innerHTML;
                                                        document.getElementById('password').value = x[4].innerHTML;
                                                    }

                                                </script>

                                            </div>
                                        </section>
                                    </div><!-- /content-panel -->
                                </div><!-- /col-lg-4 -->		



                                <div class="col-lg-6 col-md-6 col-sm-6 mb">

                                    <div id="err_p">

                                    </div>
                                    <div class="darkblue-panel pn" style="margin-top: 55px; height: 550px;">
                                        <div class="darkblue-header">
                                            <h5>Selected Receptionist Information</h5>
                                        </div>
                                        <h1 class="mt"><i class="fa fa-user fa-3x"></i></h1>
                                        <form class="form-horizontal tasi-form" method="post" id="recTable">

                                            <div class="panel-body">


                                                <div class="form-group ">
                                                    <label class="col-sm-2 control-label col-lg-3 text-primary" for="inputSuccess">Receptionist ID</label>
                                                    <div class="col-lg-9">
                                                        <input type="text" name="did" class="form-control" id="id">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label col-lg-3 text-primary" for="inputSuccess">First Name</label>
                                                    <div class="col-lg-9">
                                                        <input name="fName" type="text" class="form-control" id="fName">
                                                    </div>
                                                </div>
                                                <div class="form-group ">
                                                    <label class="col-sm-2 control-label col-lg-3 text-primary" for="inputError">Second Name</label>
                                                    <div class="col-lg-9">
                                                        <input name="sName" type="text" class="form-control" id="sName">
                                                    </div>
                                                </div>
                                                <div class="form-group ">
                                                    <label class="col-sm-2 control-label col-lg-3 text-primary" for="inputError">Date Of Birth</label>
                                                    <div class="col-lg-9">
                                                        <input name="dob" type="date" class="form-control" id="dob">
                                                    </div>
                                                </div>

                                                <div class="form-group ">
                                                    <label class="col-sm-2 control-label col-lg-3 text-primary" for="inputError">Password</label>
                                                    <div class="col-lg-9">
                                                        <input name="pass" type="text" class="form-control" id="password">
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="modal-footer">

                                                <button id="saveReceptionist" type="button" class="btn btn-success">Save Changes</button>
                                                <button id="deleteRec" type="button" class="btn btn-danger">Delete Doctor</button>
                                                <button type="button" class="btn btn-info">Print Doctor</button>
                                            </div>
                                        </form>

                                        <script type="text/javascript">

                                            $(document).ready(function () {

                                                $('#deleteRec').click(function (event) {
                                                    event.preventDefault();

                                                    $.ajax({
                                                        type: 'POST',
                                                        data: $("#recTable").serialize(),
                                                        url: "UDoperations?action=deleteReceptionist",
                                                        success: function (result) {
                                                            $('#err_p').html(result);
                                                        },
                                                        error: function (result) {
                                                            alert("error" + result);
                                                        }

                                                    });
                                                });
                                            });

                                            $(document).ready(function () {

                                                $('#saveReceptionist').click(function (event) {
                                                    event.preventDefault();

                                                    $.ajax({
                                                        type: 'POST',
                                                        data: $("#recTable").serialize(),
                                                        url: "UDoperations?action=saveReceptionist",
                                                        success: function (result) {
                                                            $('#err_p').html(result);
                                                        }
                                                    });
                                                });
                                            });

                                        </script>
                                    </div>


                                </div>
                            </div>

                        </div>
                    </div>




                </section><! --/wrapper -->
            </section><!-- /MAIN CONTENT -->

            <!--main content end-->
            <!--footer start-->
            <footer class="site-footer">
                <div class="text-center">
                    2016.
                    <a href="Receptionist.jsp#" class="go-top">
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

