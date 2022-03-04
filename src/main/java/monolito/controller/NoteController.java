package monolito.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import monolito.model.Nota;
import monolito.model.Temperatura;
import monolito.service.ITimeService;
import monolito.domain.NotesRepository;
import monolito.exception.NotaNotFoundException;


@RestController
public class NoteController {
    Logger logger = LoggerFactory.getLogger(NoteController.class);
    
    private final NotesRepository repository;

    NoteController(NotesRepository repository) {
    this.repository = repository;
  }


    @Autowired
    private ITimeService timeService;

    @PostMapping("/notes")
    public Nota crearNota(@RequestBody Nota nota){
        logger.info("he entrado por POST/notes");
        
        //Se añade Temperatura de Madrid
        Temperatura temp = timeService.getByCity("Madrid");
        Nota _nota = repository.save(new Nota(nota.getText(), temp.getTemp()));

        return _nota;
    }

    //Todas las notas
    @GetMapping("/notes")
    List<Nota> all() {
        logger.info("he entrado por GET/notes");
        return repository.findAll();
    }

    //Una nota específica
    @GetMapping("/notes/{id}")
    Nota recuperarNota(@PathVariable Long id) {
        logger.info("he entrado por GET/notes/{id}");
    
        return repository.findById(id).orElseThrow(() -> new NotaNotFoundException(id));
    }

    @PutMapping("/notes/{id}")
    Nota actualizarNota(@RequestBody Nota crearNota, @PathVariable Long id) {
        logger.info("he entrado por PUT/notes/{id}");
        
        return repository.findById(id)
        .map(nota -> {
            nota.setText(crearNota.getText());
            return repository.save(nota);
        })
        .orElseThrow(() -> new NotaNotFoundException(id));
    }

    //Borrar todas las notas
    @DeleteMapping("/notes")
    void borrarNotas() {
        logger.info("he entrado por DELETE/notes");
        repository.deleteAll();
    }

    //Borrar una específica
    @DeleteMapping("/notes/{id}")
    void borrarNota(@PathVariable Long id) {
        logger.info("he entrado por DELETE/notes/{id}");
        repository.deleteById(id);
    }

}
