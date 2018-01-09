package EstudandoJS.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ListaDeTarefas {

    @OneToMany(mappedBy = "listaDeTarefas")
    private Set<Tarefa> tarefas = new HashSet<>();

    @NotNull
    @NotBlank
    private String titulo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LISTA_DE_TAREFAS")
    private Long id;

    public boolean add(Tarefa t) {
        return tarefas.add(t);
    }

    public boolean remove(Tarefa t) {
        return tarefas.remove(t);
    }

    public int tamanho() {
        return tarefas.size();
    }

    public ListaDeTarefas() {

    }

    public Set<Tarefa> getTarefas() {
        return tarefas;
    }

    public ListaDeTarefas setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ListaDeTarefas setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public ListaDeTarefas setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }
}
