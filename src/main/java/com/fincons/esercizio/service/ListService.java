package com.fincons.esercizio.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import com.fincons.esercizio.dto.ListTodoDto;
import com.fincons.esercizio.entities.ListaTodo;

public interface ListService {
	ListaTodo findById(Integer id);

	// CRUD
	List<ListTodoDto> findAll();

	Integer save(ListTodoDto dto);

	void delete(Integer id);

	ListTodoDto update(Integer id, ListTodoDto dto);

	// scadenza
	Date defaulScadenza(Date datainizio, ListTodoDto list);
	
	//search
	List<ListTodoDto> searchTodo(String word);

}
