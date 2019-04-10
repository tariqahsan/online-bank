package com.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.bank.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
