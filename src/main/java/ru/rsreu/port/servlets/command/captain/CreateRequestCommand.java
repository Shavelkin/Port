package ru.rsreu.port.servlets.command.captain;

import ru.rsreu.port.entity.enums.Type;
import ru.rsreu.port.service.CaptainRequestService;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.servlets.FrontCommand;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.entity.CaptainRequest;
import ru.rsreu.port.entity.enums.CaptainRequestStatus;
import ru.rsreu.port.utils.DateUtil;
import ru.rsreu.port.utils.UserUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateRequestCommand extends FrontCommand {
    private CaptainRequestService captainRequestService;
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        captainRequestService = ServiceFactory.getCaptainRequestService();
    }

    @Override
    public void process() throws ServletException, IOException {
        Integer userID = UserUtil.getUserIdFromCookies(request.getCookies()).get();
        try {
            if (captainRequestService.findCurrentRequestByCaptain(userID) == 0) {
                forward(Jsp.CREATE_REQUEST);
            } else { forward(Jsp.CAPTAIN_PROFILE); }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

    @Override
    public void send() throws ServletException, IOException {
        try {
            CaptainRequest captainRequest = generateRequestTemplate();
            captainRequestService.createRequest(captainRequest);
            forward(Jsp.CAPTAIN_PROFILE);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private CaptainRequest generateRequestTemplate() {
        return new CaptainRequest(
                0,
                UserUtil.getUserIdFromCookies(request.getCookies()).get(),
                -1,
                DateUtil.getCurrentDate(),
                CaptainRequestStatus.WAITING,
                Type.ENTERING
        );
    }

}
