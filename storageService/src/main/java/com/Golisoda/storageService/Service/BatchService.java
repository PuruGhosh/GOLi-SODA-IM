package com.Golisoda.storageService.Service;

import com.Golisoda.storageService.Dto.BatchDto;
import com.Golisoda.storageService.Exception.ProductException;
import com.Golisoda.storageService.Repository.BatchRepository;
import com.Golisoda.storageService.Repository.ProductRepository;
import com.Golisoda.storageService.Util.BatchMapper;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BatchService {
    @Autowired
    private BatchRepository  batchRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BatchMapper batchMapper;
    @Value("${batch.expiry.days}")
    private int expiry_days;
    public BatchDto addBatch(BatchDto batchDto) {
        log.info("Adding new batch {}",batchDto);
        if(batchDto.getManufactureDate() == null){
            batchDto.setManufactureDate(LocalDateTime.now());
        }
        log.info("Setting expiry date after {}",expiry_days);
        batchDto.setExpiryDate(batchDto.getManufactureDate().plusDays(expiry_days));
        var batch = batchMapper.toBatch(batchDto);
        var product = productRepository.findById(batchDto.getProductID());
        if(product.isEmpty()){
            throw new ProductException("The product with product id %s is not present.".formatted(batchDto.getProductID()));
        }
        batch.setProduct(product.get());
        batch.setBatchID(UUID.randomUUID().toString());

        return batchMapper.toBatchDto(batchRepository.save(batch));
    }
}
