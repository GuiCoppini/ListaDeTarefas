package EstudandoJS;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import EstudandoJS.repository.ListaDeTarefasRepository;
import EstudandoJS.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstudandoJsApplication {

    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    ListaDeTarefasRepository listaDeTarefasRepository;

}
