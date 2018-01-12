package EstudandoJS.controller;

import EstudandoJS.model.AtribuiListaRequest;
import EstudandoJS.model.ChangeStatusRequest;
import EstudandoJS.model.ListaDeTarefas;
import EstudandoJS.model.Tarefa;
import EstudandoJS.repository.ListaDeTarefasRepository;
import EstudandoJS.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TarefaController {

    // TODO COLOCAR METODOS EM SERVICES

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ListaDeTarefasRepository listaDeTarefasRepository;

    @GetMapping("tarefas/")
    public List<Tarefa> todasTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("tarefas/{id}")
    public Tarefa achaTarefa(@PathVariable("id") Long id) {
        return tarefaRepository.findOne(id);
    }

    @PostMapping("tarefas/new")
    public Tarefa insereTarefaAvulsa(@Valid @RequestBody Tarefa tarefa) {
        tarefa.setListaDeTarefas(null);
        return tarefaRepository.save(tarefa);
    }


    @DeleteMapping("tarefas/{idTarefa}/delete")
    public void deletaTarefa(@PathVariable("idTarefa") Long idTarefa) {
        Tarefa t = tarefaRepository.findOne(idTarefa);
        if(null == t) {
            throw new RuntimeException(String.format("A tarefa de ID: %s nao existe", idTarefa));
        }
        t.setListaDeTarefas(null);

        tarefaRepository.delete(idTarefa);

    }

    @PatchMapping("tarefas/{id}/status")
    public void settaStatusDaTarefa(@Valid @RequestBody ChangeStatusRequest request,
                                    @PathVariable("id") Long id) {
        Tarefa existente = tarefaRepository.findOne(id);

        if(null == existente)
            throw new RuntimeException(String.format("Tarefa de id=%s nao encontrada", id));

        existente.setStatus(Tarefa.Status.fromString(request.getStatus()));

        tarefaRepository.save(existente);
    }

    // Atribui a uma lista
    @PatchMapping("tarefas/{id}/lista")
    public void atribuiLista(@PathVariable("id") Long id,
                                       @Valid @RequestBody AtribuiListaRequest request) {
        Tarefa existente = tarefaRepository.findOne(id);
        if(null == existente)
            throw new RuntimeException(String.format("Tarefa de id=%s nao encontrada", id));

        Long idLista = request.getIdLista();
        ListaDeTarefas lista = listaDeTarefasRepository.findOne(idLista);
        if(null == lista)
            throw new RuntimeException(String.format("Lista de Tarefas de id=%s nao encontrada", idLista));

        existente.setListaDeTarefas(lista);

        tarefaRepository.save(existente);
    }
}
