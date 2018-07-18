package io.github.cepr0.example;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 32)
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public User() {
	}
}
