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

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()){
            session.beginTransaction();

            User user = User.builder()
                    .username("covalciuc@gmail.com")
                    .firstname("Ion")
                    .lastname("Covalciuc")
                    .birth_date(LocalDate.of(2000,5,13))
                    .age(23)
                    .build();


            session.save(user);//I have added new object in my table users using Test1 class

            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}
