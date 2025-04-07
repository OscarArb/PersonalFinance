package Controlador;

import Clases.clsObjeto;
import Modelos.inicio;
import Modelos.mdlGasto;
import Modelos.mdlIngreso;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Control", urlPatterns = {"/Control"})
public class Control extends HttpServlet {

    int ide;
    int agregado = 0;
    inicio inicio = new inicio();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String menu = request.getParameter("menu");
            String accion = request.getParameter("accion");

            if (menu.equals("Index")) {
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            if (menu.equals("Principal")) {
                request.getRequestDispatcher("inicio.jsp").forward(request, response);
            }
            
            if (menu.equals("Ingreso")) {
                String idUser = inicio.usuario();
                System.out.println("Soy el usuario ejecutado en proceso INGRESOS: " + idUser);
                request.getRequestDispatcher("ingreso.jsp").forward(request, response);

                switch (accion) {
                    case "Listar":

                        String nom = "Oscar Arrieta Basilio";
                        request.setAttribute("em", nom);

                        request.getRequestDispatcher("Empleado.jsp").forward(request, response);

                        break;

                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));
                        mdlIngreso mdlIngreso = new mdlIngreso();
                        int repuesta = mdlIngreso.eliminarCliente(ide);
                        String r2 = String.valueOf(repuesta);
                        request.setAttribute("em", r2);
                        request.getRequestDispatcher("ingreso.jsp").forward(request, response);
                        break;

                    case "Actualizar":
                        String id = request.getParameter("txtCodigo");
                        String detalle = request.getParameter("txtNombre");
                        String valor = request.getParameter("txtValor");
                        String fechapago = request.getParameter("txtFecha");

                        clsObjeto ActualizarI = new clsObjeto(id, detalle, fechapago, valor, idUser);
                        int estado;
                        mdlIngreso IngresoAct = new mdlIngreso();
                        estado = IngresoAct.Actualizar(ActualizarI);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            if (menu.equals("Gasto")) {
                String idUser = inicio.usuario();
                System.out.println("Soy el usuario ejecutado en proceso Gastos: " + idUser);
                request.getRequestDispatcher("gasto.jsp").forward(request, response);
                switch (accion) {
                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));
                        mdlGasto mdlGasto = new mdlGasto();
                        int repuesta = mdlGasto.eliminarGasto(ide);
                        String r2 = String.valueOf(repuesta);
                        request.setAttribute("em", r2);
                        request.getRequestDispatcher("gasto.jsp").forward(request, response);
                    case "listar":
                        request.getRequestDispatcher("vistas/gastos.jsp").forward(request, response);
                        break;
                    case "Pagado":
                        String idPagado = request.getParameter("txtCodigo");
                        String detallePagado = request.getParameter("txtNombre");
                        String valorPagado = request.getParameter("txtValor");
                        String fechapagoPagado = request.getParameter("txtFecha");
                        clsObjeto gPagado = new clsObjeto(idPagado, detallePagado, fechapagoPagado, valorPagado, idUser);
                        int es;
                        mdlGasto gastoPagado = new mdlGasto();
                        es = gastoPagado.GenerarPago(gPagado);
                    case "Realizar Abono":
                        String id = request.getParameter("txtCodigo");
                        String detalle = request.getParameter("txtNombre");
                        String valor = request.getParameter("txtValor");
                        String fechapago = request.getParameter("txtFecha");
                        clsObjeto gActualizar = new clsObjeto(id, detalle, fechapago, valor, idUser);
                        int estado;
                        mdlGasto gastoActualizar = new mdlGasto();
                        estado = gastoActualizar.GenerarAbono(gActualizar);
                        break;
                    case "Actualizar":
                        String idUpdate = request.getParameter("txtCodigo");
                        String detalleUpdate = request.getParameter("txtNombre");
                        String valorUpdate = request.getParameter("txtValor");
                        String fechapagoUpdate = request.getParameter("txtFecha");
                        clsObjeto gUpdate = new clsObjeto(idUpdate, detalleUpdate, fechapagoUpdate, valorUpdate, idUser);
                        int estadoUpdate;
                        mdlGasto gastoUpdate = new mdlGasto();
                        estado = gastoUpdate.Actualizar(gUpdate);
                        break;
                }
            }
            if (menu.equals("Producto")) {
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
            if (menu.equals("Graficas")) {
                request.getRequestDispatcher("Graficas.jsp").forward(request, response);
            }
            if (menu.equals("Registros")) {
                String idUser = inicio.usuario();
                System.out.println("Soy el usuario ejecutado en proceso REGISTROS: " + idUser);
                if (agregado > 0) {
                    request.setAttribute("em", "Prueba");

                }
                request.getRequestDispatcher("registros.jsp").forward(request, response);
                switch (accion) {
                    case "Agregar":
                        //Recibo valores desde formulario registros.jsp
                        String opcion = request.getParameter("txtCodigo");
                        String detalleA = request.getParameter("txtActividad");
                        String fechadepago = request.getParameter("txtFechaEntrega");
                        String valordepago = request.getParameter("txtArea");
                        if (opcion.equals("Gasto")) {
                            agregado = 0;
                            clsObjeto CrearGasto = new clsObjeto(opcion, detalleA, fechadepago, valordepago, idUser);
                            mdlGasto gastoCrear = new mdlGasto();
                            agregado = gastoCrear.Crear(CrearGasto);

                        } else if (opcion.equals("Ingreso")) {
                            agregado = 0;
                            clsObjeto CrearIngreso = new clsObjeto(opcion, detalleA, fechadepago, valordepago, idUser);
                            mdlIngreso IngresoCrear = new mdlIngreso();
                            agregado = IngresoCrear.Crear(CrearIngreso);
                            request.setAttribute("em", "PruebaDos");
                        }

                        break;
                }
            }
        } catch (Exception e) {
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
