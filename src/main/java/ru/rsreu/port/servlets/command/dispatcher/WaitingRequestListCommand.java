package ru.rsreu.port.servlets.command.dispatcher;

import ru.rsreu.port.entity.CaptainRequest;
import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.service.CaptainRequestService;
import ru.rsreu.port.service.ServiceFactory;
import ru.rsreu.port.servlets.FrontCommand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class WaitingRequestListCommand extends FrontCommand {

    private CaptainRequestService requestService;
    @Override
    public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
        super.init(servletContext, servletRequest, servletResponse);
        requestService = ServiceFactory.getCaptainRequestService();
    }

    @Override
    public void process() throws ServletException, IOException {
        List<CaptainRequest> requests = requestService.getWaitingRequests();
        request.setAttribute("waitingRequest", requests);
        forward(Jsp.WAITING_REQUEST_LIST);
    }

}
