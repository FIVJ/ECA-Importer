package dao;

import db.PersistenceUtil;
import java.util.List;
import model.PbfPagamentos2011;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tassio
 */
public class PbfPagamentos2011DAO {

    Logger logger = Logger.getLogger("DAO");
    public static PbfPagamentos2011DAO pbfDAO;

    public static PbfPagamentos2011DAO getInstance() {
        if (pbfDAO == null) {
            pbfDAO = new PbfPagamentos2011DAO();
        }
        return pbfDAO;
    }

    private Session session;

    public void save(PbfPagamentos2011 pbf) {
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

    public List<PbfPagamentos2011> getAll() {
        logger.trace("Start Method");
        try {
            session = PersistenceUtil.getSession();
            Query query = session.createQuery("from PBF_PAGAMENTOS");
            List<PbfPagamentos2011> list = query.list();
            session.close();
            return list;
        } catch (Exception ex) {
            logger.error("Unexpected error", ex);
        }
        logger.trace("Ended Method");
        return null;
    }

    public PbfPagamentos2011 deletePbf(int id) {
        logger.trace("Start Method");
        Transaction tx = null;
        try {
            session = (Session) PersistenceUtil.getSession();
            PbfPagamentos2011 pbf = (PbfPagamentos2011) session.get(PbfPagamentos2011.class, new Integer(id));
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
            Query query = session.createQuery("delete from PBF_PAGAMENTOS_2011");
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
