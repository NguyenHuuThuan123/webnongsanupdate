<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<!-- Start header section -->
<jsp:include page = "./header/mainHeader.jsp" flush = "true" />

<!-- catg header banner section -->
<section id="aa-catg-head-banner">
    <img src="${pageContext.request.contextPath}/view/client/assets/images/archive-banner.png" alt="banner blog">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Đăng ký</h2>
                <ul class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
                    <li style="color:#fff">Đăng ký tài khoản</li>
                </ul>
            </div>
        </div>
    </div>
</section>
<!-- / catg header banner section -->
<!-- Cart view section -->
<section id="aa-myaccount">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-myaccount-area">
                    <div class="row">
                        <div class="col-md-8 col-md-push-2">
                            <div class="aa-myaccount-login">
                                <form action="${pageContext.request.contextPath}/view/client/register" method="post" name="formRegister" class="aa-register-form">
                                    <h4>Đăng ký</h4>
                                    <input type="hidden" name="roleid" value="2">
                                    <label for="email">Email <span>*</span></label>
                                    <input id="email" type="text" placeholder="useremail@gmail.com" name="email" required autofocus
                                           oninvalid="this.setCustomValidity('Vui lòng nhập Email')">
                                    <label for="name">Họ tên<span>*</span></label>
                                    <input id="name" type="text" placeholder="Name" name="name" required>
                                    <label for="phone">Số điện thoại<span>*</span></label>
                                    <input id="phone" type="text" placeholder="Phone number" name="phone" required>
                                    <label for="username">Tên đăng nhập<span>*</span></label>
                                    <input id="username" type="text" placeholder="Username" name="username" required
                                           autofocus
                                           oninvalid="this.setCustomValidity('Vui lòng nhập Tên đăng nhập')">
                                    <label for="password">Mật khẩu<span>*</span></label>
                                    <input id="password" type="password" placeholder="Password" name="password" required>
                                    <%--                                        <label for="password-again">Xác nhận mật khẩu<span>*</span></label>--%>
                                    <%--                                        <input id="password-again" type="password" placeholder="Password" name="password" required>--%>
                                    <input type="hidden" name="status" value="1">
                                    <input type="date" style="display: none" placeholder="Password" name="created" id="the-date">

                                    <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
                                            : request.getAttribute("errMessage")%></p>
                                    <p style="color:red; display: block;"><%=(request.getAttribute("Message") == null) ? ""
                                            : request.getAttribute("Message")%></p>

                                    <button type="reset" class="aa-browse-btn" value="Reset" style="width: 25%;float: left">Đặt lại</button>
                                    <button type="submit" class="aa-browse-btn" style="width: 74%;float: right">ĐĂNG KÝ</button>
                                    <div class="register-with">- Hoặc -</div>
                                    <button style="width: 49%;float: left" type="submit" class="btn-sign-up-google">
                                        <img class="google-icon" src="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg"/>Google
                                    </button>
                                    <button style="width: 49%;float: right" type="submit" class="btn-sign-up-facebook">
                                        <div style="font-size: 0.55rem;"><i class="fab fa-facebook-f fa-4x facebook-icon"></i></div>Facebook
                                    </button>
                                    <div class="title-span">Bạn đã là thành viên? <a style="color: #337ab7;" href="${pageContext.request.contextPath}/view/client/login">Đăng nhập</a>.</div>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</section>
<!-- / Cart view section -->

<!--  end content-->
<script>
    var date = new Date();
    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();
    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;
    var today = year + "-" + month + "-" + day;
    document.getElementById('the-date').value = today;
</script>
<!--  footer-->
<jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->