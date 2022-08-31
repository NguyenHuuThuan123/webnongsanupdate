<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

<!-- Start header section -->
<jsp:include page = "./header/mainHeader.jsp" flush = "true" />
<!-- / header section -->
<!--  content -->
<!-- catg header banner section -->
<section id="aa-catg-head-banner">
    <img src="${pageContext.request.contextPath}/view/client/assets/images/archive-banner.png" alt="banner blog">
    <div class="aa-catg-head-banner-area">
        <div class="container">
            <div class="aa-catg-head-banner-content">
                <h2>Quên mật khẩu</h2>
                <ol class="breadcrumb">
                    <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>
                    <li style="color:#fff">Quên mật khẩu</li>
                </ol>
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
                            <div class="aa-myaccount-forgotPass">
                                <h4>Lấy lại mât khẩu</h4>
                                <form action="${pageContext.request.contextPath}/quen-mat-khau" name="formRegister" class="aa-login-form" method="post">
                                    <label for="email">Email<span>*</span></label>
                                    <input id="email" type="text" placeholder="useremail@gmail.com" name="email"required autofocus
                                           oninvalid="this.setCustomValidity('Vui lòng nhập Email')">
                                    <p style="color:red; display: block;"><%=(request.getAttribute("Message") == null) ? ""
                                            : request.getAttribute("Message")%></p>
                                    <p style="color:red; display: block;"><%=(request.getAttribute("errMessage") == null) ? ""
                                            : request.getAttribute("errMessage")%></p>
                                    <button type="submit" class="aa-browse-btn">Tiếp theo</button>
                                    <div class="title-span"><a style="color: #337ab7;" href="${pageContext.request.contextPath}/view/client/login">Quay lại</a></div>
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
<!--  footer-->
<jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->