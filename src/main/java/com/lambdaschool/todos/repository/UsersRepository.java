package com.lambdaschool.todos.repository;

import com.lambdaschool.todos.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer>
{
}
