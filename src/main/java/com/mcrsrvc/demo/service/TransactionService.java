package com.mcrsrvc.demo.service;

import com.mcrsrvc.demo.entity.TransactionEntity;
import java.util.List;

public interface TransactionService {

    List<TransactionEntity> findAllByUserId(Long userId);
    List<TransactionEntity> findAllByProjectId(Long projectId);
    void save(TransactionEntity transaction);

}
