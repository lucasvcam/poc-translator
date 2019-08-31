package com.lucas.poctranslator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.poctranslator.model.Language;
import com.lucas.poctranslator.repository.LanguageRepository;

@RestController
@RequestMapping("/api/v1")
public class LanguageController {

	@Autowired
	private LanguageRepository languageRepository;

	@GetMapping("/languages")
	public List<Language> findLanguages() {
		return languageRepository.findByOrderByDescriptionAsc();
	}

}
