package es.tew.business;

import java.util.Optional;
import es.tew.model.User;

public interface UserService {
    Optional<User> verify(User user);
}