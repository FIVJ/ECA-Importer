package dao;

import db.PersistenceUtil;
import static db.PersistenceUtil.closeEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import model.TbSubfunctions;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tassio
 */
public class TbSubfunctionsDAO {

    Logger logger = Logger.getLogger("DAO");
    public static TbSubfunctionsDAO subfunctionsDAO;

    public static TbSubfunctionsDAO getInstance() {
        if (subfunctionsDAO == null) {
            subfunctionsDAO = new TbSubfunctionsDAO();
        }
        return subfunctionsDAO;
    }

    public TbSubfunctions save(TbSubfunctions value) {
        logger.trace("Start Method");

        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            value = em.merge(value);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            logger.error("Unexpected error", e);
        } finally {
            logger.trace("Ended Method");
        }

        return value;
    }

    public List<TbSubfunctions> getAll() {
        logger.trace("Start Method");
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            javax.persistence.Query query = em.createQuery("from TbSubfunctions As a");
            return query.getResultList();
        } catch (Exception ex) {
            logger.error("Unexpected error", ex);
        } finally {
            logger.trace("Ended Method");
            closeEntityManager();
        }
        return null;
    }

    private static Session session;
    
    public TbSubfunctions get(int value) {
        logger.trace("Start Method");
        try {
            session = PersistenceUtil.getSession();
            Query query = session.createQuery("select a from TbSubfunctions as a where  a.intCodSubfunction=:value");
            query.setParameter("value", value);
            query.setCacheable(true);

            List<TbSubfunctions> instances = query.list();
            if (instances != null && instances.size() > 0) {
                return instances.get(0);
            }
            return null;
        } catch (Exception ex) {
            logger.error("Unexpected error", ex);
        } finally {
            logger.trace("Ended Method");
        }
        return null;
    }

    public void delete(TbSubfunctions value) {
        logger.trace("Start Method");
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            value = em.merge(value);
            em.remove(value);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            logger.error("Unexpected error", e);
        } finally {
            logger.trace("Ended Method");
            closeEntityManager();
        }
    }

    public void deleteAll() {
        logger.trace("Start Method");
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            javax.persistence.Query query = em.createQuery(" delete from TbSubfunctions");
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            em.getTransaction().rollback();
        } finally {
            logger.trace("Ended Method");
            closeEntityManager();
        }
    }
}
