package ru.rsreu.port.servlets.command;

import ru.rsreu.port.enums.Route;
import ru.rsreu.port.servlets.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.rmi.ServerException;

public class LogoutCommand  extends FrontCommand {

    @Override
    public void process() throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        redirect(Route.LOGIN.getAbsolute());
    }


}
