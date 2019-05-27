<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <jsp:include page="../../assets/partials/_navbar.jsp"></jsp:include>

          <div class="row">
            <div class="col-md-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">Depositar a una cuenta de ahorros</h5>
                  <form id="FormDeposito" class="forms-sample" id="" method="POST" action="../../Movimiento">
                    <div class="form-group">
                      <label for="codcuenta">Número de cuenta:</label>
                      <input type="text" class="form-control" id="codcuenta" value="" name="codcuenta" maxlength="8" placeholder="Número de cuenta">
                    </div>
                    <div class="form-group">
                      <label for="monto">Monto a Depositar:</label>
                      <input type="text" class="form-control" id="monto" name="monto" placeholder="Monto a depositar">
                    </div>

                      <input name="registrarDeposito" type="submit" class="btn btn-primary mr-2" value="registrarDeposito">
                  </form>
                  <div class="my-2">${mensaje}</div>   
                </div>
              </div>
            </div>
                
          </div>
    <jsp:include page="../../assets/partials/_footer.jsp"></jsp:include>
      
  
       
