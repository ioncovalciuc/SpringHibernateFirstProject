package md.covalciuc.testSpringMVC;
import md.covalciuc.testSpringMVC.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.BlockingDeque;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {
//        BlockingDeque<Connection> pool = null;
//
//        Connection connection = DriverManager
//                .getConnection("db.url","db.username","db.password");
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()){
            session.beginTransaction();

            User user = User.builder()
                    .username("ivan@hmail.com")
                    .firstname("Ivan")
                    .lastname("Ivanov")
                    .birth_date(LocalDate.of(2000,1,19))
                    .age(20)
                    .build();
            User user12 = User.builder()
                    .username("roma@gmail.com")
                    .firstname("Roma")
                    .lastname("Rusu")
                    .birth_date(LocalDate.of(2002,10,1))
                    .age(19)
                    .build();
            //session.save(user);//I have added user object in my table users
            //session.save(user12);//I have added user12 object in my table users

            session.getTransaction().commit();
        }

    }

}
