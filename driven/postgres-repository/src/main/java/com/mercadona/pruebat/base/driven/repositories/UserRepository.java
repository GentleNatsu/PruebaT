package com.mercadona.pruebat.base.driven.repositories;

import com.mercadona.pruebat.base.driven.repositories.models.UserMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserMO, String> {

    @Query("""
    SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END
    FROM UserMO u
    WHERE u.username = :username AND u.password = :password
    """)
    boolean isRegistered(String username, String password);

}