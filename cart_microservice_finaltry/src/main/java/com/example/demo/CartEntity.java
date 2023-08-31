package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer userId;
    // Other fields, getters, setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public CartEntity(Long id, Integer userId) {
		super();
		this.id = id;
		this.userId = userId;
	}
	public CartEntity() {
		super();
	}
	@Override
	public String toString() {
		return "CartEntity [id=" + id + ", userId=" + userId + "]";
	}
    
    
}
