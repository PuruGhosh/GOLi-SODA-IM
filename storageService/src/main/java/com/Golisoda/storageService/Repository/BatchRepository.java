package com.Golisoda.storageService.Repository;

import com.Golisoda.storageService.Entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<Batch,String> {}
