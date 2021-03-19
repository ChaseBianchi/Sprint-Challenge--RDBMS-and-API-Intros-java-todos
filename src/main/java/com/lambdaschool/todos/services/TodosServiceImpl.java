package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service(value = "todoService")
public class TodosServiceImpl implements TodosService{

    @Autowired
    private TodosRepository todosRepository;

    @Transactional
    @Override
    public void markComplete(long todoid) {
        Todos updatedTodo = todosRepository.findById(todoid)
                .orElseThrow(()->new EntityNotFoundException("Todo id "+todoid+ " not found."));
        updatedTodo.setCompleted(true);
    }
}
