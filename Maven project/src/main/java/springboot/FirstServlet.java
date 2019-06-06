package springboot;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/helloworld")
public class FirstServlet extends HttpServlet {

    //Generic method for all request CRUD
    // response can be plain text or HTML
    public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<!Doctype html>");
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Hello World Servlet!</title>");
        printWriter.println("</head>");
        printWriter.println("<body><p>Hello World !!</p>    </body>");
        printWriter.println("</html>");
        //printWriter.write("Hello World !"); // plain text
        printWriter.close();
    }
}

