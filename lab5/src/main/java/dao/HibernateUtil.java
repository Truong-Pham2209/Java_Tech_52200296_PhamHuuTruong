package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private SessionFactory sessionFactory;
    private static HibernateUtil instance;

    private HibernateUtil() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (instance == null)
            instance = new HibernateUtil();
        return instance.sessionFactory;
    }
}
