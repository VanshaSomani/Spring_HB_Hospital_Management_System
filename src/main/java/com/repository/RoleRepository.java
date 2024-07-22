package com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	List<RoleEntity> findByRoleName(String roleName);
}
