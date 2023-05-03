package com.example.ervletexam3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// ?이하를 파라미터
// 파라미터 구조 : 이름1=값1&이름2=값2&이름3=값3
// http://localhost:8080/plus?x=10&y=20
@WebServlet(name = "PlusServlet", value = "/plus")
public class PlusServlet extends HttpServlet {
    // GET, POST 모두 처리하는 메소드.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strX = req.getParameter("x"); //?x=10&y=20 전달되지 않으면 null을 반환
        String strY = req.getParameter("y");

        // 입력받은 값이 올바른지 검증.

        int x = Integer.parseInt(strX);
        int y = Integer.parseInt(strY);

        int value = x + y;

        req.setAttribute("x", x);
        req.setAttribute("y", y);
        req.setAttribute("value", value);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/plus.jsp");
        requestDispatcher.forward(req, resp); // 포워딩. (포워딩과 리다이렉트)
    }
}
