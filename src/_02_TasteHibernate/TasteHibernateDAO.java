package _02_TasteHibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import _00_Util.Hibernate.HibernateUtil;



public class TasteHibernateDAO implements ITasteDAO {

	@Override
	public String insert(TasteBean tb) {
		SessionFactory  factory = 
				HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(tb);
			tx.commit();
			return null;
		} catch(Exception ex){
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return "失敗 新增" + tb.getTasteId();
	}

	@Override
	public int update(TasteBean tb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(TasteBean tb) {
		SessionFactory  factory = 
				HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(tb);
			tx.commit();
			return true;
		} catch(Exception ex){
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean delete(String key) {
		TasteBean tb = new TasteBean();
		tb.setTasteId(key);
		SessionFactory  factory = 
				HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(tb);
			tx.commit();
			return true;
		} catch(Exception ex){
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public TasteBean findByPrimaryKey(String key) {
		TasteBean  tb = null;
		SessionFactory  factory = 
				HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tb = session.get(TasteBean.class, key);
			tx.commit();
		} catch(Exception ex){
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return tb;
	}

	@Override
	public List<TasteBean> findAll() {
		List<TasteBean>  list = null;
		SessionFactory  factory = 
				HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<TasteBean>  query = session.createQuery("from TasteBean");
			list = query.getResultList();
			tx.commit();
		} catch(Exception ex){
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return list;
	}

}
