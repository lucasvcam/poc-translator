package com.lucas.poctranslator.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.poctranslator.model.Translator;

@Repository
public interface TranslatorRepository extends JpaRepository<Translator, Long>{
	public Page<Translator> findAllByOrderByIdAsc(PageRequest pageRequest);
	
}
