package monolito.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import monolito.model.Nota;

public interface NotesRepository extends JpaRepository<Nota, Long> {
    
}
