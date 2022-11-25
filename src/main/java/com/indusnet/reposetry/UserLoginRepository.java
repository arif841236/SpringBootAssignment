package com.indusnet.reposetry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indusnet.entity.UserLoginDetails;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginDetails, Integer> {

	@Query("select e from UserLoginDetails e join e.user u where u.user_id=:id")
	UserLoginDetails findByUser_Id(@Param("id") Integer id);
	
	UserLoginDetails findByToken(String token);
	
	
}
