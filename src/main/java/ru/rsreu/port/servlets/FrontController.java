package ru.rsreu.port.servlets;

import ru.rsreu.port.database.config.CommandConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "frontServlet", value = "/front-servlet")
public class FrontController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = CommandConfig.getCommand(request.getPathInfo());

        try {
            command.init(getServletContext(), request, response);
            command.process();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrontCommand command = CommandConfig.getCommand(request.getPathInfo());

        try {
            command.init(getServletContext(), request, response);
            command.send();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
