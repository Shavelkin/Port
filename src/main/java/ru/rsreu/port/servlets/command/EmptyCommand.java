package ru.rsreu.port.servlets.command;

import ru.rsreu.port.enums.Jsp;
//import ru.rsreu.port.resourcer.ProjectResourcer;
import ru.rsreu.port.servlets.FrontCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EmptyCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward(Jsp.NOT_FOUND);
    }

    @Override
    public void send() throws ServletException, IOException {

    }
}

