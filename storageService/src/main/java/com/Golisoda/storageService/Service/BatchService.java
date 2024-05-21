package com.Golisoda.storageService.Service;

import com.Golisoda.storageService.Dto.BatchDto;
import com.Golisoda.storageService.Exception.BatchException;
import com.Golisoda.storageService.Exception.ProductException;
import com.Golisoda.storageService.Repository.BatchRepository;
import com.Golisoda.storageService.Repository.ProductRepository;
import com.Golisoda.storageService.Util.BatchMapper;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class BatchService {
    
    private final BatchRepository  batchRepository;
  
    private final ProductRepository productRepository;
    
    private final BatchMapper batchMapper;
    @Value("${batch.expiry.days}")
    private int EXPIRY_DAYS;
    public BatchDto addBatch(BatchDto batchDto) {
        log.info("Adding new batch {}",batchDto);
        if(batchDto.getManufactureDate() == null){
            batchDto.setManufactureDate(LocalDateTime.now());
        }
        batchDto.setItemLeft(batchDto.getQuantity());
        log.info("Setting expiry date after {}", EXPIRY_DAYS);
        batchDto.setExpiryDate(batchDto.getManufactureDate().plusDays(EXPIRY_DAYS));
        var batch = batchMapper.toBatch(batchDto);
        var product = productRepository.findById(batchDto.getProductID());
        if(product.isEmpty()){
            throw new ProductException("The product with product id %s is not present.".formatted(batchDto.getProductID()));
        }
        batch.setProduct(product.get());
        batch.setBatchID(UUID.randomUUID().toString());

        return batchMapper.toBatchDto(batchRepository.save(batch));
    }

    public Page<BatchDto> getAllBatch(Pageable page) {
        var batches = batchRepository.findAll(page);
        if(batches.isEmpty()){
            throw new BatchException("No batches found");
        }
        var batchDtoList = batches.getContent().stream().map(batchMapper::toBatchDto).toList();
        return new PageImpl<>(batchDtoList,batches.getPageable(),batches.getSize());
    }
}
