package com.nt.mobile.service;

import com.nt.mobile.repository.AssetRepository;
import com.nt.mobile.model.Asset;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AssetService {

    private final AssetRepository assetRepository;

    public List<Asset> fetchAllAssets(){
        return assetRepository.findAll();
    }
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset) {
        try{
            Asset _asset = assetRepository.save(new Asset(asset.getAssetId(),
                    asset.getSerialNumber(), asset.getType(),
                    asset.getOs(), asset.getAllocatedDate(),
                    asset.getExpiryDate(), asset.getOwner(),
                    asset.isClientOwned(),asset.getAllocatedTo())
            );
            return new ResponseEntity<>(_asset, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<Asset>> fetchAssetByAllocatedTo(String allocatedTo){
        try{
            List <Asset> assets = assetRepository.findAssetByAllocatedTo(allocatedTo);

            if(assets.size()>0){
                return new ResponseEntity<>(assets, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus>deleteByAssetId(String assetId){
           try{
               assetRepository.deleteById(assetId);
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }catch (Exception e) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }
}