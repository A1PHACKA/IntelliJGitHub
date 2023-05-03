package com.example.ervletexam3;

import java.io.*;
import java.util.Enumeration;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// 서블릿은 메모리에 하나만 올라간다.
// init은 메모리에 올라간후 딱 한번만 호출된다.
//               context path
// http://ip:8080  /  /hello-servlet
//servlet path를 설정
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        System.out.println("init() 호출");
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 요청정보
        // GET /hello-servlet
        // 헤어들
        // 빈줄

        // Iterator, Enumeration는 모든 자료를 꺼낼때 사용.
        // Iterator는 디자인패턴의 이름
        // Enumeration Iterator와 비슷
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) { // hasMoreElements : 꺼낼 것이 있느냐?
            String headerName = headerNames.nextElement(); // nextElement : 꺼내라
            System.out.println(headerName + ": " + request.getHeader(headerName));
        }

        // 브라우저야 내가 지금 보내는 것은 html이야.
        response.setContentType("text/html");

        // 응답의 Body에 쓰기위한 PringWriter를 받아온다.
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}