package adWizzy.backend.service;

import adWizzy.backend.dto.AdsRequestDto;
import adWizzy.backend.entity.AiAdInfo;
import adWizzy.backend.repository.AiAdRepository;
import adWizzy.backend.util.AiClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AiVideoGen {

    private final AiClient aiClient;
    private final AiAdRepository aiAdRepository;

    public AiVideoGen(AiClient aiClient, AiAdRepository aiAdRepository){
        this.aiClient = aiClient;
        this.aiAdRepository = aiAdRepository;
    }

    public  String generateVideo(AdsRequestDto dto){

//        Prompt banao-------
        String prompt = buildPrompt(dto);
//        call AI only once
        String videoUrl = aiClient.generateVideo(prompt);


//        Entities
        AiAdInfo aiAd = new AiAdInfo();
        aiAd.setPrompt(prompt);
        aiAd.setGeneratedVideoUrl(videoUrl);
        aiAd.setPlatform(dto.getPlatform());
        aiAd.setCreateAt(LocalDateTime.now());

        aiAdRepository.save(aiAd);

        return videoUrl;

    }
    private String buildPrompt(AdsRequestDto dto){
        return "Create an Ad for " + dto.getProductName() +
                " Target audience " + dto.getTargetAudience() +
                " for platform " + dto.getPlatform() +
                " with engaging visuals and branding.";
    }
}