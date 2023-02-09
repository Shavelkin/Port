package ru.rsreu.port.servlets.command.admin;

import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.enums.Route;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.service.UserService;
import ru.rsreu.port.servlets.FrontCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserCommand extends FrontCommand {

    private UserService userService;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        userService = ServiceFactory.getUserService();
    }

    @Override
    public void send() throws ServletException, IOException {
        Integer userId = Integer.valueOf(request.getParameter("user_id"));
        Roles userRole = Roles.valueOf(request.getParameter("user_role"));
        userService.deleteUser(userId, userRole);
        redirect(Route.ADMIN_PROFILE.getAbsolute());
    }

}
