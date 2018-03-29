package EstudandoJS;

import EstudandoJS.repository.ListaDeTarefasRepository;
import EstudandoJS.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstudandoJsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EstudandoJsApplication.class, args);
    }
}
