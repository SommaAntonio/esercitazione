package com.fincons.esercizio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fincons.esercizio.dto.ListTodoDto;
import com.fincons.esercizio.entities.ListaTodo;
import com.fincons.esercizio.service.ListService;

//definisco il controller
@RestController

//il mapping sara su localhos/lista
@RequestMapping("/lista")
public class ListController {

	// autowired permette di fare i getter e setter injection del service
	@Autowired
	private ListService listService;

	/*
	 * getmapping come postmapping, delete mapping,post mapping, put mapping
	 * permette di segnalare a postman e dopo anche per il collegamento del frontend
	 * dando poi il come si trovano, tramite id nel url o con la richiesta di body o
	 * paramentri, trammite il findById trovo record specifici grazie alla chiave
	 * privata
	 */@GetMapping("/{id}")
	public ListaTodo getListById(@PathVariable("id") Integer id) {
		ListaTodo lista = listService.findById(id);
		return lista;
	}

	@GetMapping("/listTodo")
	public List<ListTodoDto> getAll() {
		List<ListTodoDto> all = listService.findAll();
		return all;
	}
	
	@GetMapping("/search")
	public List<ListTodoDto> search(@RequestParam("word") String word) {
		//grazie a questa funziona si cerca una parola al interno dei todo dell' database 
		List<ListTodoDto> all = listService.searchTodo(word);
		return all;
	}

	@PostMapping
	public Integer create(@RequestBody ListTodoDto list) {
		Integer pk = listService.save(list);
		return pk;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		listService.delete(id);
	}

	@PutMapping("/{id}")
	public ListTodoDto update(@PathVariable("id") Integer id, @RequestBody ListTodoDto listAggiornata) {
		return listService.update(id, listAggiornata);
	}

}
