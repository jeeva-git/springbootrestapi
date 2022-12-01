package com.nt.mobile.controller;

import com.nt.mobile.service.AssetService;
import com.nt.mobile.model.Asset;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/common")
@AllArgsConstructor
public class AssetController {
    private final AssetService assetService;
    @GetMapping("/assets")
    public List<Asset> fetchAllAssets(){
       return assetService.fetchAllAssets();
    }
    @PostMapping("/asset")
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset){
        return assetService.createAsset(asset);
    }
    @GetMapping("/asset/{allocatedTo}")
    public ResponseEntity<List<Asset>> retrieveAsset(@PathVariable("allocatedTo") String allocatedTo){
        return assetService.fetchAssetByAllocatedTo(allocatedTo);
    }
    @DeleteMapping("/asset/delete/{assetId}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("assetId") String assetId) {
        return assetService.deleteByAssetId(assetId);
    }

}
