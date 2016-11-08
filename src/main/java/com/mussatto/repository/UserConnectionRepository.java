package com.mussatto.repository;

import com.mussatto.model.UserConnection;
import com.mussatto.model.UserConnectionPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConnectionRepository extends JpaRepository<UserConnection, UserConnectionPK> {
}
