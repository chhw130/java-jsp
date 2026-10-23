package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServelt extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();

        printHeaders(req);

    }

    private void printHeaders(HttpServletRequest request){
        System.out.println("=====Header Start====");

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + headerName);
        }

        System.out.println();

        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }

        System.out.println("====Header End====");
        System.out.println();
    }
}
