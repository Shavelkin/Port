package ru.rsreu.port.database.config;

import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.enums.Route;

import java.util.List;
import java.util.Map;

public class AuthConfig {
    private static final Map<Roles, List<Route>> RolesRoutes = Map.ofEntries(
            Map.entry(Roles.ADMIN, List.of(
                    Route.LOGIN
            )),
            Map.entry(Roles.DISPATCHER, List.of(
                    Route.LOGIN
            )),
            Map.entry(Roles.CAPTAIN, List.of(

            ))
    );

    private static final Map<Roles, Route> RolesStartPage = Map.ofEntries(
            Map.entry(Roles.DISPATCHER, Route.DISPATCHER_PROFILE),
            Map.entry(Roles.CAPTAIN, Route.CAPTAIN_PROFILE),
            Map.entry(Roles.ADMIN, Route.ADMIN_PROFILE)
    );

    public static List<Route> getRoutes(Roles Roles) {
        return RolesRoutes.get(Roles);
    }

    public static Route getStartPage(Roles Roles) {
        return RolesStartPage.get(Roles);
    }
}

