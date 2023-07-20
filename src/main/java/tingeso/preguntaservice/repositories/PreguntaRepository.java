package tingeso.preguntaservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tingeso.preguntaservice.entities.Pregunta;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
    List<Pregunta> findByDificultad(String dificultad);

    Integer deleteByDificultad(String dificultad);
}
