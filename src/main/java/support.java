import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "support")
public class support extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        int number=new Random().nextInt(50000);
        String supportEmail=this.getServletContext().getInitParameter("support_email");
        String resp="<html lang='en'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <link href='support.css' rel='stylesheet'/>\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>" +
                "<div class='centerEl'> " +
                "Thank  you! "+name+" for contacting us. " +
                "We should receive reply from us with in 24 hrs in " +
                "your email address "+email+". Let us know in " +
                "our support email "+supportEmail+" if you don’t receive reply within 24 hrs." +
                " Please be sure to attach your reference "+number+" in your email." +
                "</div>" +
                "</body>";

        response.getWriter().println(resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();

        String htmlFile="<html lang='en'>\n" +
                "<head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <link href='support.css' rel='stylesheet'/>\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form method='Post'>" +
                "<div>\n" +
                "    <div><label>Name : <input type='text' name='name'/></label></div>\n" +
                "    <div><label>Email address : <input type='email' name='email'/></label></div>\n" +
                "    <div><label>Problem : <input type='text' name='problem'/></label></div>\n" +
                "    <div><label>Problem description :<textarea name='probDesc' row='10' cols='35'></textarea></label></div>\n" +
                "    <div><input type='submit'/></label></div>\n" +
                "</div>\n" +
                "</form>" +
                "</body>\n" +
                "</html>";
        out.println(htmlFile);
    }
}
