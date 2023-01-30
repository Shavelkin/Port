package ru.rsreu.port.servlets.command;


//import ru.rsreu.port.config.AuthConfig;
//import ru.rsreu.port.constant.RequestParam;
import ru.rsreu.port.config.AuthConfig;
import ru.rsreu.port.crutches.crutchesDB;
import ru.rsreu.port.database.impl.UserDAOImpl;
import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.enums.Route;
//import ru.rsreu.port.service.ServiceFactory;
//import ru.rsreu.port.service.SessionService;
import ru.rsreu.port.servlets.FrontCommand;
import ru.rsreu.port.utils.UserUtil;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand extends FrontCommand {
//    private SessionService sessionService;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
//        sessionService = ServiceFactory.getSessionService();
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(Jsp.LOGIN);
    }

    @Override
    public void send() throws ServletException, IOException {
        String username = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            User user = UserDAOImpl.findUserByLogin(username);
            Roles role = user.getUserRole();
            Route startRoute = AuthConfig.getStartPage(role);
            Cookie userCookie = UserUtil.createUserCookie(user);
            response.addCookie(userCookie);
            response.sendRedirect(startRoute.getAbsolute());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}