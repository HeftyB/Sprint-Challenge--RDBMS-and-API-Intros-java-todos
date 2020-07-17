package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service//(value = "todoService")
public class TodoServiceImp implements TodosService
{
    @Autowired
    TodoRepository todoRepository;

    @Override
    public void markComplete(long todoid)
    {
        Todo t = todoRepository.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo id " + todoid + " Not Found!"));
        t.setCompleted(true);
    }
}
