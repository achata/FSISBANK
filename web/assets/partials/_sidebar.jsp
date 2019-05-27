<nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item">
              <a class="nav-link" href="general.jsp">
              <i class="mdi mdi-home menu-icon"></i>
              <span class="menu-title">Principal</span>
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
              <i class="mdi mdi-compass menu-icon"></i>
              <span class="menu-title">Mantemiento</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="pages/ui-features/accordions.html">Agregar nuevo cliente</a></li>
                <li class="nav-item"> <a class="nav-link" href="../modules/mantenimiento.jsp">Lista  de clientes</a></li>
              </ul>
            </div>
          </li>
         <li class="nav-item">
            <a class="nav-link" data-toggle="collapse" href="#ui-basic1" aria-expanded="false" aria-controls="ui-basic">
              <i class="mdi mdi-compass menu-icon"></i>
              <span class="menu-title">Movimientos</span>
              <i class="menu-arrow"></i>
            </a>
            <div class="collapse" id="ui-basic1">
              <ul class="nav flex-column sub-menu">
                <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/modulos/movimiento/deposito.jsp">Depósito</a></li>
              </ul>
            </div>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="pages/widgets/widgets.html">
                <i class="mdi mdi-puzzle menu-icon"></i>
                <span class="menu-title">Retiro</span>
              </a>
          </li>

          
        
        </ul>
      </nav>