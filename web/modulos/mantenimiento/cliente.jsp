<%@page import="bean.Cliente"%>
<%@page import="controller.ClienteServlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
"http://java.sun.com/jsp/jstl/core" 
<jsp:include page="/assets/partials/_navbar.jsp"></jsp:include>

          <div class="row">
            <div class="col-lg-12 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <div class="table-responsive">
                    <form action="${pageContext.request.contextPath}/ClienteServlet" method="POST">
                    <table class="table table-hover table-striped">
                        <input type="hidden" name="operacion" value="clientes">
                        <div class="row">
                        <div class="form-group col-md-4">
                            <label for="nombre">Nombre:</label>
                            <input type="text" class="form-control" id="nombre" name="nombre">
                        </div>
                        <div class="form-group col-md-3">
                            <label for="dni">Dni:</label>
                            <input type="text" class="form-control" id="dni" name="dni">
                        </div>
                        <div class="col-md-4 text-right"><br>
                            <button type="submit" class="btn btn-info mt-1 mx-1" data-dismiss="modal">Buscar</button>
                            <button type="button" class="btn btn-primary mt-1 mx-1" data-toggle="modal" data-target="#exampleModal-2">Nuevo<i class="mdi mdi-play-circle ml-1"></i></button>
                        </div>
                      <thead>
                        <tr>
                        <th>Nombre completo</th>
                        <th>Dni</th>
                        <th>Ciudad</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>Email</th>
                        <th>Acciones</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="item" items="${requestScope.listadoCliente}">
                        <tr>
                            <td>${item.nombreCompleto}</td>
                            <td>${item.dni}</td>
                            <td>${item.ciudad}</td>
                            <td>${item.direccion}</td>
                            <td>${item.telefono}</td>
                            <td>${item.email}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/ClienteServlet?operacion=buscarXId&idCliente=${item.id}" data-toggle="modal" data-target="#modalEdit" >E</a>
                                <a href="${pageContext.request.contextPath}/ClienteServlet?operacion=eliminar&idCliente=${item.id}">D</a>
                            </td>
                        </tr>
                        </c:forEach>
                      </tbody>
                    </table>
                    </form> 
                  </div>
                </div>
              </div>
            </div>
          </div>


  <!--*********Modal******-->
  <div class="modal fade" id="exampleModal-2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel-2" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel-2">Agregar cliente</h5>
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                          </button>
                        </div>
                        <div class="modal-body">
                          <form action="${pageContext.request.contextPath}/ClienteServlet" method="POST" class="forms-sample">
                            <input type="hidden" name="operacion" value="newCliente">
                            <div class="row">
                                <div class="form-group col-md-12">
                                  <label for="nombre">Nombre</label>
                                  <input type="text" class="form-control" id="modal-nombre" name="nombre">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                  <label for="apePat">Apellido paterno</label>
                                  <input type="text" class="form-control" id="modal-apePat" name="apePat">
                                </div>
                                <div class="form-group col-md-6">
                                   <label for="apeMat">Apellido materno</label>
                                   <input type="text" class="form-control" id="modal-apeMat" name="apeMat">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label for="dni">Dni</label>
                                    <input type="text" class="form-control" id="modal-dni" name="dni">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="ciudad">Ciudad</label>
                                    <input type="text" class="form-control" id="modal-ciudad" name="ciudad">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="direccion">Dirección</label>
                                    <input type="text" class="form-control" id="modal-direccion" name="direccion">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label for="telefono">Teléfono</label>
                                    <input type="text" class="form-control" id="modal-telefono" name="telefono">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="email">Email</label>
                                    <input type="text" class="form-control" id="modal-email" name="email">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 text-right">
                                    <button type="submit" class="btn btn-primary">Agregar</button>
                                </div>
                            </div>
                          </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Cerrar</button>
                        </div>
                      </div>
                    </div>
                  </div>

                          
                          
<!--Modal Edit***** NO QUERIA HACER ESTO :'v  PERO NO SE ME OCURRE ALGO MEJOR-->
  <div class="modal fade" id="modalEdit" tabindex="-1" role="dialog" aria-labelledby="modalEdit" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title" id="exampleModalLabel-2">editar cliente</h5>
                          <button type="button" class="close" data-dismiss="modalEdit" aria-label="Close">
                            <span aria-hidden="true">×</span>
                          </button>
                        </div>
                        <div class="modal-body">
                            <c:set var="cliente" value="unCliente"/>
                          <form action="${pageContext.request.contextPath}/ClienteServlet" method="POST" class="forms-sample">
                            <input type="hidden" name="operacion" value="unCliente">
                            <div class="row">
                                <div class="form-group col-md-12">
                                  <label for="nombre">Nombre</label>
                                  <input type="text" class="form-control" id="modalEdit-nombre" name="nombre">
                                </div>
                            </div>
                            <div class="row">   
                                <div class="form-group col-md-6">
                                  <label for="apePat">Apellido paterno</label>
                                  <input type="text" class="form-control" id="modalEdit-apePat" name="apePat">
                                </div>
                                <div class="form-group col-md-6">
                                   <label for="apeMat">Apellido materno</label>
                                   <input type="text" class="form-control" id="modalEdit-apeMat" name="apeMat">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label for="dni">Dni</label>
                                    <input type="text" class="form-control" id="modalEdit-dni" name="dni">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="ciudad">Ciudad</label>
                                    <input type="text" class="form-control" id="modalEdit-ciudad" name="ciudad">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-12">
                                    <label for="direccion">Dirección</label>
                                    <input type="text" class="form-control" id="modalEdit-direccion" name="direccion">
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label for="telefono">Teléfono</label>
                                    <input type="text" class="form-control" id="modalEdit-telefono" name="telefono">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="email">Email</label>
                                    <input type="text" class="form-control" id="modalEdit-email" name="email">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 text-right">
                                    <button type="submit" class="btn btn-primary">Agregar</button>
                                </div>
                            </div>
                          </form>
                        </div>
                        <div class="modal-footer">
                          <button type="button" class="btn btn-outline-danger" data-dismiss="modalEdit">Cerrar</button>
                        </div>
                      </div>
                    </div>
                  </div>


<jsp:include page="/assets/partials/_footer.jsp"></jsp:include>        
                            
