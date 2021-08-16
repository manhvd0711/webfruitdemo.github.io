<%-- 
    Document   : relogin
    Created on : Jun 22, 2021, 8:46:03 PM
    Author     : boybe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
        <style>
            .submit:hover{
                background-color:  violet;
                cursor: pointer;
            }
        </style>
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-login100">
                    <form class="login100-form validate-form" action="ResetPassword" method="post">

                        <span class="login100-form-title p-b-34 p-t-27">
                            Reset Password
                        </span>

                        <div class="wrap-input100 validate-input" data-validate = "Enter username">
                            <input class="input100" type="text" name="X" placeholder="Username" disabled="" style="color: orange"
                                   <% if (request.getAttribute("email") != null) {%>
                                   value="Email: <%= request.getAttribute("email")%>" <%}%>>
                            <span class="focus-input100" data-placeholder="&#xf207;"></span>
                        </div>

                        <input type="hidden" name="Email"<% if (request.getAttribute("email") != null) {%>
                               value="<%= request.getAttribute("email")%>" <%}%>>

                        <div class="wrap-input100 validate-input" data-validate = "Enter username">
                            <input class="input100" type="text" name="X" placeholder="Username" disabled style="color: orange"
                                   <% if (request.getAttribute("username") != null) {%>
                                   value="Username: <%= request.getAttribute("username")%>" <%}%>>
                            <span class="focus-input100" data-placeholder="&#xf207;"></span>
                        </div>
                            
                        <input type="hidden" name="Username"<% if (request.getAttribute("username") != null) {%>
                               value="<%= request.getAttribute("username")%>" <%}%>>

                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <input class="input100" type="password" name="password" placeholder="Password">
                            <span class="focus-input100" data-placeholder="&#xf191;"></span>
                        </div>
                        <div class="wrap-input100 validate-input" data-validate="Repeat password">
                            <input class="input100" type="password" name="repassword" placeholder="Repeat Password">
                            <span class="focus-input100" data-placeholder="&#xf191;"></span>
                        </div>


                        <center>
                            <% if (request.getAttribute("userName_error") != null) { %>
                            <p style="color: yellow; font-size: 20px" >Username already used !</p>
                            <% }%>
                            <% if (request.getAttribute("rePass_error") != null) { %>
                            <p style="color: yellow; font-size: 20px" >Password Retyped is not correct !</p>
                            <% }%>  
                            <% if (request.getAttribute("success") != null) { %>
                            <p style="color: orange; font-size: 40px" ><b>Success</b></p>
                            <% }%>

                        </center>
                        <center>
                            <input type="submit" value="Save Change" style="border: solid black 3px; padding: 5px" class="submit"/>

                            <a  href="login.jsp" class="text-center p-t-90" style="font-size: 20px;color: white">
                                -> Login <-
                            </a>         
                        </center>

                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>
