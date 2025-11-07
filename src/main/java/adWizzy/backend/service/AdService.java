package adWizzy.backend.service;

import adWizzy.backend.entity.AdInfo;
import adWizzy.backend.repository.AdRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdService {


    private final AdRepository adRepository;

    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public void saveEntry(AdInfo adInfo) {
        adRepository.save(adInfo);
    }

    public List<AdInfo> getAllAds() {
        return adRepository.findAll();
    }

    public Optional<AdInfo> findById(ObjectId id) {
        return adRepository.findById(id);
    }

    public AdInfo createAd(AdInfo adInfo) {
        return adRepository.save(adInfo);
    }

    public boolean deleteAdInfoById(ObjectId id) {
       if (adRepository.existsById(id)){
           adRepository.deleteById(id);
           return true; //Sucessfully deleted
       }
       return false; //Not found
    }

    public ResponseEntity<?> updateAd(ObjectId id, AdInfo updatedAd) {
       return adRepository.findById(id)
               .map(existingAd ->{
                   existingAd.setPrompt(updatedAd.getPrompt());
                   existingAd.setGeneratedText(updatedAd.getGeneratedText());
                   AdInfo savedAd = adRepository.save(existingAd);
                   return ResponseEntity.ok(savedAd);
               })
               .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
