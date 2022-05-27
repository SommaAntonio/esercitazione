package com.fincons.esercizio.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.fincons.esercizio.dto.ListTodoDto;
import com.fincons.esercizio.entities.ListaTodo;

public class ListTodoutilis {

	public static ListaTodo fromDtoToVo(ListTodoDto listTodoDto) {
		ListaTodo listTodo = new ListaTodo();
		listTodo.setId(listTodoDto.getId());
		listTodo.setTodo(listTodoDto.getTodo());
		listTodo.setStato(listTodoDto.getStato());
		listTodo.setDatainizio(listTodoDto.getDatainizio());
		listTodo.setScadenza(listTodoDto.getScadenza());
		return listTodo;
	}

	public static ListTodoDto fromVoToDto(ListaTodo listTodo) {
		ListTodoDto listTodoDto = new ListTodoDto();
		listTodoDto.setId(listTodo.getId());
		listTodoDto.setTodo(listTodo.getTodo());
		listTodoDto.setStato(listTodo.getStato());
		listTodoDto.setDatainizio(listTodo.getDatainizio());
		listTodoDto.setScadenza(listTodo.getScadenza());
		return listTodoDto;
	}
	public static List<ListTodoDto> fromVosToDtos(List <ListaTodo> listTodos){
		return listTodos.stream().map(item->fromVoToDto(item)).collect(Collectors.toList());
	}
}
