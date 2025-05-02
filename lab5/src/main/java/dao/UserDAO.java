package dao;

import model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
    private static UserDAO instance;

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        if (instance == null)
            instance = new UserDAO();
        return instance;
    }

    public User getUserById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User where username = :name", User.class)
                    .setParameter("name", username).setMaxResults(1).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tran = session.beginTransaction();
            session.persist(user);
            tran.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkLogin(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Long result = session
                    .createQuery("select count(*) from User where username = :username and password = :password",
                            Long.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();

            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
