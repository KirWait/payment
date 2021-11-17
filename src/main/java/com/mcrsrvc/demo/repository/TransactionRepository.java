package com.mcrsrvc.demo.repository;

import com.mcrsrvc.demo.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
List<TransactionEntity> findAllByProjectId(Long projectId);
List<TransactionEntity> findAllByUserId(Long userId);
}
