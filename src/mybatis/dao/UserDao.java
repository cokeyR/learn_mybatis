package mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.po.Order;
import mybatis.po.User;
import mybatis.tool.Factory;

public class UserDao {
	
	public static void addUser() {
		User user=new User();
		user.setId(15);
	
		user.setUsername("王翔");
		
		SqlSession session=Factory.getFactory().openSession();
		session.insert("user.insertUser", user);
		//提交事务
		session.commit();
		session.close();
	}
	
	public static void selectUser() {
		SqlSession session = Factory.getFactory().openSession();
		//第一个参数为（要执行的sql的 namespace+"."+id;
		//第二个参数即为要传入的parameterType类型的参数
		//字段名和po类属性名相同可自动映射
		User user = session.selectOne("user.queryUserById", 1);
		System.out.println(user);
		
		List<Object> users = session.selectList("user.queryUserByName", "小明");
		
		for(Object e:users)
			System.out.println(e);
		session.close();
	}
	
	public static User selectUserAndOrders(String userid) {
		SqlSessionFactory sqlSessionFactory = Factory.getFactory();
		SqlSession session=sqlSessionFactory.openSession();
		User user = session.selectOne("user.selectUserAndOrders",userid);
		return user;
	}
	public static void main(String[] args) {
		User user=UserDao.selectUserAndOrders("1");
		System.out.println(user);
		for(Order order:user.getOrders())
			System.out.println(order);
	}
}
