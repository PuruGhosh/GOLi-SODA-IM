package com.Golisoda.storageService.Service;

import com.Golisoda.storageService.Dto.WarehouseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@Slf4j
public class RestClientService {
    WebClient userClient;
    public RestClientService(@Qualifier("userServiceClient") WebClient userClient){
        this.userClient = userClient;
    }

    public void test(){
        var warehouseDto = userClient.get().uri("wh/kolkata").retrieve().bodyToMono(WarehouseDto.class).block();
        log.info("{}",warehouseDto);
    }

    public Optional<WarehouseDto> getWareHouseById(String id){
        var warehouseDto = userClient.get().uri("wh/id/"+id).retrieve().bodyToMono(WarehouseDto.class).block();
        log.info("{}",warehouseDto);
        return Optional.of(warehouseDto);
    }


}
