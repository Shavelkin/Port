package ru.rsreu.port.servlets.command.captain;


import javax.servlet.ServletException;
import java.io.IOException;

import ru.rsreu.port.enums.Jsp;
import ru.rsreu.port.servlets.FrontCommand;


public class CaptainProfileCommand extends FrontCommand {
    @Override
    public void process() throws ServletException, IOException {
        forward(Jsp.CAPTAIN_PROFILE);
    }
}
