<!DOCTYPE html>
<html lang="en">


<!-- Mirrored from www.urbanui.com/silica/template/demo/vertical-fixed/pages/samples/login-2.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 May 2019 18:20:11 GMT -->
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Login - EUREKABANK</title>
  <!-- plugins:css -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link rel="stylesheet" href="assets/vendors/css/vendor.bundle.base.css"/>
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="assets/css/vertical-layout-light/styles.css"/>
  <!-- endinject -->
  <link rel="shortcut icon" href="../../../../images/favicon.png" />
</head>

<body class="sidebar-fixed">
  <div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
      <div class="content-wrapper d-flex align-items-stretch auth auth-img-bg">
        <div class="row flex-grow">
          <div class="col-lg-6 d-flex align-items-center justify-content-center">
            <div class="auth-form-transparent text-left p-3">
              <div class="brand-logo">
                <img src="http://www.urbanui.com/silica/template/images/logo-blue.svg" alt="logo">
              </div>

              <form id="formLogin" class="pt-3" method="POST" action="Empleado">
                  <input type="hidden" name="accion" value="valid"/>
                <div class="form-group">
                  <label for="exampleInputEmail">Usuario</label>
                  <div class="input-group">
                    <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="material-icons text-primary">account_circle</i>
                      </span>
                    </div>
                      <input type="text" class="form-control form-control-lg border-left-0" id="usuario" name="usuario" placeholder="usuario">
                  </div>
                 <div class="errorMessage text-danger"></div>

                </div>
                <div class="form-group">
                  <label for="exampleInputPassword">Contraseña</label>
                  <div class="input-group">
                    <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="material-icons text-primary">lock_open</i>
                      </span>
                    </div>
                      <input type="password" class="form-control form-control-lg border-left-0" id="clave" name="clave" placeholder="contraseña">                        
                  </div>
                  <div class="errorMessage text-danger"></div>
                </div>

                <div class="my-3">
                    <input type="submit" value="Ingresar" name="login" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn"/>
                </div>

              </form>
              <div class="my-2">${mensaje}</div>
            </div>
          </div>
          <div class="col-lg-6 login-half-bg d-flex flex-row">
            <p class="text-white font-weight-medium text-center flex-grow align-self-end">Copyright &copy; 2019.</p>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="vendors/js/vendor.bundle.base.js"></script>
  <script src="vendors/js/vendor.bundle.addons.js"></script>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- endinject -->
  <!-- inject:js -->
  <!-- endinject -->
  <script>
      $("#formLogin").submit(function(e){
          if (!validateFields()) {
            return false;
          }         
      });
      function validateFields(){
          var isValid = true;
          $("input[type='text'], input[type='password']").each(function(){
            if ($(this).val() == "") {
              $(this).parent().siblings(".errorMessage").html("Este campo es requerido");
              isValid= false;
            }else{
              $(this).parent().siblings(".errorMessage").html("");
            }  
          });  
          return isValid;
      }
  </script>
</body>


<!-- Mirrored from www.urbanui.com/silica/template/demo/vertical-fixed/pages/samples/login-2.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 May 2019 18:20:11 GMT -->
</html>
