package EstudandoJS.controller;

import java.util.List;
import javax.validation.Valid;

import EstudandoJS.model.ListaDeTarefas;
import EstudandoJS.model.Tarefa;
import EstudandoJS.repository.ListaDeTarefasRepository;
import EstudandoJS.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/listadetarefas/*")
public class ListaDeTarefasController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ListaDeTarefasRepository listaDeTarefasRepository;

    @GetMapping("/")
    public List<ListaDeTarefas> todasAsListas() {
        return listaDeTarefasRepository.findAll();
    }

    @PostMapping("/new")
    public ListaDeTarefas insereLista(@Valid @RequestBody ListaDeTarefas listaDeTarefas) {
        return listaDeTarefasRepository.save(listaDeTarefas);
    }

    @GetMapping("/{id}")
    public ListaDeTarefas buscaPorId(@PathVariable("id") Long id) {
        return listaDeTarefasRepository.findOne(id);
    }

    @PostMapping("/{id}/new")
    public Tarefa insereTarefa(
            @PathVariable("id") Long idLista, @Valid @RequestBody Tarefa tarefa) {

        ListaDeTarefas lista = listaDeTarefasRepository.findOne(idLista);
        if(lista == null) {
            throw new RuntimeException("Lista nao encontrada!");
        }
        tarefa.setListaDeTarefas(lista);
        return tarefaRepository.save(tarefa);
    }
}
