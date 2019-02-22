package com.lambdaschool.todos;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.models.Users;
import com.lambdaschool.todos.repository.TodoRepository;
import com.lambdaschool.todos.repository.UsersRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

//    *  `GET /users` - returns all the users
//    *  `GET /todos` - return all the todos
//    *  `GET /users/userid/{userid}` - return the user based off of the user id
//    *  `GET /users/username/{username}` - return the user based off of the user name
//    *  `GET /todos/todoid/{todoid}` - return the todo based off of the todo id
//    *  `GET /todos/users` - return a listing of the todos with its assigned user's name
//    *  `GET /todos/active` - return a listing of the todos not yet completed.
//    *  `POST /users` - adds a user
//    *  `POST /todos` - adds a todo
//    *  `PUT /users/userid/{userid}` - updates a user based on userid
//    *  `PUT /todos/todoid/{todoid}` - updates a todo based on todoid
//    *  `DELETE /users/userid/{userid}` - Deletes a user based off of their userid and deletes all their associated todos
//    *  `DELETE /todos/todoid/{todoid}` - deletes a todo based off its todoid

    @GetMapping("/users")
    public List<Users> allUsers()
    {
        return usersrepo.findAll();
    }

    @ApiOperation(value = "Returns List of All ToDos", response = Todo.class)
    @GetMapping("/todos")
    public List<Todo> allTodos()
    {
        return todorepo.findAll();
    }

    //-----------------------------------------------------------------
    @ApiOperation(value = "User based off of user id", response = Users.class)
    @GetMapping("/users/userid/{userid}")
    public Users findUserById(@PathVariable long id)
    {
        var foundUser = usersrepo.findById(id);
        if (foundUser.isPresent())
        {
            return foundUser.get();
        } else
        {
            return null;
        }
    }

//    @GetMapping("/users/userid/{userid}")
//    public Users findTodoById(@PathVariable int id)
//    {
//        var foundUser = usersrepo.findById(id);
//        if (foundUser.isPresent())
//        {
//            return foundUser.get();
//        } else
//        {
//            return null;
//        }
//    }
    //-----------------------------------------------------------------


    @GetMapping("/users/username/{username}")
    public Users findUserByName(@PathVariable String username)
    {
        var foundUser = usersrepo.findByUsername(username);
        if (foundUser != null)
        {
            return foundUser;
        } else
        {
            return null;
        }
    }

    @GetMapping("/todos/todoid/{todoid}")
    public Todo findTodoById(@PathVariable int todoid)
    {
        var foundTodo = todorepo.findById(todoid);
        if (foundTodo.isPresent())
        {
            return foundTodo.get();
        } else
        {
            return null;
        }
    }

    @GetMapping("/todos/users")
    public List<Object[]> getTodosAndUsers()
    {
        return todorepo.todosWithUser();
    }


}
