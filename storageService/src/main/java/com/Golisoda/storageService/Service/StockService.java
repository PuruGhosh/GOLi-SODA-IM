package com.Golisoda.storageService.Service;

import com.Golisoda.storageService.Constant.EnStockType;
import com.Golisoda.storageService.Dto.EnStockDto;
import com.Golisoda.storageService.Dto.StockDto;
import com.Golisoda.storageService.Exception.StockException;
import com.Golisoda.storageService.Repository.BatchRepository;
import com.Golisoda.storageService.Repository.StockRepository;
import com.Golisoda.storageService.Util.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StockService {
     private final StockRepository stockRepository;
     private final BatchRepository batchRepository;
     private final RestClientService restClientService;
     private final StockMapper stockMapper;
     public StockDto inStock(EnStockDto dto) {
          Assert.notNull(dto,"Request is empty for in stock.");
          if(dto.getType()!= EnStockType.INSTOCK){
               throw new StockException("Wrong enstock type.");
          }
          var wareHouse = restClientService.getWareHouseById(dto.getWarehouseId());
          if (wareHouse.isEmpty()){
               throw new StockException("wareHouse with id %s does not exist %d.".formatted(dto.getWarehouseId()));
          }
          var batch = batchRepository.findById(dto.getBatchId());
          if(batch.isEmpty()){
               throw new StockException("Batch with batchId %s does not exist.".formatted(dto.getBatchId()));
          }
          var batchEntity = batch.get();
          if(dto.getQuantity()>batchEntity.getItemLeft()){
               throw new StockException("Items requested for batchId %s is more than items left.Items left: %s, Items Requested: %s.".formatted(batchEntity.getBatchID(),batchEntity.getItemLeft(),dto.getQuantity()));
          }
          var stock = new StockDto();
          stock.setStockId(UUID.randomUUID().toString());
          stock.setQuantity(dto.getQuantity());
          stock.setBatchId(batchEntity.getBatchID());
          stock.setWarehouseId(wareHouse.get().getWarehouseId());
          stock.setProductId(batchEntity.getProduct().getProductID());
          var timeNow = LocalDateTime.now();
          stock.setCreateDate(timeNow);
          stock.setLastModified(timeNow);
          stockRepository.save(stockMapper.toStock(stock));
          batchEntity.setItemLeft(batchEntity.getItemLeft()-dto.getQuantity());
          batchRepository.save(batchEntity);
          return stock;
     }
}
