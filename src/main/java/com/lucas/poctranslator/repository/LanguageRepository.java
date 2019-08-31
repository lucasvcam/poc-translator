package com.lucas.poctranslator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.poctranslator.model.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long>{
	public List<Language> findByOrderByDescriptionAsc();
}
