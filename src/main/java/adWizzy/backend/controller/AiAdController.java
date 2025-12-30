package adWizzy.backend.controller;

import adWizzy.backend.dto.AdsRequestDto;
import adWizzy.backend.service.AiVideoGen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/ads/video")
public class AiAdController {

    private final AiVideoGen aiVideoGen;

    public AiAdController(AiVideoGen aiVideoGen){
        this.aiVideoGen = aiVideoGen;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateVideo(@RequestBody AdsRequestDto dto){

        String videoUrl = aiVideoGen.generateVideo(dto);
        return ResponseEntity.ok(videoUrl);
    }

}
