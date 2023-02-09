package ru.rsreu.port.servlets.command.captain;

import ru.rsreu.port.entity.CaptainRequest;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.service.CaptainRequestService;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.servlets.FrontCommand;
import ru.rsreu.port.utils.UserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InfoCurrentRequestCommand extends FrontCommand {

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
        request.setAttribute("captainRequest", captainRequest);
        try {
            if (captainRequestService.findNumberRequestByCaptain(userId) != 0) {
                forward(Jsp.INFO_CURRENT_REQUEST);
            } else {
                forward(Jsp.CAPTAIN_PROFILE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

    @Override
    public void send() throws ServletException, IOException {


        try {
//            CaptainRequest captainRequest = new CaptainRequest();
//            captainRequestService.createRequest(captainRequest);
            forward(Jsp.CAPTAIN_PROFILE);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

}
