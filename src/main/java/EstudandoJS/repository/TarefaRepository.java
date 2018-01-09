package EstudandoJS.repository;

import EstudandoJS.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    public List<Tarefa> findAll();

    public Tarefa findOne(Long id);
}
