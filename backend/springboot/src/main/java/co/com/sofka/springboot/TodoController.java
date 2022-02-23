package co.com.sofka.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @Autowired
    private TodoService service;

    public Iterable<Todo> list(){
        return service.list();
    }

    public Todo save(Todo todo){
        return service.save(todo);
    }

    public void delete(long id){
        service.delete(id);
    }

    public Todo get(long id){
        return service.get(id);
    }
}
