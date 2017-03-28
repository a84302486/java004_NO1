package _03_PackageHibernate;

import java.util.Collection;
import java.util.List;

public interface ITasteDAO {

	String insert(PackageBean tb);

	int update(PackageBean tb);

	boolean delete(PackageBean tb);

	boolean delete(String key);

	PackageBean findByPrimaryKey(String key);

	List<PackageBean> findAll();

}