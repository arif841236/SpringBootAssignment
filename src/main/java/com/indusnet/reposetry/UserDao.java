package com.indusnet.reposetry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indusnet.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
	
	@Query("select u from User u where u.user_id=:id")
	public User getUserById(@Param("id") Integer id);
	
	@Query("select u.username from User u where u.user_id=:id")
	public String getUsernameById(@Param("id") Integer id);
	
	//@Query("select u from User u where u.username=:username and u.password=:password")
	public User findByUsernameAndPassword(String username,String password);
	
	
}
