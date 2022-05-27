package com.fincons.esercizio;

//importo la libreria per l'uso di spring DEFAULT
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//creo la classe di inalizzazione per la servlet DEFAULT
public class ServletInitialazer extends SpringBootServletInitializer {

	// ne creo il controllore DEFAULT
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootableWebApplication.class);
	}

}
