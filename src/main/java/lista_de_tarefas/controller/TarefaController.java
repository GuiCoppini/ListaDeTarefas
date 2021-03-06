package lista_de_tarefas.controller;

import java.util.List;
import javax.validation.Valid;

import lista_de_tarefas.model.AtribuiListaRequest;
import lista_de_tarefas.model.ChangeStatusRequest;
import lista_de_tarefas.model.Tarefa;
import lista_de_tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/tarefas/")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/")
    public List<Tarefa> todasTarefas() {
        return tarefaService.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa achaTarefa(@PathVariable("id") Long id) {
        return tarefaService.search(id);
    }

    @PostMapping("/new")
    public Tarefa insereTarefaAvulsa(@Valid @RequestBody Tarefa tarefa) {
        return tarefaService.criaTarefa(tarefa);
    }

    @DeleteMapping("/{idTarefa}/delete")
    public void deletaTarefa(@PathVariable("idTarefa") Long idTarefa) {
        tarefaService.deletaTarefa(idTarefa);
    }

    @PatchMapping("/{id}/status")
    public void settaStatusDaTarefa(
            @Valid @RequestBody ChangeStatusRequest request, @PathVariable("id") Long id) {
        tarefaService.settaStatus(request, id);
    }

    // Atribui a uma lista
    @PatchMapping("/{id}/lista")
    public void atribuiLista(
            @PathVariable("id") Long id, @Valid @RequestBody AtribuiListaRequest request) {
        tarefaService.settaLista(request, id);
    }

    @GetMapping("/semlista")
    public List<Tarefa> tarefasSemLista() {
        return tarefaService.todasSemLista();
    }
}
