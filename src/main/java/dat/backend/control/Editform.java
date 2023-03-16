package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Item;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Editform", value = "/editform")
public class Editform extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        Item item = null;
        try {
            item = ItemFacade.getItemById(item_id, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.setAttribute("item", item);
        request.getRequestDispatcher("WEB-INF/editform.jsp").forward(request,response);

    }


}
