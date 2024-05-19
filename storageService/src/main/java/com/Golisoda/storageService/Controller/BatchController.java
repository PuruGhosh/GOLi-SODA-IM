package com.Golisoda.storageService.Controller;

import com.Golisoda.storageService.Dto.BatchDto;
import com.Golisoda.storageService.Dto.ProductDto;
import com.Golisoda.storageService.Entity.RestResponse;
import com.Golisoda.storageService.Service.BatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/batch")
@Slf4j
public class BatchController {
    @Autowired
    private BatchService batchService;
    @PostMapping
    public ResponseEntity<RestResponse<BatchDto>> addBatch(@RequestBody BatchDto batchDto) {
        log.info("Adding batch {}",batchDto);
        RestResponse<BatchDto> response = new RestResponse<>();
        response.setData(batchService.addBatch(batchDto));
        return ResponseEntity.ok(response);
    }

}
