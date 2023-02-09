package ru.rsreu.port.servlets.command.captain;

import ru.rsreu.port.entity.CaptainRequest;
import ru.rsreu.port.enums.Route;
import ru.rsreu.port.service.CaptainRequestService;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.servlets.FrontCommand;
import ru.rsreu.port.utils.UserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelRequestCommand extends FrontCommand {
    private CaptainRequestService captainRequestService;
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        captainRequestService = ServiceFactory.getCaptainRequestService();
    }

    @Override
    public void process() throws ServletException, IOException {
        Integer userId = UserUtil.getUserIdFromCookies(request.getCookies()).get();
        CaptainRequest captainRequest = captainRequestService.findCurrentRequestByCaptain(userId);
        captainRequestService.changeStatusToCancelled(captainRequest.getId());
        try {
            redirect(Route.CAPTAIN_PROFILE.getAbsolute());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
