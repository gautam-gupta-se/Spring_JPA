package com.gautam.irs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gautam.irs.entity.UserEntity;
public interface UserRepository extends JpaRepository<UserEntity, String> {
	
}
