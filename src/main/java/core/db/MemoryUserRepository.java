package core.db;

import jwp.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryUserRepository implements Repository {
  private Map<String, User> users = new HashMap<>();
  private static MemoryUserRepository memoryUserRepository;

  private MemoryUserRepository() {
  }

  public static MemoryUserRepository getInstance() {
    if (memoryUserRepository == null) {
      memoryUserRepository = new MemoryUserRepository();
      return memoryUserRepository;
    }
    return memoryUserRepository;
  }

  @Override
  public void addUser(User user) {
    users.put(user.getUserId(), user);
  }

  @Override
  public Optional<User> findUserById(String userId) {
    return Optional.ofNullable(users.get(userId));
  }

  @Override
  public boolean existsUserById(String userId) {
    return users.containsKey(userId);
  }

  @Override
  public Collection<User> findAll() {
    return users.values();
  }

  @Override
  public void changeUserInfo(User user) {
    if (users.get(user.getUserId()) != null) {
      users.put(user.getUserId(), user);
    }
  }
}
