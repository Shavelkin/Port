package ru.rsreu.port.database.config;


import ru.rsreu.port.enums.Route;
import ru.rsreu.port.servlets.FrontCommand;
import ru.rsreu.port.servlets.command.*;
import ru.rsreu.port.servlets.command.admin.AddUserCommand;
import ru.rsreu.port.servlets.command.admin.AdminProfileCommand;
import ru.rsreu.port.servlets.command.admin.UserListCommand;
import ru.rsreu.port.servlets.command.captain.CaptainProfileCommand;
import ru.rsreu.port.servlets.command.dispatcher.DispatcherProfileCommand;
import ru.rsreu.port.servlets.command.captain.CreateRequestCommand;

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
            Route.USER_LIST
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

