package ru.rsreu.port.database.config;


import ru.rsreu.port.enums.Route;
import ru.rsreu.port.servlets.FrontCommand;
import ru.rsreu.port.servlets.command.*;
import ru.rsreu.port.servlets.command.admin.*;
import ru.rsreu.port.servlets.command.captain.*;
import ru.rsreu.port.servlets.command.dispatcher.ActiveRequestListCommand;
import ru.rsreu.port.servlets.command.dispatcher.DispatcherProfileCommand;
import ru.rsreu.port.servlets.command.dispatcher.WaitingRequestListCommand;
//import ru.rsreu.port.servlets.command.admin.*;
//import ru.rsreu.port.servlets.command.driver.*;
//import ru.rsreu.port.servlets.command.moder.*;
//import ru.rsreu.port.servlets.command.passenger.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CommandConfig {
    private static final Map<Route, FrontCommand> commands = Map.ofEntries(
            Map.entry(Route.LOGIN, new LoginCommand()),
            Map.entry(Route.LOGOUT, new LogoutCommand()),
            Map.entry(Route.ADMIN_PROFILE, new AdminProfileCommand()),
            Map.entry(Route.CAPTAIN_PROFILE, new CaptainProfileCommand()),
            Map.entry(Route.DISPATCHER_PROFILE, new DispatcherProfileCommand()),
            Map.entry(Route.CREATE_REQUEST, new CreateRequestCommand()),
            Map.entry(Route.ADD_USER, new AddUserCommand()),
            Map.entry(Route.USER_LIST, new UserListCommand()),
            Map.entry(Route.WAITING_REQUEST_LIST, new WaitingRequestListCommand()),
            Map.entry(Route.ACTIVE_REQUEST_LIST, new ActiveRequestListCommand()),
            Map.entry(Route.INFO_CURRENT_REQUEST, new InfoCurrentRequestCommand()),
            Map.entry(Route.INFORM_ABOUT_MOVEMENT, new InformAboutMovementCommand()),
            Map.entry(Route.CANCEL_REQUEST, new CancelRequestCommand()),
            Map.entry(Route.DELETE_USER, new DeleteUserCommand()),
            Map.entry(Route.CHANGE_USER, new ChangeUserCommand()),

            Map.entry(Route.NOT_FOUND, new EmptyCommand())
    );

    private static final List<Route> commandRoutes = Arrays.asList(
            Route.LOGIN,
            Route.LOGOUT,
            Route.NOT_FOUND,
            Route.ADMIN_PROFILE,
            Route.CAPTAIN_PROFILE,
            Route.DISPATCHER_PROFILE,
            Route.CREATE_REQUEST,
            Route.ADD_USER,
            Route.USER_LIST,
            Route.ACTIVE_REQUEST_LIST,
            Route.WAITING_REQUEST_LIST,
            Route.INFO_CURRENT_REQUEST,
            Route.INFORM_ABOUT_MOVEMENT,
            Route.CANCEL_REQUEST,
            Route.DELETE_USER,
            Route.CHANGE_USER
    );

    public static FrontCommand getCommand(String path) {
        for (Route route : commandRoutes) {
            if (route.getRelative().equalsIgnoreCase(path)) {
                return commands.get(route);
            }
        }
        return new EmptyCommand();
    }
}

