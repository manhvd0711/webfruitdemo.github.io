<%-- 
    Document   : HomePage
    Created on : Jun 15, 2021, 9:48:24 PM
    Author     : boybe
--%>

<%@page import="dao.AccountDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="hero_area">
            
            <!-- header section strats -->
            <div class="brand_box">
                <label class="navbar-brand" >
                    <span>
                        Ninom<>
                    </span>
                </label>
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
                                <img src="images/shop-img.jpg" width="450" height="600" alt="">
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

        <!-- end nav section -->

        <!-- shop section -->

        <section class="shop_section layout_padding">
            <div class="container">
                <div class="box">
                    <div class="detail-box">
                        <h2>
                            Fruit shop
                        </h2>
                        <p>
                            There are many variations of passages of Lorem Ipsum available
                        </p>
                    </div>
                    <div class="img-box">
                        <img src="images/shop-img.jpg" alt="">
                    </div>
                    <div class="btn-box">
                        <a href="FruitsServlet">Buy Now</a>
                    </div>
                </div>
            </div>
        </section>

        <!-- end shop section -->

        <!-- about section -->

        <section class="about_section">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6 px-0">
                        <div class="img-box">
                            <img src="images/about-img.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="detail-box">
                            <div class="heading_container">
                                <hr>
                                <h2>
                                    About Our Fruit Shop
                                </h2>
                            </div>
                            <p>
                                Cai nay de gioi thieu ten trang voi ten thanh vien cung nhu cong viec cua thanh vien di
                            </p>
                            <a href="">
                                Read More
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- end about section -->

        <!-- fruit section -->

        <section class="fruit_section layout_padding">
            <div class="container">
                <div class="heading_container">
                    <hr>
                    <h2>
                        Fresh Fruit
                    </h2>
                </div>
            </div>
            <div class="container-fluid">

                <div class="fruit_container">
                    <c:forEach items="${listcategories}" var="o">
                        <div class="box">
                        <img src="images/${o.image}" alt="">
                        <div class="link_box">
                            <h5>
                                ${o.name}
                            </h5>
                            <a href="FruitsServlet?cid=${o.id}">
                                Buy Now
                            </a>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </section>

        <!-- end fruit section -->          

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
                                    FPT 
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
