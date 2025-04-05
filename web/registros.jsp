
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList" %>
<%@page import="Clases.clsObjeto" %>
<%@page import="Modelos.mdlIngreso" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.min.css" />
    </head>
    <body>
        <%!
            mdlIngreso GastoDAO = new mdlIngreso();
        %>


        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Datos Del Registro</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="Control?menu=Registros"  method="POST" role="form">
                        <div class="row">

                            <div class="col-6">
                                <label>Tipo De Registro: </label>
                                    <select name="txtCodigo" class="form-control" id="txtCodigo">
                                        <option value="Gasto">1. Gasto</option>
                                        <option value="Ingreso">2. Ingreso</option>
                                    </select>
                            </div>

                            <div class="col-6">
                                <label>Detalles:</label>
                                <input type="text" name="txtActividad" class="form-control" id="txtActividad">
                            </div>


                        </div>


                        <div class="row">
                            <div class="col-6">
                                <label>Fecha:</label>
                                <input type="date" name="txtFechaEntrega" class="form-control" id="txtFechaEntrega">
                            </div>
                            <div class="col-6">
                                <label>Valor: </label>
                                <input type="number" name="txtArea" class="form-control" id="txtArea">
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-12">
                                <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js" ></script>
        <script src="https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap5.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.4.38/sweetalert2.all.min.js"></script>

        <%
            System.out.println(request.getAttribute("em") + "kfabfhbdhfbk");
            if (request.getAttribute("em") != null) {
                System.out.println("eliminado correctamente");
        %>

        <script>
            $(document).ready(function () {
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: '<%= request.getAttribute("em")%>',
                    showConfirmButton: false,
                    timer: 3000
                });
            });
        </script>
        <%
            }
        %>

        <script src="${pageContext.servletContext.contextPath}/js/gasto.js"></script>
    </body>
</html>
