package ru.rsreu.port.servlets.command.dispatcher;

import ru.rsreu.port.entity.enums.Type;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.enums.Route;
import ru.rsreu.port.service.CaptainRequestService;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.servlets.FrontCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RejectRequestCommand extends FrontCommand {

    private CaptainRequestService captainRequestService;

    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        captainRequestService = ServiceFactory.getCaptainRequestService();
    }

    @Override
    public void process() throws ServletException, IOException {
        forward(Jsp.REJECT_REQUEST);
    }

    @Override
    public void send() throws ServletException, IOException {
        Integer reqId = Integer.valueOf(request.getParameter("id"));
        try {
            captainRequestService.changeStatusToRejected(reqId);
            redirect(Route.WAITING_REQUEST_LIST.getAbsolute());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
