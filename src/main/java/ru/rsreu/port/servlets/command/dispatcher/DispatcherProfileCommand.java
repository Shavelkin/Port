package ru.rsreu.port.servlets.command.dispatcher;


import javax.servlet.ServletException;
import java.io.IOException;

import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.servlets.FrontCommand;


public class DispatcherProfileCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward(Jsp.DISPATCHER_PROFILE);
    }
}
