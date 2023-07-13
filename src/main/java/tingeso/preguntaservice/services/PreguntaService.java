package tingeso.preguntaservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tingeso.preguntaservice.entities.Pregunta;
import tingeso.preguntaservice.repositories.PreguntaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PreguntaService {
    @Autowired
    PreguntaRepository repository;
    public List<Pregunta> getAllPreguntas() {
        return repository.findAll();
    }

    public Pregunta getPreguntaById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Pregunta createPregunta(Pregunta pregunta) {
        return repository.save(pregunta);
    }

    public List<Pregunta> getPreguntaByDificultad(String dificultad) {
        return repository.findByDificultad(dificultad);
    }

    public Integer cantidadPreguntasPorDificultad(String dificultad) {
        return repository.findByDificultad(dificultad).size();
    }
    public List<Pregunta> getTest(String dificultad) {
        List<Pregunta> preguntas = getPreguntaByDificultad(dificultad);
        List<Pregunta> test = new ArrayList<Pregunta>();
        List<Integer> numeros = new ArrayList<Integer>();
        int cantPreguntas = preguntas.size();
        if (cantPreguntas<3){
            return preguntas;
        }
        Random rand = new Random();
        for(int i=0;i<4;i++){
            int n = rand.nextInt(cantPreguntas-1+1)+1;
            while(numeros.contains(n)){
                n = rand.nextInt(cantPreguntas-1+1)+1;
            }
            numeros.add(n);
            test.add(preguntas.get(n-1));
        }
        return test;
    }
}
