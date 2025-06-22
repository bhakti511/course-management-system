package com.bhakti.courseapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhakti.courseapp.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
