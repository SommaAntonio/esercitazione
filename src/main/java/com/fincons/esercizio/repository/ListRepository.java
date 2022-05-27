package com.fincons.esercizio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fincons.esercizio.entities.ListaTodo;

/*il repository e dove si metto le query piu complesse e con jparepository si fanno le pricipali CRUD*/
@Repository
public interface ListRepository extends JpaRepository<ListaTodo, Integer> {
	List<ListaTodo> findByTodoContainingIgnoreCase(String word);


}
