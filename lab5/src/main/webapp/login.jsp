<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <title>Login Page</title>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            </head>

            <body>

                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-md-6 col-lg-5">
                            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
                            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action="Login"
                                method="post">
                                <div class="form-group">
                                    <label for="username">Username</label>
                                    <input id="username" name="username" type="text" class="form-control"
                                        placeholder="Username">
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input id="password" type="password" name="password" class="form-control"
                                        placeholder="Password">
                                </div>
                                <div class="form-check">
                                    <input id="remember" type="checkbox" name="remember" class="form-check-input">
                                    <label for="remember" class="form-check-label">Remember username and
                                        password</label>
                                </div>
                                <div class="form-group">
                                    <c:if test="${sessionScope.flashMessage != null}">
                                        <div class="alert alert-danger alertContainer-dismissible">
                                            <c:out value="${sessionScope.flashMessage}" />
                                        </div>
                                        <% session.removeAttribute("flashMessage"); %>
                                    </c:if>
                                    <button class="btn btn-success px-5">Login</button>
                                </div>
                            <div class="form-group">
                                <p>Don't have account? <a href="register.jsp">Click here</a></p>
                            </div>
                            </form>

                        </div>
                    </div>
                </div>

            </body>

            </html>