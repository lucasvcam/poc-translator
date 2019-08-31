package com.lucas.poctranslator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "translators")
public class Translator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="id")
	private long id;
	
	@Column (name= "name")
	private String name;
	
	@Column (name="email")
	private String email;
	
	@Column (name = "source_language")
	private String sourceLanguage;
	
	@Column (name = "target_language")
	private String targetLanguage;
	
    public Translator() {
    	  
    }
    
    public Translator(long id, String name, String email, String sourceLanguage, String targetLanguage) {
         this.id = id;
         this.name = name;
         this.email = email;
         this.sourceLanguage = sourceLanguage;
         this.targetLanguage = targetLanguage;
    }
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}
	
	
}
