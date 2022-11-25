package com.indusnet.reposetry;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.indusnet.entity.User_Details;

@Repository
public interface UserDetailsRepository extends JpaRepository<User_Details, Integer> {

	//public Optional<UserMember>  findByUser_Id(Integer user_Id);
	
	@Query("select u from User_Details u JOIN u.user a where a.user_id=:id")
	public User_Details getUserDetailsById(@Param("id") Integer id);
	

}
