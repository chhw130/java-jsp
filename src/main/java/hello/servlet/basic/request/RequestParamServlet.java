package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송
 * /request-param?name=choi&age=30
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getParameterNames();

        String userName = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("username = " + userName);
        System.out.println("age = " + age);

//        req.getParameterNames().asIterator()
//                        .forEachRemaining( parName -> System.out.println("paramName : " + parName));
    }
}
