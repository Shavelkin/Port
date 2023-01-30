package ru.rsreu.port.service;

import ru.rsreu.port.database.DAOFactory;
import ru.rsreu.port.database.dao.SessionDAO;
import ru.rsreu.port.dto.UserListResponseDTO;
import ru.rsreu.port.entity.Session;
import ru.rsreu.port.entity.User;
import ru.rsreu.port.entity.enums.Roles;
import ru.rsreu.port.entity.enums.SessionStatus;
import ru.rsreu.port.utils.SessionUtil;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SessionService {
    public static final long SESSION_TIME_LIVE = 1000 * 60 * 60;
    private static SessionService instance;
    private final SessionDAO sessionDAO;
    private final UserService userService;

    public SessionService(SessionDAO sessionDAO, UserService userService) {
        this.sessionDAO = sessionDAO;
        this.userService = userService;
    }

    public static SessionService getInstance() {
        synchronized (SessionService.class) {
            if (instance == null) {
                instance = new SessionService(DAOFactory.getSessionDAO(), ServiceFactory.getUserService());
            }
        }
        return instance;
    }

    public Optional<Session> getSession(Integer userId) {
        return sessionDAO.findByUserId(userId);
    }

    public User createSession(String login, String password) throws Exception {
        User user = userService.getUser(login);

        if (!user.getPassword().equals(password)) {
            throw new Exception("Not user");
        }

        Date activeUntil = new Date(System.currentTimeMillis() + SESSION_TIME_LIVE);
        Optional<Session> optionalSession = sessionDAO.findByUserId(user.getUserId());
        Session session = optionalSession.isPresent() ?
                optionalSession.get().setActiveUntil(activeUntil) :
                new Session(user, activeUntil);
//                optionalSession.orElseGet(() -> new Session(user, activeUntil));

        if (!optionalSession.isPresent()) {
            sessionDAO.save(session);
        } else {
            sessionDAO.update(session);
        }

        return user;
    }

    public List<Session> getAllSessions() {
        return sessionDAO.findAll();
    }

//    public List<UserListResponseDTO> getAllUserList(User user) {
//        List<Session> sessions = this.getAllSessions();
//        return sessions.stream().filter(session -> !session.getUser().getUserRole().equals(Roles.ADMIN))
//                .map(session -> new UserListResponseDTO(
//                session.getSession_id(),
//                session.getUser(),
//                session.getActiveUntil(),
//                session.getActiveUntil() != null && SessionUtil.checkValid(session) ?
//                SessionStatus.AUTHORIZED : SessionStatus.NOT_AUTHORIZED
//    )).filter(userListResponseDTO -> !userListResponseDTO.getUser().getUserId().equals(user.getUserId()))
//                .collect(Collectors.toList());
//    }
    public List<Session> getAllSessionsByUserStatus(String userStatus) {
        return sessionDAO.findAll();
    }

}
