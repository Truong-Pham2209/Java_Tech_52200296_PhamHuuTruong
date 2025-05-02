<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css    "
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
      p.item {
        padding: 16px;
        text-align: center;
        border-radius: 8px;
        color: white;
        background-color: green;
      }
    </style>
  </head>

  <body class="bg-secondary">
    <h3 class="text-center my-5 text-light">Account Registration</h3>

    <!-- buộc toàn bộ dòng và cột phải bỏ trong class container -->
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-10 col-lg-8 col-xl-5">
          <div class="border p-3 rounded bg-light">
            <form action="Register" method="post">
              <div class="form-group">
                <label for="name">Username</label>
                <div class="input-group mb-3">
                  <div class="input-group-prepend">
                    <span class="input-group-text">
                      <i class="fas fa-user"></i>
                    </span>
                  </div>
                  <input
                    id="name"
                    name="name"
                    type="text"
                    class="form-control"
                    placeholder="Your Name"
                    required
                  />
                </div>

                <div class="form-group">
                  <label for="email">Email</label>
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="fas fa-user"></i>
                      </span>
                    </div>
                    <input
                      id="email"
                      name="email"
                      type="text"
                      class="form-control"
                      placeholder="Email"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label for="password">Password</label>
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="fas fa-lock"></i>
                      </span>
                    </div>
                    <input
                      id="password"
                      name="password"
                      type="password"
                      class="form-control"
                      placeholder="Password"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                  <label for="password-confirm">Confirm Password</label>
                  <div class="input-group mb-3">
                    <div class="input-group-prepend">
                      <span class="input-group-text">
                        <i class="fas fa-lock"></i>
                      </span>
                    </div>
                    <input
                      id="password-confirm"
                      type="password"
                      class="form-control"
                      placeholder="Password"
                      required
                    />
                  </div>
                </div>
                <div class="form-group" id="alertContainer">
                  <div
                    class="alert alert-danger alertContainer-dismissible fade show"
                  >
                    <button
                      type="button"
                      class="close"
                      data-dismiss="alertContainer"
                    >
                      &times;
                    </button>
                    <div id="error-message">
                      Password must have at least 6 characters!
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <button class="btn btn-success px-5" type="submit">
                    Register
                  </button>
                </div>
                <div class="form-group">
                  <p>
                    Already have an account? <a href="login.jsp">Login now!</a>
                  </p>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script>
    function checkPassword() {
      let passwordInput = $("#password");
      let passwordConfirmInput = $("#password-confirm");
      if (passwordInput.val().length < 6) {
        $("#error-message").text("Password must have at least 6 characters!");
        return false;
      }
      if (passwordInput.val() != passwordConfirmInput.val()) {
        $("#error-message").text("Password confirm is not match!");
        return false;
      }
      if ($("#name").val().indexOf(" ") !== -1) {
        $("#error-message").text("Username cannot contain spaces!");
        return false;
      }

      return true;
    }
    $('button[type="submit"]').click((e) => {
      if (!checkPassword()) {
        $("#alertContainer").show();
        e.preventDefault();
        return;
      }
      $("#alertContainer").hide();
    });
  </script>
</html>
