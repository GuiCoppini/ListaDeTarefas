package EstudandoJS.service;

import java.util.List;

import EstudandoJS.model.AtribuiListaRequest;
import EstudandoJS.model.ChangeStatusRequest;
import EstudandoJS.model.ListaDeTarefas;
import EstudandoJS.model.Tarefa;
import EstudandoJS.repository.ListaDeTarefasRepository;
import EstudandoJS.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    ListaDeTarefasRepository listaDeTarefasRepository;

    @Override
    public void deletaTarefa(Long id) {
        Tarefa t = tarefaRepository.findOne(id);
        if(null == t) {
            throw new RuntimeException(String.format("A tarefa de ID: %s nao existe", id));
        }
        t.setListaDeTarefas(null);

        tarefaRepository.delete(id);
    }

    @Override
    public Tarefa criaTarefa(Tarefa tarefa) {
        tarefa.setListaDeTarefas(null);
        return tarefaRepository.save(tarefa);
    }

    @Override
    public void settaLista(AtribuiListaRequest request, Long id) {
        Tarefa existente = tarefaRepository.findOne(id);
        if(null == existente) {
            throw new RuntimeException(String.format("Tarefa de id=%s nao encontrada", id));
        }

        Long idLista = request.getIdLista();
        ListaDeTarefas lista = listaDeTarefasRepository.findOne(idLista);
        if(null == lista) {
            throw new RuntimeException(String.format("Lista de Tarefas de id=%s nao encontrada", idLista));
        }

        existente.setListaDeTarefas(lista);

        tarefaRepository.save(existente);
    }

    @Override
    public Tarefa search(Long id) {
        return tarefaRepository.findOne(id);
    }

    @Override
    public void settaStatus(ChangeStatusRequest request, Long id) {
        Tarefa existente = tarefaRepository.findOne(id);

        if(null == existente) {
            throw new RuntimeException(String.format("Tarefa de id=%s nao encontrada", id));
        }

        existente.setStatus(Tarefa.Status.fromString(request.getStatus()));

        tarefaRepository.save(existente);
    }

    @Override
    public List<Tarefa> todasSemLista() {
        return tarefaRepository.findAllWithoutListaDeTarefas();
    }

    @Override
    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }
}
