package mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.po.Item;
import mybatis.tool.Factory;

public class ItemDao {
	
	private static Item selectItemById(String id) {
		SqlSessionFactory factory = Factory.getFactory();
		SqlSession session = factory.openSession();
		Item item = session.selectOne("Item.selectItem", id);
		return item;
	}
	
	public static void main(String[] args) {
		Item item = ItemDao.selectItemById("1");
		System.out.println(item);
	}
}
