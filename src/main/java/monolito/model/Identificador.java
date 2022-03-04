package monolito.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Identificador {

  final Long id;

    public Identificador(Long id){
      this.id = id;
    }

    @JsonProperty("result")
    public Long getId() {
		return id;
	}
}
