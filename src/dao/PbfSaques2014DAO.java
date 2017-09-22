package dao;

import db.PersistenceUtil;
import java.util.List;
import model.PbfSaques2014;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tassio
 */
public class PbfSaques2014DAO {

    Logger logger = Logger.getLogger("DAO");
    public static PbfSaques2014DAO pbfDAO;

    public static PbfSaques2014DAO getInstance() {
        if (pbfDAO == null) {
            pbfDAO = new PbfSaques2014DAO();
        }
        return pbfDAO;
    }

    private Session session;

    public void save(PbfSaques2014 pbf) {
        logger.trace("Start Method");
        Transaction tx = null;
        try {
            session = (Session) PersistenceUtil.getSession();
            tx = session.beginTransaction();
            session.save(pbf);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            tx.rollback();
        } finally {
            logger.trace("Ended Method");
            session.close();
        }
    }

    public List<PbfSaques2014> getAll() {
        logger.trace("Start Method");
        try {
            session = PersistenceUtil.getSession();
            Query query = session.createQuery("from PBF_SAQUES");
            List<PbfSaques2014> list = query.list();
            session.close();
            return list;
        } catch (Exception ex) {
            logger.error("Unexpected error", ex);
        }
        logger.trace("Ended Method");
        return null;
    }

    public PbfSaques2014 deletePbf(int id) {
        logger.trace("Start Method");
        Transaction tx = null;
        try {
            session = (Session) PersistenceUtil.getSession();
            PbfSaques2014 pbf = (PbfSaques2014) session.get(PbfSaques2014.class, new Integer(id));
            tx = session.beginTransaction();
            session.delete(pbf);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            tx.rollback();
        } finally {
            logger.trace("Ended Method");
            session.close();
        }
        return null;
    }

    public void deleteAllPbf() {
        logger.trace("Start Method");
        Transaction tx = null;
        try {
            session = (Session) PersistenceUtil.getSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from PBF_SAQUES_2014");
            query.executeUpdate();
            session.flush();
            tx.commit();
        } catch (Exception e) {
            logger.error("Unexpected error", e);
            tx.rollback();
        } finally {
            logger.trace("Ended Method");
            session.close();
        }
    }

}
