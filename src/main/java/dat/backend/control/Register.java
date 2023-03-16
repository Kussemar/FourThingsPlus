package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Item;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ItemFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // invalidating user object in session scope
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmpassword = request.getParameter("confirmpassword");

        if(!password.equals(confirmpassword)) {
            request.setAttribute("message","Passwords did not match.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

        try
        {
            User user = UserFacade.createUser(username, password, "user", connectionPool);

            session = request.getSession();
            session.setAttribute("user", user); // adding user object to session scope

            try
            {
                List<Item> itemList = ItemFacade.getAllItems(user.getUsername(), connectionPool);
                request.setAttribute("itemList", itemList);
            } catch (DatabaseException e)
            {
                // Hvis noget er gået galt i vores ItemMapper
                request.setAttribute("errormessage", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

            // request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
            response.sendRedirect("viewitems");
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }


}

