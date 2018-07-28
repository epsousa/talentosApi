package com.example.pastel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pastel.models.Pastel;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pastel-hml")
public class PastelControllerDev {

	private static List<Pastel> pasteis = new ArrayList<>();
	private static Long id = 0L;

	@GetMapping
	public List<Pastel> returnHelloWorld() {
		return pasteis;
	}

	@GetMapping("{id}")
	public Pastel returnHelloWorld(@PathVariable("id") Long id) {

		Pastel past = new Pastel();

		for (Pastel pas : pasteis) {
			if (pas.getId() == id) {
				past = pas;
			}
		}

		return past;
	}

	@PostMapping
	public Pastel addPastel(@RequestBody Pastel pastel) {
		id++;
		pastel.setId(id);
		pasteis.add(pastel);
		return pastel;
	}

	@PutMapping
	public Pastel updatePastel(@RequestBody Pastel pastel) throws Exception {

		List<Pastel> pasteisAux = new ArrayList<>();		
		
		if (pastel.getId() <= 0)
			throw new Exception("Opa! Id inv�lido");

		for (Pastel past : pasteis) {
			if (past.getId() == pastel.getId()) {
				pasteisAux.add(pastel);
			} else {
				pasteisAux.add(past);
			}
		}
		
		pasteis = pasteisAux;

		return pastel;
	}

	@DeleteMapping("/{id}")
	public Pastel deletePastel(@PathVariable("id") Long id) throws Exception {

		List<Pastel> pasteisAux = new ArrayList<>();
		Pastel pastelAux = new Pastel();

		if (id <= 0)
			throw new Exception("Opa! Id inv�lido");

		for (Pastel past : pasteis) {
			if (past.getId() != id) {
				pasteisAux.add(past);
			} else {
				pastelAux = past;
			}
		}

		pasteis = pasteisAux;
		return pastelAux;
	}

}
