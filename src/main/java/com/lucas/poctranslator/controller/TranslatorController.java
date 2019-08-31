package com.lucas.poctranslator.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.poctranslator.exception.ResourceNotFoundException;
import com.lucas.poctranslator.model.Translator;
import com.lucas.poctranslator.repository.TranslatorRepository;

@RestController
@RequestMapping("/api/v1")
public class TranslatorController {

	@Autowired
	private TranslatorRepository translatorRepository;

	@GetMapping("/translators")
	public Page<Translator> findPage(
			@RequestParam(value = "page", defaultValue = "0")Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "Id") String[] orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return translatorRepository.findAll(pageRequest);
	}

	@PostMapping("/translators")
	public Translator createTranslator(@Valid @RequestBody Translator translator) {
		return translatorRepository.save(translator);
	}

	@PutMapping("/translators/{id}")
	public ResponseEntity<Translator> updateTranslator(@PathVariable(value = "id") Long translatorId,
			@Valid @RequestBody Translator translatorDetails) throws ResourceNotFoundException {
		Translator translator = translatorRepository.findById(translatorId).orElseThrow(
				() -> new ResourceNotFoundException("Translator not found for this id :: " + translatorId));

		translator.setId(translatorDetails.getId());
		translator.setName(translatorDetails.getName());
		translator.setEmail(translatorDetails.getEmail());
		translator.setSourceLanguage(translatorDetails.getSourceLanguage());
		translator.setTargetLanguage(translatorDetails.getTargetLanguage());

		final Translator updatedTranslator = translatorRepository.save(translator);
		return ResponseEntity.ok(updatedTranslator);
	}

	@DeleteMapping("/translators/{id}")
	public Map<String, Boolean> deleteTranslator(@PathVariable(value = "id") Long translatorId)
			throws ResourceNotFoundException {
		Translator translator = translatorRepository.findById(translatorId).orElseThrow(
				() -> new ResourceNotFoundException("Translator not found for this id :: " + translatorId));

		translatorRepository.delete(translator);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
