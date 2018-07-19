package lista_de_tarefas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AtribuiListaRequest {
    @JsonProperty("id_lista_de_tarefas")
    Long idLista;

    public Long getIdLista() {
        return idLista;
    }
}
