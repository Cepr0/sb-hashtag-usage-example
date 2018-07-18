package io.github.cepr0.example;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashtagableTest {
	
	@Test
	public void extractHashtags() {
		Hashtagable str1 = () -> "This is a string with #hashtag.";
		Hashtagable str2 = () -> "This is a #string with #several hashtags and #punctuation signs. #tag1, #tag2. #tag3: #tag4; #tag5!";
		
		assertThat(str1.extractHashtags()).hasSize(1);
		assertThat(str2.extractHashtags()).hasSize(8);
	}
}