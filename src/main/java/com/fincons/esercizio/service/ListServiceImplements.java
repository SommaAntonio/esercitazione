package com.fincons.esercizio.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fincons.esercizio.dto.ListTodoDto;
import com.fincons.esercizio.entities.ListaTodo;
import com.fincons.esercizio.repository.ListRepository;
import com.fincons.esercizio.utils.ListTodoutilis;

/*qui definisco quale sara l'effettivo servizio dove implemento i vari metodi messi nel interfaccia di service, 
 *anche qui mi porto i metodi del repository , 
 *definisco con transictional se voglio che siano si dila lettura o anche scrittura e se la  propagazione  e richiesta o non deve esserci*/
@Service

public class ListServiceImplements implements ListService {

	Logger logger = LoggerFactory.getLogger(ListServiceImplements.class);

	@Autowired
	private ListRepository listRepo;

	@Override
	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public ListaTodo findById(Integer id) {
		ListaTodo lista;

		lista = listRepo.findById(id).get();

		return lista;
	}

	@Override
	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public List<ListTodoDto> findAll() {
		List<ListTodoDto> listTododto;
		List<ListaTodo> lista = listRepo.findAll();
		listTododto = lista.stream().map(list -> ListTodoutilis.fromVoToDto(list)).collect(Collectors.toList());

		return listTododto;
	}

	/*
	 * il metodo di save e si trova al interno della JpaRepository insieme alle
	 * delete update e findByid/findAll
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Integer save(ListTodoDto dto) {
		// questo primo if serve a fare in modo che se non e indicata la data di
		// scadenza default sia dataInizio+10 mentre tutti gli altri fanno i controlli
		// sui dati e se tutto sara giusto
		// la conferma resta su true e salva, altrimenti si blocca dando errori
		boolean confirm = true;
		/*
		 * con questo if si dovrebbe controllare se la data di scadenza e vuota e nel
		 * caso riempirla con la funzione della data di scadenza ovvero la data di inzio
		 * + 10 giorni
		 * 
		 * if(dto.getScadenza()==null) {
		 * dto.setScadenza(defaulScadenza(dto.getDatainizio(),dto));
		 * System.out.println(dto.getScadenza());
		 * 
		 * }
		 */
		int result = dto.getDatainizio().compareTo(dto.getScadenza());
		if (result > 0) {
			logger.info("la data di scadena non puo essere prima del inizio in creazione");
			confirm = false;
		}
		if (!dto.getStato().equals("done") && !dto.getStato().equals("to_do") && !dto.getStato().equals("in_progres")) {
			logger.info("stato non corretto in creazione");
			System.out.println(dto.getStato());
			confirm = false;
		}
		if (confirm == true) {
			listRepo.save(ListTodoutilis.fromDtoToVo(dto));
		}else{
			logger.info("ci sono degli errori in creazione");
		}
		return null;
	}

	// la delete cerca un utente in base alla sua chiave primaria per poi eliminarlo

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Integer id) {
		try {
			listRepo.delete(listRepo.findById(id).get());
		} catch (Exception Variabledeclaratorld) {

			logger.info("l'id non e stato trovato in creazione");
		}
	}

	// la put dovrebbe caricare un nuovo utende dal body e cercare quale utente va
	// modificato in base al id, controllo che ci sia e come fatto nella save
	// controllo tutti i campi
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ListTodoDto update(Integer id, ListTodoDto dto) {
		ListaTodo list = null;
		try {
			list = listRepo.findById(id).get();
			list.setId(id);
		} catch (Exception variableDeclaratorls) {
			
			logger.info("l'id non e stato trovato in update");
		}
		boolean confirm = true;

		list.setTodo(dto.getTodo());
		if (!list.getStato().equals("done") | !list.getStato().equals("to_do")
				| !list.getStato().equals("in_progres")) {

		} else {
			System.out.println("stato non corretto");
			confirm = false;
		}

		int result = dto.getDatainizio().compareTo(dto.getScadenza());
		if (result > 0) {
			
			logger.info("la data di scadena non puo essere prima del inizio");
			confirm = false;

		} else {
			list.setDatainizio(dto.getDatainizio());
			list.setScadenza(dto.getScadenza());
		}

		if (confirm == true) {
			listRepo.saveAndFlush(list);
		}
		return null;
	}

	/*
	 * il metodo di defaultdate prende dalla data di inizio il giorno, aggiunge 10
	 * giorni e la rende la data di scadenza di default
	 */
	@Override
	public Date defaulScadenza(Date datainizio, ListTodoDto list) {
		int giornodate = datainizio.getDay() + 10;
		list.setScadenza(datainizio);
		ListaTodo listEntity = ListTodoutilis.fromDtoToVo(list);
		listRepo.save(listEntity);

		return null;
	}

	@Override
	public List<ListTodoDto> searchTodo(String word) {
		List<ListaTodo> lista = listRepo.findByTodoContainingIgnoreCase(word);
		List<ListTodoDto> listSearchDtos = ListTodoutilis.fromVosToDtos(lista);
		return listSearchDtos;
	}

}
