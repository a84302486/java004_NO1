package _02_TasteHibernate;

import java.util.Collection;
import java.util.List;

public interface ITasteDAO {

	String insert(TasteBean tb);

	int update(TasteBean tb);

	boolean delete(TasteBean tb);

	boolean delete(String key);

	TasteBean findByPrimaryKey(String key);

	List<TasteBean> findAll();

}