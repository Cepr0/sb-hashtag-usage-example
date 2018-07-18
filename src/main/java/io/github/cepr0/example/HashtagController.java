package io.github.cepr0.example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class HashtagController {
	
	private final QuestionRepo questionRepo;

	@GetMapping("/hashtags")
	List<QuestionRepo.Hashtag> getAll() {
		return questionRepo.getAllHashtags();
	}
}
