package com.Golisoda.storageService.Controller;

import com.Golisoda.storageService.Dto.EnStockDto;
import com.Golisoda.storageService.Dto.StockDto;
import com.Golisoda.storageService.Entity.RestResponse;
import com.Golisoda.storageService.Service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/stock")
@Slf4j
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;
    @PostMapping("/inStock")
    public ResponseEntity<RestResponse<StockDto>> inStock(@RequestBody EnStockDto dto){
        log.info("Processing stock {}",dto);
        var response = new RestResponse<StockDto>();
        response.setData(stockService.inStock(dto));
        return ResponseEntity.ok(response);
    }
}
