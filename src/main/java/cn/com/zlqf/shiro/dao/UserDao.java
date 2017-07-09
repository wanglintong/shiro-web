package cn.com.zlqf.shiro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.com.zlqf.shiro.entity.User;


public interface UserDao extends JpaRepository<User, String>{
	
	@Query(value="select * from t_user where username=?1",nativeQuery=true)
	User findByUsername(String username);

}
