package ru.rsreu.port.servlets.command.admin;

import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.enums.Route;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.service.UserService;
import ru.rsreu.port.servlets.FrontCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeUserCommand extends FrontCommand {

    private UserService userService;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        userService = ServiceFactory.getUserService();
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(Jsp.CHANGE_USER);
    }

    @Override
    public void send() throws ServletException, IOException {
        Integer userId = Integer.valueOf(request.getParameter("id"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        Roles role = Roles.valueOf(request.getParameter("userRole"));
        User newUser = new User(userId, login, password, name, role);
        try {
            userService.updateUser(userId, newUser);
            redirect(Route.ADMIN_PROFILE.getAbsolute());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

}
