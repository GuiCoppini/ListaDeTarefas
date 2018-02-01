package EstudandoJS.repository;

import EstudandoJS.model.ListaDeTarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaDeTarefasRepository extends JpaRepository<ListaDeTarefas, Long> {
    public List<ListaDeTarefas> findAll();

    public ListaDeTarefas findOne(Long id);
}
