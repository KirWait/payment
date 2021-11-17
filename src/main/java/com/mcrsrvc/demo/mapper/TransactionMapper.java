package com.mcrsrvc.demo.mapper;

import com.mcrsrvc.demo.dto.TransactionRequestDto;
import com.mcrsrvc.demo.dto.TransactionResponseDto;
import com.mcrsrvc.demo.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionMapper {
    TransactionEntity transactionRequestDtoToTransactionEntity(TransactionRequestDto requestDto);
    TransactionResponseDto transactionEntityToTransactionResponseDto(TransactionEntity transactionEntity);

}
