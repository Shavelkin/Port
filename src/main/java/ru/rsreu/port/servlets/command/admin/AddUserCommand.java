package ru.rsreu.port.servlets.command.admin;

import ru.rsreu.port.entity.CaptainRequest;
import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.service.CaptainRequestService;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.service.UserService;
import ru.rsreu.port.servlets.FrontCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserCommand extends FrontCommand{

    private UserService userService;
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        userService = ServiceFactory.getUserService();
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(Jsp.ADD_USER);
    }

    @Override
    public void send() throws ServletException, IOException {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            Roles role = Roles.valueOf(request.getParameter("userRole"));
        try {
            User user = new User(login, password, name, role);
            userService.addUser(user);
            forward(Jsp.ADMIN_PROFILE);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

}
