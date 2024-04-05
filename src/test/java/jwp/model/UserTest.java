//package jwp.model;
//
//import jwp.model.dto.UpdateUser;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//class UserTest {
//  User user;
//
//  @BeforeEach
//  void init() {
//    user = User.of("jungwoo1", "1", "jungwoo", "jungwoo@gmail.com");
//  }
//
//  @Test
//  void update() {
//    User user1 = User.of("jungwoo1", "2", "jungwoo2", "jungwoo2@gmail.com");
//    user.update(user1);
//    assertEquals("2", user.getPassword());
//    assertEquals("jungwoo2", user.getName());
//    assertEquals("jungwoo2@gmail.com", user.getEmail());
//  }
//
//  @Test
//  void matchPassword() {
//    assertTrue(user.matchPassword("1"));
//  }
//
//  @Test
//  void isSameUser() {
//    assertTrue(user.isSameUser(User.of("jungwoo1", "2", "jungwoo2", "jungwoo2@gmail.com")));
//  }
//
//}