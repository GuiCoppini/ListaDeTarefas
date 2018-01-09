package EstudandoJS.controller;

import EstudandoJS.model.ListaDeTarefas;
import EstudandoJS.model.Tarefa;
import EstudandoJS.repository.ListaDeTarefasRepository;
import EstudandoJS.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ListaDeTarefasRepository listaDeTarefasRepository;

    @PostMapping("listadetarefas/{id}/add")
    public Tarefa insereTarefa(@PathVariable("id") Long idLista,
                                @Valid @RequestBody Tarefa tarefa) {

        ListaDeTarefas lista = listaDeTarefasRepository.findOne(idLista);
        lista.add(tarefa);
        tarefa.setListaDeTarefas(lista);
        return tarefaRepository.save(tarefa);
    }
}
