package EstudandoJS.repository;

import EstudandoJS.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findAll();

    Tarefa findOne(Long id);

//    @Transactional
//    @Modifying
//    @Query("DELETE FROM Tarefa where id_lista_de_tarefas = :idLista AND id_tarefa = :idTarefa")
//    void deleteByLista(@Param(value = "idLista") Long idLista, @Param(value = "idTarefa") Long idTarefa);
}
