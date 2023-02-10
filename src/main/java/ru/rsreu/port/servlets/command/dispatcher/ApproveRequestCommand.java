package ru.rsreu.port.servlets.command.dispatcher;

import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.entity.enums.Type;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.enums.Route;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.service.CaptainRequestService;
import ru.rsreu.port.servlets.FrontCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApproveRequestCommand extends FrontCommand {

    private CaptainRequestService captainRequestService;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        captainRequestService = ServiceFactory.getCaptainRequestService();
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(Jsp.APPROVE_REQUEST);
    }

    @Override
    public void send() throws ServletException, IOException {
        Integer reqId = Integer.valueOf(request.getParameter("id"));
        Integer idPier = Integer.valueOf(request.getParameter("idPier"));
        Type type = captainRequestService.findById(reqId).getType();
        try {
            captainRequestService.changeStatusToApproved(reqId);
            switch (type) {
                case ENTERING: {
                    captainRequestService.setPier(reqId, idPier);
                };
                case ENTERING_WITH_PILOT: {
                    captainRequestService.setPier(reqId, idPier);
                };
                case EXITING: {
                    captainRequestService.freePier(idPier);
                }
                case EXITING_WITH_PILOT: {
                    captainRequestService.freePier(idPier);
                }
            }
            redirect(Route.WAITING_REQUEST_LIST.getAbsolute());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

}
