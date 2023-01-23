package ru.rsreu.port.crutches;


import ru.rsreu.port.entity.enums.Roles;

import java.util.Map;

public class crutchesDB {

    private static final Map<String, Roles> PseudoDB = Map.ofEntries(
            Map.entry("admin", Roles.ADMIN),
            Map.entry("dispatcher", Roles.DISPATCHER),
            Map.entry("captain", Roles.CAPTAIN));

    public static Roles findRolesByLogin(String login){
        return crutchesDB.PseudoDB.get(login);
    }

}
