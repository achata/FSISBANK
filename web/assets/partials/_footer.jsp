        </div>
        <!-- content-wrapper ends -->
        <!-- partial:${pageContext.request.contextPath}/assets/${pageContext.request.contextPath}/assets${pageContext.request.contextPath}/assets/partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2019</span>
          </div>
        </footer>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
</body>

  <!-- container-scroller -->
  <!-- plugins:js -->
  <script src="${pageContext.request.contextPath}/assets/vendors/js/vendor.bundle.base.js"></script>
  <script src="${pageContext.request.contextPath}/assets/vendors/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="${pageContext.request.contextPath}/assets/js/off-canvas.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/hoverable-collapse.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/template.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/settings.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/todolist.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
  <script>
      $("#FormDeposito").validate({
        errorPlacement: function(label, element) {
            label.addClass('text-danger mt-2 text-right d-block');
            label.insertAfter(element);
        },
        highlight: function(element, errorClass) {
        $(element).parent().addClass('has-danger')
        $(element).addClass('form-control-danger')
        },
         rules:{
             codcuenta: {
                 required: true,
                 digits: true,
                 minlength: 8,
                 maxlength:8
             },
             monto:{
                 required: true,
                 number: true
             }
             
         },
         messages:{
             codcuenta:{
                 required: "Este campo es requerido",
                 digits: "Sólo se aceptan dígitos",
                 minlength:"Mínimo {0} dígitos",
                 maxlength:"Máximo {0} dígitos"
             },
             monto:{
                 required: "Este campo es requerido",
                 number: "Debe ingresar un monto válido"
             }
         }
      });
  </script>
</html>
