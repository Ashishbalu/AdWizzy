package adWizzy.backend.controller;


import adWizzy.backend.entity.AdInfo;
import adWizzy.backend.repository.AdRepository;
import adWizzy.backend.service.AdService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
//@Slf4j
@RequestMapping("/ads")
@CrossOrigin(origins = "http://localhost:3000")
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private AdRepository adRepository;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public List<AdInfo> getAllAds() {
        return adService.getAllAds();
    }

    @PostMapping("/generate-ad")
    public ResponseEntity<AdInfo> generateAd(@RequestBody Map<String, String> request) {
        String productName = request.get("productName");
        String targetAudience = request.get("targetAudience");
//        To--DO: Call AI API (OpenAI or gemini or else) to generate the ad....
        String prompt = "product:" + productName + "targetAudience: " + targetAudience;
        String getGeneratedText = "Ad for " + productName + ": perfect for " + targetAudience + "!";


        AdInfo adInfo = new AdInfo();
        adInfo.setProductName(productName);
        adInfo.setTargetAudience(targetAudience);
        adInfo.setPrompt(prompt);
        adInfo.setGeneratedText(getGeneratedText);
        AdInfo savedAd = adService.createAd(adInfo);
        return ResponseEntity.ok(savedAd);


    }

    @PostMapping
    public AdInfo createAds(@RequestBody AdInfo adInfo) {
        System.out.println("Received Entry: " + adInfo);
        AdInfo saved = adRepository.save(adInfo);
        System.out.println("Saved: " + saved);
        return saved;
    }

    @GetMapping("/{myId}")
    public ResponseEntity<AdInfo> getAdInfoById(@PathVariable ObjectId myId) {
        Optional<AdInfo> adInfo = adService.findById(myId);
        return adInfo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdInfoById(@PathVariable String id) {
//        adService.deleteAdInfoById(id);
        try {

            ObjectId objectId = new ObjectId(id);
            if (adRepository.existsById(objectId)) {
                adRepository.deleteById(objectId);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdInfoById(@PathVariable ObjectId id, @RequestBody AdInfo updatedAd) {
        return adService.updateAd(id, updatedAd);
    }
}
