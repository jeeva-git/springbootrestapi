package com.nt.mobile.repository;

import com.nt.mobile.model.Asset;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
public interface AssetRepository extends MongoRepository<Asset, String> {
    List<Asset> findAssetByAllocatedTo (String allocatedTo);

    @Override
    void deleteById(String assetId);
}
