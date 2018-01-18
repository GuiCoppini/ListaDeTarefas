package EstudandoJS.service;

import EstudandoJS.model.AtribuiListaRequest;
import EstudandoJS.model.ChangeStatusRequest;
import EstudandoJS.model.Tarefa;

import java.util.List;

public interface TarefaService {

    void deletaTarefa(Long id);

    Tarefa criaTarefa(Tarefa tarefa);

    void settaLista(AtribuiListaRequest request, Long id);

    Tarefa search(Long id);

    void settaStatus(ChangeStatusRequest request, Long id);

    List<Tarefa> todasSemLista();

    List<Tarefa> findAll();
}
