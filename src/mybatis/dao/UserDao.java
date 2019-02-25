package mybatis.dao;

import org.apache.ibatis.session.SqlSession;

import mybaits.po.User;
import mybatis.tool.Factory;

public class UserDao {
	
	public static void main(String[] args) {
		SqlSession session = Factory.getFactory().openSession();
		//第一个参数为（要执行的sql的 namespace+"."+id;
		//第二个参数即为要传入的parameterType类型的参数
		//字段名和po类属性名相同可自动映射
		User user = session.selectOne("user.queryUserById", 1);
		System.out.println(user);
		
		session.close();
	}
}
