package co.com.sofka.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return repository.findAll();
    }

    @PostMapping(value = "api/todo")
    public Todo save(@RequestBody Todo todo){
        return repository.save(todo);
    }

    @PutMapping(value = "api/todo")
    public Todo update(@RequestBody Todo todo){
        try{
            return repository.save(todo);
        }catch (Exception e){
            throw new RuntimeException("No existe el ID para actualizar.");
        }





    }

    @DeleteMapping(value = "api/{id}/todo")
    public void delete(@PathVariable("id") long id){
        repository.delete(this.get(id));
    }

    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") long id){
        return repository.findById(id).orElseThrow();
    }
}
