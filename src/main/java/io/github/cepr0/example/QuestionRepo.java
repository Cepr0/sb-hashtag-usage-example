package io.github.cepr0.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Set;

public interface QuestionRepo extends JpaRepository<Question, Long> {
	
	@RestResource(exported = false)
	@Query("select distinct h as hashtag from Question q join q.hashtags h")
	List<Hashtag> getAllHashtags();
	
	@RestResource(path = "by_hashtag", rel = "by_hashtag")
	@Query("select q from Question q join q.hashtags h where h = ?1")
	List<Question> getQuestionsByHashtag(@Param("hashtag") String hashtag);
	
	@RestResource(path = "by_hashtags", rel = "by_hashtags")
	@Query("select q from Question q join q.hashtags h where h in (?1)")
	List<Question> getQuestionsByHashtag(@Param("hashtags") Set<String> hashtags);
	
	interface Hashtag {
		String getHashtag();
	}
}
