package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

//@WebServlet("/upload")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        InputStream fileContent = filePart.getInputStream();
        if(fileContent!=null){
            InputStreamReader isr = new InputStreamReader(fileContent);
            BufferedReader reader = new BufferedReader(isr);
            PrintWriter out = response.getWriter();
            String text;

            // We read the file line by line and later will be displayed on the
            // browser page.
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            while ((text = reader.readLine()) != null) {
                out.println(text + "</br>");
            }
            out.println("</body>");
            out.println("</html>");

        }
       // request.setAttribute("file", "something");
        //request.getRequestDispatcher("file_content.jsp").forward(request, response);;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
