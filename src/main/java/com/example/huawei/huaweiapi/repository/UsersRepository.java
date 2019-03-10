package com.example.huawei.huaweiapi.repository;

import com.example.huawei.huaweiapi.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUserName(String username);
}
