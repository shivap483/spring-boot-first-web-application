package com.spring.todoApp.Services;

import com.spring.todoApp.Models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoServices {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 0;

    static {
        todos.add(new Todo(1, "user1", "Learn Spring MVC", new Date(), false));
        todos.add(new Todo(2, "user1", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "user1", "Learn Hibernate", new Date(), false));
    }

    public List<Todo> retrieveTodos(String name) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equalsIgnoreCase(name)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) return todo;
        }
        return null;
    }

    public void updateTodo(Todo todo) {
        todos.remove(todo);
        todos.add(todo);
    }

    public void addTodo(String name, String description, Date targetDate, boolean isDone) {
        todos.add(new Todo(++todoCount, name, description, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
