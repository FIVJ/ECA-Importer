package dao;

import db.PersistenceUtil;
import java.util.List;
import model.PbfSaques2012;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tassio
 */
public class PbfSaques2012DAO {

    Logger logger = Logger.getLogger("DAO");
    public static PbfSaques2012DAO pbfDAO;

    public static PbfSaques2012DAO getInstance() {
        if (pbfDAO == null) {
            pbfDAO = new PbfSaques2012DAO();
        }
        return pbfDAO;
    }

    private Session session;

    public void save(PbfSaques2012 pbf) {
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

    public List<PbfSaques2012> getAll() {
        logger.trace("Start Method");
        try {
            session = PersistenceUtil.getSession();
            Query query = session.createQuery("from PBF_SAQUES");
            List<PbfSaques2012> list = query.list();
            session.close();
            return list;
        } catch (Exception ex) {
            logger.error("Unexpected error", ex);
        }
        logger.trace("Ended Method");
        return null;
    }

    public PbfSaques2012 deletePbf(int id) {
        logger.trace("Start Method");
        Transaction tx = null;
        try {
            session = (Session) PersistenceUtil.getSession();
            PbfSaques2012 pbf = (PbfSaques2012) session.get(PbfSaques2012.class, new Integer(id));
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
            Query query = session.createQuery("delete from PBF_SAQUES_2012");
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
