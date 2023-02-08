package ru.rsreu.port.servlets.command.admin;

import ru.rsreu.port.dto.UserListResponseDTO;
import ru.rsreu.port.entity.User;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.service.UserService;
import ru.rsreu.port.servlets.FrontCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserListCommand extends FrontCommand {
    //private SessionService sessionService;
    private UserService userService;
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        userService = ServiceFactory.getUserService();
    }

    @Override
    public void process() throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        request.setAttribute("users", users);
        //List<UserListResponseDTO> sessions = sessionService.getAllUserList(user);
        //request.setAttribute("role", user.getUserRole());
        //request.setAttribute("sessions", sessions);
        forward(Jsp.USER_LIST);
    }
}
