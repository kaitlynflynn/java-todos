package com.lambdaschool.todos;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.Users;
import com.lambdaschool.todos.repository.TodoRepository;
import com.lambdaschool.todos.repository.UsersRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Todo List App", description = "ToDo List App for Tracking your To Do List")
@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)

public class TodoListController
{
    @Autowired
    TodoRepository todorepo;

    @Autowired
    UsersRepository usersrepo;

    // *  200 - successfully retrieve list
    // *  401 - not authorized for this resource
    // *  403 - access to resource forbidden
    // *  404 - resource not found
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "Successfully Retrieved List"),
                    @ApiResponse(code = 401, message = "Not Authorized for this Resource"),
                    @ApiResponse(code = 403, message = "Access to Resource Forbidden"),
                    @ApiResponse(code = 404, message = "Resource Not Found")
            })
    @GetMapping("/users")
    public List<Users> allUsers()
    {
        return usersrepo.findAll();
    }

    @GetMapping("/todos")
    public List<Todo> allTodos()
    {
        return todorepo.findAll();
    }
}
