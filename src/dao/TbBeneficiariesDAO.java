package dao;

import db.PersistenceUtil;
import static db.PersistenceUtil.closeEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import model.TbBeneficiaries;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author tassio
 */
public class TbBeneficiariesDAO {

    Logger logger = Logger.getLogger("DAO");
    public static TbBeneficiariesDAO beneficiariesDAO;

    public static TbBeneficiariesDAO getInstance() {
        if (beneficiariesDAO == null) {
            beneficiariesDAO = new TbBeneficiariesDAO();
        }
        return beneficiariesDAO;
    }

    public TbBeneficiaries save(TbBeneficiaries value) {
        logger.trace("Start Method");
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            value = em.merge(value);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            System.err.print(value);
            logger.error("Unexpected error", e);
        } finally {
            logger.trace("Ended Method");
        }
        return value;
    }

    public void persist(TbBeneficiaries value) {
        logger.trace("Start Method");
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(value);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
            logger.error("Unexpected error", e);
        } finally {
            logger.trace("Ended Method");
        }
    }

    public void insert(String value) {
        logger.trace("Start Method");
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            javax.persistence.Query query = em.createQuery(value);
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            em.getTransaction().rollback();
        } finally {
            logger.trace("Ended Method");
        }
    }

    public List<TbBeneficiaries> getAll() {
        logger.trace("Start Method");
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            javax.persistence.Query query = em.createQuery("from TbBeneficiaries As a");
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

    public TbBeneficiaries get(String value) {
        logger.trace("Start Method");
        try {
            session = PersistenceUtil.getSession();
            Query query = session.createQuery("select a from TbBeneficiaries as a where a.strNis=:value");
            query.setParameter("value", value);
            query.setCacheable(true);

            List<TbBeneficiaries> instances = query.list();
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

    public TbBeneficiaries search(String value1, String value2) {
        logger.trace("Start Method");
        try {
            session = PersistenceUtil.getSession();
            Query query = session.createQuery("select a from TbBeneficiaries as a where a.strNis=:valueA and a.strNamePerson=:valueB");
            query.setParameter("valueA", value1);
            query.setParameter("valueB", value2);

            List<TbBeneficiaries> instances = query.list();
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

    public void delete(TbBeneficiaries value) {
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
            javax.persistence.Query query = em.createQuery(" delete from TbBeneficiaries");
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
