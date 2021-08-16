<%-- 
    Document   : viewcart.jsp
    Created on : Jun 20, 2021, 12:47:43 PM
    Author     : boybe
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.AccountDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <title>Ninom</title>

        <!-- slider stylesheet -->
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

        <!-- fonts style -->
        <link href="https://fonts.googleapis.com/css?family=Baloo+Chettan|Dosis:400,600,700|Poppins:400,600,700&display=swap" rel="stylesheet" />
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />
    </head>
    <body>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <div class="hero_area">

            <!-- header section strats -->
            <div class="brand_box">
                <a class="navbar-brand" href="HomePage.jsp">
                    <span>
                        Ninom
                    </span>
                </a>
            </div>
            <!-- end header section -->

            <!-- slider section -->
            <section class=" slider_section position-relative">
                <div id="carouselExampleControls" class="carousel slide " data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="img-box">
                                <img src="images/slider-img.jpg" alt="">
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="img-box">
                                <img src="images/slider-img.jpg" alt="">
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="img-box">
                                <img src="images/slider-img.jpg" alt="">
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </section>
            <!-- end slider section -->

        </div>
        <!-- nav section -->

        <section class="nav_section">
            <div class="container">
                <div class="custom_nav2">
                    <nav class="navbar navbar-expand custom_nav-container ">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <div class="d-flex  flex-column flex-lg-row align-items-center">
                                <ul class="navbar-nav  ">
                                    <li class="nav-item active">
                                        <a class="nav-link" href="HomeServlet">Home <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="">About Shop </a>
                                    </li>

                                    <li class="nav-item">
                                        <label class="nav-link" > 
                                            <a style="color: white" href="FruitsServlet">Our Fruit </a>

                                        </label>                                       
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="ViewCart">View Cart</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="login.jsp">Login</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="LogoutServlet">Logout</a>
                                    </li>
                                </ul>
                                <!---------------------------------------------------------------Get user info----------------------- -->  
                                <%
                                    AccountDAO dao = new AccountDAO();
                                    if (session.getAttribute("userTarget") != null) {%> 
                                <a href="edit_account.jsp" class="nav-link" style="color: orange">
                                    <%= dao.getCustomerName((String) session.getAttribute("userTarget"))%>
                                </a>
                                <% }%>
                                <!---------------------------------------------------------------Get user info----------------------- -->
                                <form class="form-inline my-2 my-lg-0 ml-0 ml-lg-4 mb-3 mb-lg-0 " action="SearchFruitServlet" method="post">
                                    <button class="btn  my-2 my-sm-0" type="submit"><img src="images/search-icon.png"></button>
                                    <input class="input100" type="text" name="searchfruit" placeholder="Search   " style="width: 99px; height: 28px;" value="${search != null ? search : ""}">
                                </form>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </section>
        <!-- end -->

        <!-- order product-->
        <div class="container mb-4">
            <div class="row">
                <div class="col-12">
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th scope="col"> </th>
                                    <th scope="col">Product</th>
                                    <th scope="col">Available</th>
                                    <th scope="col" class="text-center">Quantity</th>
                                    <th scope="col" class="text-right">Price</th>
                                    <th> </th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${fruitlists}" var="list">
                                    <tr>
                                        <td><img src="images/${list.image}" width="100" height="100"/></td>

                                        <td>${list.productname}</td>

                                        <td>${list.numberofporducts}(product)                     
                                        </td>
                                        <td class="text-center">
                                            <input type="number" name="${list.productid}" min="1" max="2000">

                                        </td>          
                                        <td class="text-right">${list.price}$</td>
                                        <td></td>
                                    </tr>
                                </c:forEach> 

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>
                                        <a href="#">                                              
                                            <button  class="btn btn-sm btn-danger " style="height: 39px; width: 142px">Calculate</button>                                                                                           
                                        </a>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>Sub-Total</td>
                                    <td class="text-right">255,90 €</td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><strong>Total</strong></td>
                                    <td class="text-right"><strong>346,90 €</strong></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col mb-2">
                    <div class="row">
                        <div class="col-sm-12  col-md-6">
                            <a href="FruitsServlet"> 
                                <button class="btn btn-block btn-light" >Continue Shopping</button>
                            </a>
                        </div>
                        <div class="col-sm-12 col-md-6 text-right">
                            <button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- info section -->

        <section class="info_section layout_padding">
            <div class="container">
                <div class="info_logo">
                    <h2>
                        NiNom
                    </h2>
                </div>
                <div class="info_contact">
                    <div class="row">
                        <div class="col-md-4">
                            <a href="">
                                <img src="images/location.png" alt="">
                                <span>
                                    Passages of Lorem Ipsum available
                                </span>
                            </a>
                        </div>
                        <div class="col-md-4">
                            <a href="">
                                <img src="images/call.png" alt="">
                                <span>
                                    Call : 0948385299
                                </span>
                            </a>
                        </div>
                        <div class="col-md-4">
                            <a href="">
                                <img src="images/mail.png" alt="">
                                <span>
                                    demo@gmail.com
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8 col-lg-9">
                        <div class="info_form">
                            <form action="">
                                <input type="text" placeholder="Enter your email">
                                <button>
                                    subscribe
                                </button>
                            </form>
                        </div>
                    </div>
                    <div class="col-md-4 col-lg-3">
                        <div class="info_social">
                            <div>
                                <a href="">
                                    <img src="images/facebook-logo-button.png" alt="">
                                </a>
                            </div>
                            <div>
                                <a href="">
                                    <img src="images/twitter-logo-button.png" alt="">
                                </a>
                            </div>
                            <div>
                                <a href="">
                                    <img src="images/linkedin.png" alt="">
                                </a>
                            </div>
                            <div>
                                <a href="">
                                    <img src="images/instagram.png" alt="">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </section>

        <!-- end info section -->


        <!-- footer section -->
        <section class="container-fluid footer_section ">
            <p>
                &copy; <span id="displayYear"></span> All Rights Reserved. Design by
                <a href="https://html.design/">Free Html Templates</a>
            </p>
        </section>
        <!-- footer section -->

        <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/custom.js"></script>

    </body>
</html>
