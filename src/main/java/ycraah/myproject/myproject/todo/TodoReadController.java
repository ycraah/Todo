package ycraah.myproject.myproject.todo;

import ycraah.myproject.myproject.dto.TodoDTO;
import ycraah.myproject.myproject.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Long tno = Long.parseLong(request.getParameter("tno"));
    TodoDTO dto = TodoService.INSTANCE.get(tno);
    request.setAttribute("dto", dto);
    request.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(request, response);
  }
}
