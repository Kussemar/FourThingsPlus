package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Item;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewItems", value = "/viewitems")
public class ViewItems extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Hent alle items fra DB igen

        HttpSession session = request.getSession(); // Giver os session objektet, fra da man loggede ind. Så gemmer den i sessionscopet, som den her linje hjælper med.
        User user = (User) session.getAttribute("user");

        if(user == null){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        List<Item> itemList = null;
        try {
            itemList = ItemFacade.getAllItems(user.getUsername(), connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.setAttribute("itemList", itemList);
        // Forwad tilbage til welcome siden
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
