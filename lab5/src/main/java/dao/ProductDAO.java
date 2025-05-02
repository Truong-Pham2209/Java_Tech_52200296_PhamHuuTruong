package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Product;

public class ProductDAO {
    private static ProductDAO insance;

    private ProductDAO() {
    }

    public static ProductDAO getInstance() {
        if (insance == null)
            insance = new ProductDAO();
        return insance;
    }

    public List<Product> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            List<Product> products = session.createQuery("From Product", Product.class).list();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void save(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction tran = session.beginTransaction();
            session.persist(product);
            tran.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getLastestID() {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            return session.createQuery("select id from Product order by id desc limit 1", Integer.class).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void delete(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            Transaction tran = session.beginTransaction();
            session.remove(session.get(Product.class, id));
            tran.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
