package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer>
{
    @Query(value = "SELECT t.todoid, t.description, t.completed, u.username FROM todo t, users u WHERE t.userid = u" +
            ".userid", nativeQuery = true)
    List<Object[]> todosWithUser();

    @Query(value = "SELECT * FROM todo t WHERE t.completed = 0", nativeQuery = true)
    List<Todo> activeTodos();
}
