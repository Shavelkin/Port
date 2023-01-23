package ru.rsreu.port.crutches;


import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.Roles;


public class crutchesDB {

    private static final User userAdmin = new User(0,"Vasya", "admin", "qwerty", Roles.ADMIN);
    private static final User userDispatcher = new User(1,"Vanya", "dispatcher", "qwerty", Roles.DISPATCHER);
    private static final User userCaptain = new User(2,"Petya", "captain", "qwerty", Roles.CAPTAIN);

    private static final User[] arrayUser = {userAdmin, userDispatcher, userCaptain};

//    private static final Map<String, User> PseudoDB = (Map<String, User>) Map.ofEntries(
//            Map.entry("admin", userAdmin),
//            Map.entry("dispatcher", Roles.DISPATCHER),
//            Map.entry("captain", Roles.CAPTAIN));
    public static User findUserByLogin(String login){

        for (int i = 0; i < arrayUser.length; i++) {
            if (arrayUser[i].getLogin().equals(login)){
                return arrayUser[i];
            }
        }
        return null;
    }

}
