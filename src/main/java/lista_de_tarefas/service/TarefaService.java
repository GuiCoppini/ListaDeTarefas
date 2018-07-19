package lista_de_tarefas.service;

import lista_de_tarefas.model.AtribuiListaRequest;
import lista_de_tarefas.model.ChangeStatusRequest;
import lista_de_tarefas.model.Tarefa;

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
