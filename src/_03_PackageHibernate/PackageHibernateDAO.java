package _03_PackageHibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import _00_Util.Hibernate.HibernateUtil;



public class PackageHibernateDAO implements ITasteDAO {

	@Override
	public String insert(PackageBean tb) {
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
		return "失敗 新增" + tb.getPackageId();
	}

	@Override
	public int update(PackageBean tb) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(PackageBean tb) {
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
		PackageBean tb = new PackageBean();
		tb.setPackageId(key);
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
	public PackageBean findByPrimaryKey(String key) {
		PackageBean  tb = null;
		SessionFactory  factory = 
				HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			tb = session.get(PackageBean.class, key);
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
	public List<PackageBean> findAll() {
		List<PackageBean>  list = null;
		SessionFactory  factory = 
				HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			TypedQuery<PackageBean>  query = session.createQuery("from PackageBean");
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
