package io.github.cepr0.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Set;

public interface UserRepo extends JpaRepository<User, Long> {
	
	@RestResource(path = "by_hashtags", rel = "by_hashtags")
	@Query("select distinct u from Question q join q.user u join q.hashtags h where h in (?1)")
	List<User> getUsersByHashtags(@Param("hashtags") Set<String> hashtags);
}
