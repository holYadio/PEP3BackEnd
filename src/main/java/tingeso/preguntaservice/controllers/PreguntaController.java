package tingeso.preguntaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tingeso.preguntaservice.entities.Pregunta;
import tingeso.preguntaservice.services.PreguntaService;

import java.util.List;

@RestController
@RequestMapping("/pregunta")
public class PreguntaController {
    @Autowired
    PreguntaService service;

    @GetMapping
    public ResponseEntity<List<Pregunta>> getAll(){
        List<Pregunta> preguntas = service.getAllPreguntas();
        if(preguntas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(preguntas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregunta> getById(@PathVariable(value = "id") int id){
        Pregunta pregunta = service.getPreguntaById(id);
        if(pregunta == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(pregunta);
    }
    @GetMapping("/test/{dificultad}")
    public ResponseEntity<List<Pregunta>> getTest(@PathVariable(value = "dificultad") String dificultad){
        List<Pregunta> preguntas = service.getTest(dificultad);
        if(preguntas == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(preguntas);
    }

    @PostMapping()
    public ResponseEntity<Pregunta> createPregunta(@RequestBody Pregunta pregunta){
        Pregunta newPregunta = service.createPregunta(pregunta);
        if(newPregunta == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(newPregunta);
    }
    @DeleteMapping("/dificultad/{dificultad}")
    public ResponseEntity<Integer> deletePreguntaByDificultad(@PathVariable(value = "dificultad") String dificultad){
        Integer cantidad = service.deleteByDificultad(dificultad);
        if(cantidad == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cantidad);
    }
}
