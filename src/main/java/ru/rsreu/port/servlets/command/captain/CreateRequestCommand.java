package ru.rsreu.port.servlets.command.captain;

import ru.rsreu.port.config.AuthConfig;
import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.entity.enums.Type;
import ru.rsreu.port.service.CaptainRequestService;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.servlets.FrontCommand;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.entity.CaptainRequest;
import ru.rsreu.port.entity.User;
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
        forward(Jsp.CREATE_REQUEST);
    }

    @Override
    public void send() throws ServletException, IOException {
        try {
            CaptainRequest captainRequest = mapCaptainRequestFromRequest();
//            User user = UserUtil.getFromRequest(request).get();
            User user = new User(1, "cap1", "qwerty1", "Petya", Roles.CAPTAIN);
            captainRequest.setCaptainId(user.getUserId());
            captainRequestService.createRequest(captainRequest);
            response.sendRedirect(AuthConfig.getStartPage(user.getUserRole()).getAbsolute());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    private CaptainRequest mapCaptainRequestFromRequest() {
        return new CaptainRequest(
                0,
                null,
                1,
                //"24-JAN-12",
                DateUtil.getCurrentDate(),
                CaptainRequestStatus.WAITING,
                Type.ENTERING
        );
    }

}
