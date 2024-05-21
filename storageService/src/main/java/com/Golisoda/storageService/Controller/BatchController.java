package com.Golisoda.storageService.Controller;

import com.Golisoda.storageService.Dto.BatchDto;
import com.Golisoda.storageService.Entity.RestResponse;
import com.Golisoda.storageService.Service.BatchService;
import com.Golisoda.storageService.Service.RestClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/batch")
@RequiredArgsConstructor
@Slf4j
public class BatchController {
    
    private final BatchService batchService;
    private final RestClientService restClientService;
    @PostMapping
    public ResponseEntity<RestResponse<BatchDto>> addBatch(@RequestBody BatchDto batchDto) {
        log.info("Adding batch {}",batchDto);
        RestResponse<BatchDto> response = new RestResponse<>();
        response.setData(batchService.addBatch(batchDto));
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<RestResponse<Page<BatchDto>>> getAllBatch(Pageable page){
        log.info("Finding all batches.");
        var response = new RestResponse<Page<BatchDto>>();
        response.setData(batchService.getAllBatch(page));
        return ResponseEntity.ok(response);
    }


}
