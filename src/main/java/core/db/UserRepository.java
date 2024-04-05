package core.db;

import jwp.model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository {
  void addUser(User user);

  Optional<User> findUserById(String userId);

  Collection<User> findAll();

  boolean existsUserById(String userId);

  void changeUserInfo(User user);
}
