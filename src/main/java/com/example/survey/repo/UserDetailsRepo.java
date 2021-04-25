package com.example.survey.repo;

import com.example.survey.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<User, String> {
}

