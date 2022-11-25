package com.indusnet.reposetry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indusnet.entity.ShortUrlResponce;

@Repository
public interface ShortUrlRepository extends JpaRepository<ShortUrlResponce, Integer> {

	@Query("select s.status from ShortUrlResponce s join s.user u where u.user_id=:id")
	public List<String> getStatus(@Param("id") Integer id);
	
	@Query("select s from ShortUrlResponce s join s.user u where u.user_id=:id")
	public ShortUrlResponce getShortUrlResponce(@Param("id") Integer id);
		
	
}
