package converter.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import converter.ejb.ConverterBean;

@WebServlet(name = "ConverterServlet", urlPatterns = {"/ConverterServlet"})
public class ConverterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private ConverterBean cb = new ConverterBean();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        // Output the results
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Temperature Converter</title>");
        out.println("<style>");
        out.println("body { background-color: #f0f0f0; font-family: Arial, sans-serif; text-align: center; }");
        out.println("h1 { color: #007BFF; }");
        out.println("form { background-color: #ffffff; padding: 20px; border-radius: 5px; display: inline-block; }");
        out.println("input[type='text'] { width: 100px; padding: 5px; border: 1px solid #ccc; border-radius: 3px; }");
        out.println("input[type='submit'] { background-color: #007BFF; color: #fff; border: none; padding: 5px 10px; margin: 5px; cursor: pointer; border-radius: 3px; }");
        out.println("p { margin: 10px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Temperature Converter </h1>");
        try {
            String degree = request.getParameter("degree");
            if ((degree != null) && (degree.length() > 0)) {
                double d = Double.parseDouble(degree);
                if (request.getParameter("C TO R") != null) {
                    String centigrade = cb.ctor(d); 
                    out.println("<p>" + degree + " Celcius are " + centigrade + " Reamur.</p>");
                }
                if (request.getParameter("R TO C") != null) {
                    String reamur = cb.rtoc(d);
                    out.println("<p>" + degree + " Reamur are " + reamur + " Celcius.</p>");
                }
            } else {
                out.println("<p>Enter degree to convert:</p>");
                out.println("<form method=\"get\">");
                out.println("<p> <input type=\"text\" name=\"degree\" size=\"25\"></p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"R TO C\" value=\"R TO C\">"
                        + "<input type=\"submit\" name=\"C TO R\" value=\"C TO R\">");
                out.println("</form>");
            }
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
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
