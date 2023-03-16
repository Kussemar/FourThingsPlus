package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Item;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;
import dat.backend.model.persistence.ItemMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddItem", value = "/additem")
public class AddItem extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8"); //TODO

        String actionAttribute = (String) request.getParameter("action");
        if (actionAttribute != null) {
            String[] split = actionAttribute.split("-");
            String action = split[0];
            int id = Integer.parseInt(split[1]);
            switch (action) {
                case "done":
                    ItemFacade.toggleItem(id, connectionPool);
                    // SEnd til DB at den er done
                    break;
                case "delete":
                    ItemFacade.deleteItem(id, connectionPool);
                    // fjern fra DB
                    break;

            }
        } else {


            // Hent alle værdier som skal gemmes i databasen.
            String newItem = request.getParameter("newitem");
            HttpSession session = request.getSession(); // Giver os session objektet, fra da man loggede ind. Så gemmer den i sessionscopet, som den her linje hjælper med.
            User user = (User) session.getAttribute("user");

            try {
                // Gem data
                ItemFacade.addItem(newItem, user.getUsername(), connectionPool);

                // Hent alle items fra DB igen
                List<Item> itemList = ItemFacade.getAllItems(connectionPool);
                request.setAttribute("itemList", itemList);


            } catch (DatabaseException e) {
                request.setAttribute("errormessage", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        }
        response.sendRedirect("viewitems");
    }
}
