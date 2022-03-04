package monolito.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import monolito.model.Hora;


@RestController
@RequestMapping("system")
public class MonolitoSystemController {
    Logger logger = LoggerFactory.getLogger(MonolitoSystemController.class);

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	//Para la primera peticion
	String anteriorString = "";
	//Para el resto de peticiones
	LocalDateTime  anteriorTime;
	LocalDateTime  aux;
    
    @GetMapping("/time")
	public Hora hora() {
		logger.info("he entrado por time");

		LocalDateTime  actualTime = LocalDateTime .now();
	
		anteriorTime = aux;
		aux = actualTime;
		
		if (anteriorTime != null){
			anteriorString = anteriorTime.format(dtf);
		}

		return new Hora(actualTime.format(dtf), anteriorString);
	}

	@GetMapping("/greeting")
	public ObjectNode saludo() {
		logger.info("he entrado por greeting");

		ObjectNode mainNode = JsonNodeFactory.instance.objectNode();
		mainNode.put("greeting", "hello");
		
		return mainNode;
	}
}
