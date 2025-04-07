package Controlador;

//import Modelo.mdlEmpleado;
import Clases.Empleado;
import Modelos.inicio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    inicio edao = new inicio();
    Empleado em = new Empleado();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

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
        try {
            String accion = request.getParameter("accion");
            if (accion.equalsIgnoreCase("login")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if (accion.equalsIgnoreCase("Ingresar")) {
                String user = request.getParameter("txtuser");
                String pass = request.getParameter("txtpass");
                em = edao.Consultar(user, pass);

                if (em.getUser() != null) {
                    request.setAttribute("usuario", em);

                    request.getRequestDispatcher("Control?menu=Index").forward(request, response);

                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }
            } else if (accion.equalsIgnoreCase("Registrar")) {
                System.out.println("Nuevo registro");
                String Nnombre = request.getParameter("newNombre");
                String NTel = request.getParameter("newTel");
                String NUser = request.getParameter("newUser");
                String Npass = request.getParameter("newPas");
                int opcion = 0;
                Empleado CrearUs = new Empleado(opcion, Npass, Nnombre, NTel, NUser);
                inicio CrearUser = new inicio();
                int agregado = CrearUser.Crear(CrearUs);

                if (agregado > 0) {
                    System.out.println("Agredo correctamente");
                    request.setAttribute("usuario", em);
                    request.getRequestDispatcher("reg_exitoso.jsp").forward(request, response);
                    //request.getRequestDispatcher("Control?menu=Index").forward(request, response);

                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }
            } else {

                request.getRequestDispatcher("index.jsp").forward(request, response);

            }
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
