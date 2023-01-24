package ru.rsreu.port.config;


import ru.rsreu.port.enums.Route;
import ru.rsreu.port.servlets.FrontCommand;
import ru.rsreu.port.servlets.command.*;
import ru.rsreu.port.servlets.command.admin.AdminProfileCommand;
import ru.rsreu.port.servlets.command.captain.CaptainProfileCommand;
import ru.rsreu.port.servlets.command.dispatcher.DispatcherProfileCommand;
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
            Map.entry(Route.ADMIN_PROFILE, new AdminProfileCommand()),
            Map.entry(Route.CAPTAIN_PROFILE, new CaptainProfileCommand()),
            Map.entry(Route.DISPATCHER_PROFILE, new DispatcherProfileCommand()),
            Map.entry(Route.NOT_FOUND, new EmptyCommand())
    );

//            Map.entry(Route.LOGOUT, new LogoutCommand()),
//            Map.entry(Route.MARKS, new MarksCommand()),
//            Map.entry(Route.USER_INFO, new UserInfoCommand()),
//
//            Map.entry(Route.DRIVER_PROFILE, new DriverProfileCommand()),
//            Map.entry(Route.CREATE_TRIP, new CreateTripCommand()),
//            Map.entry(Route.APPROVE_PASSENGER, new ApprovePassengerCommand()),
//            Map.entry(Route.DISAPPROVE_PASSENGER, new DisapprovePassengerCommand()),
//            Map.entry(Route.TRIP_PARAMETERS, new TripParametersCommand()),
//            Map.entry(Route.TRIPS_INFO, new TripsInfoCommand()),
//            Map.entry(Route.DELETE_TRIP, new DeleteTripCommand()),
//            Map.entry(Route.COMPLETE_TRIP, new CompleteTripCommand()),
//            Map.entry(Route.PASSENGER_LIST, new PassengerListCommand()),
//
//            Map.entry(Route.PASSENGER_PROFILE, new PassengerProfileCommand()),
//            Map.entry(Route.CREATE_REQUEST, new CreateRequestCommand()),
//            Map.entry(Route.RATE_DRIVER, new RateDriverCommand()),
//            Map.entry(Route.ACTIVE_REQUESTS, new ActiveRequestsCommand()),
//            Map.entry(Route.REQUESTS_HISTORY, new RequestsHistoryCommand()),
//

//            Map.entry(Route.ADD_USER, new AddUserCommand()),
//            Map.entry(Route.USER_LIST, new UserListCommand()),
//            Map.entry(Route.CHANGE_USER, new ChangeUserCommand()),
//            Map.entry(Route.DELETE_USER, new DeleteUserCommand()),
//
//            Map.entry(Route.MODER_PROFILE, new ModerProfileCommand()),
//            Map.entry(Route.TRIP_LIST, new TripListCommand()),
//            Map.entry(Route.REQUEST_LIST, new RequestListCommand()),
//            Map.entry(Route.BLOCK_USER, new BlockUserCommand()),
//            Map.entry(Route.UNBLOCK_USER, new UnblockUserCommand()),
//
//            Map.entry(Route.CREATE_MARK, new CreateMarkCommand()),
//


    private static final List<Route> commandRoutes = Arrays.asList(
            Route.LOGIN,
//            Route.LOGOUT,
//            Route.CHANGE_USER,
//            Route.DELETE_USER,
//            Route.BLOCK_USER,
//            Route.UNBLOCK_USER,
//            Route.DELETE_TRIP,
//            Route.COMPLETE_TRIP,
//            Route.MARKS,
//            Route.USER_INFO,
            Route.NOT_FOUND,
            Route.ADMIN_PROFILE,
            Route.CAPTAIN_PROFILE,
            Route.DISPATCHER_PROFILE
//            Route.MY_REQUESTS,
//            Route.DRIVER_PROFILE,
//            Route.USERS,
//            Route.CREATE_TRIP,
//            Route.APPROVE_PASSENGER,
//            Route.DISAPPROVE_PASSENGER,
//            Route.TRIP_PARAMETERS,
//            Route.TRIPS_INFO,
//            Route.PASSENGER_PROFILE,
//            Route.CREATE_REQUEST,
//            Route.RATE_DRIVER,
//            Route.ACTIVE_REQUESTS,
//            Route.REQUESTS_HISTORY,
//            Route.ADMIN_PROFILE,
//            Route.ADD_USER,
//            Route.USER_LIST,
//            Route.MODER_PROFILE,
//            Route.TRIP_LIST,
//            Route.PASSENGER_LIST,
//            Route.REQUEST_LIST,
//            Route.CREATE_MARK
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

