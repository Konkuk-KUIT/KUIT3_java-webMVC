package core.db;

import jwp.model.User;

import java.util.Collection;
import java.util.Optional;

public interface Repository {
  void addUser(User user);

  Optional<User> findUserById(String id);

  Collection<User> findAll();

  boolean existsUserById(String userId);

  void changeUserInfo(User user);
}
