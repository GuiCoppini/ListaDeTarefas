package EstudandoJS.controller;

import EstudandoJS.model.ListaDeTarefas;
import EstudandoJS.model.Tarefa;
import EstudandoJS.repository.ListaDeTarefasRepository;
import EstudandoJS.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TarefaController {

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

    @PostMapping("listadetarefas/{id}/new")
    public Tarefa insereTarefa(@PathVariable("id") Long idLista,
                                @Valid @RequestBody Tarefa tarefa) {

        ListaDeTarefas lista = listaDeTarefasRepository.findOne(idLista);
        lista.add(tarefa);
        tarefa.setListaDeTarefas(lista);
        return tarefaRepository.save(tarefa);
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

    // TODO marcar status da tarefa
}
