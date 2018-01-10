package EstudandoJS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREFA")
    private Long id;

    private String titulo;

    private String descricao;

    private Status status = Status.PENDENTE;

    private int prioridade;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ID_LISTA_DE_TAREFAS")
    private ListaDeTarefas listaDeTarefas;

    enum Status {
        FEITO("feito"),
        PENDENTE("pendente"),
        CANCELADO("cancelado");

        private String status;


        Status(String status) {
            this.status = status;
        }
    }

    public Tarefa() {

    }

    public Tarefa(String titulo, String descricao, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    public ListaDeTarefas getListaDeTarefas() {
        return listaDeTarefas;
    }

    public Tarefa setListaDeTarefas(ListaDeTarefas listaDeTarefas) {
        this.listaDeTarefas = listaDeTarefas;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Tarefa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Tarefa setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Tarefa setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Tarefa setStatus(Status status) {
        this.status = status;
        return this;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public Tarefa setPrioridade(int prioridade) {
        this.prioridade = prioridade;
        return this;
    }
}
