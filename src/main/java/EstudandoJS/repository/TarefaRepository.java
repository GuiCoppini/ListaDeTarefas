package EstudandoJS.repository;

import EstudandoJS.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findAll();

    Tarefa findOne(Long id);

    @Query("SELECT t from Tarefa t WHERE t.listaDeTarefas = null")
    List<Tarefa> findAllWithoutListaDeTarefas();
}
