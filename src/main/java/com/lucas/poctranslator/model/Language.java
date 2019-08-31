package com.lucas.poctranslator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private long id;
	
	@Column (name= "description")
	private String description;
	
    public Language() {
    	  
    }
    
    public Language(long id, String description) {
         this.id = id;
         this.description = description;
        
    }
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return description;
	}

	public void setName(String description) {
		this.description = description;
	}

}
