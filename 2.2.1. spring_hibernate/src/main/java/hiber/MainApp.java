package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1",
               "user1@mail.ru", new Car("Mod1", 2107)));
      userService.add(new User("User2", "Lastname2",
               "user2@mail.ru", new Car("Mod2", 2012)));
      userService.add(new User("User3", "Lastname3",
               "user3@mail.ru", new Car("Mod3", 1903)));
      userService.add(new User("User4", "Lastname4",
               "user4@mail.ru", new Car("Mod4", 3317)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      System.out.println(userService.findUser("Mod3", 1903));
      context.close();
   }
}
