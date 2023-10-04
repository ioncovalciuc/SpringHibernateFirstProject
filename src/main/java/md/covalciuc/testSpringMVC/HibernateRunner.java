package md.covalciuc.testSpringMVC;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingDeque;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {
//        BlockingDeque<Connection> pool = null;
//
//        Connection connection = DriverManager
//                .getConnection("db.url","db.username","db.password");
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()){
            System.out.println("OK");
        }

    }

}
