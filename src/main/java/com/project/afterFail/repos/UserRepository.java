package com.project.afterFail.repos;

import com.project.afterFail.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {

}
