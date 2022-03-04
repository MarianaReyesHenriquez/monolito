package monolito.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import monolito.model.Identificador;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;



@RestController
@RequestMapping("invoices")
public class MonolitoInvoicesController {
	Logger logger = LoggerFactory.getLogger(MonolitoInvoicesController.class);


    @GetMapping("/{id}")
    public Identificador id(@PathVariable("id") Long id) {
        logger.info("he entrado por {id}");

        return new Identificador(id);
    }

	@GetMapping("/getAll")
	public ObjectNode hola() {
		logger.info("he entrado por getAll");

		ObjectNode mainNode = JsonNodeFactory.instance.objectNode();
		mainNode.put("result", "hello");

		return mainNode;
	}

}