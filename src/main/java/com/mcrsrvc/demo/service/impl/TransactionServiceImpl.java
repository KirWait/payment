package com.mcrsrvc.demo.service.impl;

import com.mcrsrvc.demo.entity.TransactionEntity;
import com.mcrsrvc.demo.repository.TransactionRepository;
import com.mcrsrvc.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl (TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionEntity> findAllByUserId(Long userId) {
        return transactionRepository.findAllByUserId(userId);
    }

    @Override
    public List<TransactionEntity> findAllByProjectId(Long projectId){
        return transactionRepository.findAllByProjectId(projectId);

    }

    @Override
    public void save(TransactionEntity transaction) {
        transactionRepository.save(transaction);
    }


}
