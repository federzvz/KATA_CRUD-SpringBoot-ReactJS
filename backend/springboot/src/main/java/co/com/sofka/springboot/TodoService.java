package co.com.sofka.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> list(){
        return repository.findAll();
    }

    public Todo save(@RequestBody Todo todo){
        return repository.save(todo);
    }

    public Todo update(@RequestBody Todo todo){
        try{
            return repository.save(todo);
        }catch (Exception e){
            throw new RuntimeException("No existe el ID para actualizar.");
        }
    }

    public void delete(@PathVariable("id") long id){
        repository.delete(this.get(id));
    }

    public Todo get(@PathVariable("id") long id){
        return repository.findById(id).orElseThrow();
    }
}
