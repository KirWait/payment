package com.mcrsrvc.demo.controller;

import com.mcrsrvc.demo.dto.TransactionRequestDto;
import com.mcrsrvc.demo.dto.TransactionResponseDto;
import com.mcrsrvc.demo.entity.TransactionEntity;
import com.mcrsrvc.demo.mapper.TransactionMapper;
import com.mcrsrvc.demo.service.TransactionService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TransactionController {

    private final TransactionMapper mapper = Mappers.getMapper(TransactionMapper.class);

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/pay/{projectId}")
    public ResponseEntity<TransactionResponseDto> payForProject(@PathVariable Long projectId,
                                                                @RequestBody TransactionRequestDto requestDto){
        requestDto.setProjectId(projectId);
       TransactionEntity transaction = mapper.transactionRequestDtoToTransactionEntity(requestDto);

       transactionService.save(transaction);
       TransactionResponseDto responseDto = mapper.transactionEntityToTransactionResponseDto(transaction);

       return new ResponseEntity<>(responseDto, HttpStatus.OK);
   }
    @GetMapping("/user_history/{userId}")
   public ResponseEntity<List<TransactionResponseDto>> getTransactionHistory(@PathVariable Long userId){
        List<TransactionEntity> transactionHistory = transactionService.findAllByUserId(userId);
        List<TransactionResponseDto> responseDtoList = transactionHistory.stream()
                .map(mapper::transactionEntityToTransactionResponseDto).collect(Collectors.toList());

        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @GetMapping("/project_history/{projectId}")
    public Long getPaidSum(@PathVariable Long projectId){
        List<TransactionEntity> transactionEntityList = transactionService.findAllByProjectId(projectId);

        return transactionEntityList.stream().mapToLong(TransactionEntity::getAmount).sum();
    }
}
