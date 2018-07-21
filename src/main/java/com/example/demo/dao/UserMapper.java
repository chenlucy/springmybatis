package com.example.demo.dao;

import com.example.demo.core.Mapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 * @author corey
 */
@Repository
public interface UserMapper extends Mapper<User> {
}