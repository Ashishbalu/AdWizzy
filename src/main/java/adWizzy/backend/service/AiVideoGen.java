package adWizzy.backend.service;

import adWizzy.backend.dto.AiAdRequestDto;
import adWizzy.backend.dto.AiResponseDto;
import adWizzy.backend.entity.AiAdInfo;
import adWizzy.backend.exception.AiGenerationException;
import adWizzy.backend.repository.AiAdRepository;
import adWizzy.backend.util.AiClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AiVideoGen {

    private final AiClient aiClient;
    private final AiAdRepository aiAdRepository;

    public AiVideoGen(AiClient aiClient, AiAdRepository aiAdRepository) {
        this.aiClient = aiClient;
        this.aiAdRepository = aiAdRepository;
    }

    public AiResponseDto startVideoGeneration(AiAdRequestDto dto) {

//        Prompt banao-------
        String prompt = buildPrompt(dto);

        //Entities
        AiAdInfo aiAd = new AiAdInfo();
        aiAd.setPrompt(prompt);
      // aiAd.setGeneratedVideoUrl(videoUrl);
        aiAd.setPlatform(dto.getPlatform());
        aiAd.setStatus("Pending");
        aiAd.setCreateAt(LocalDateTime.now());

        AiAdInfo savedAd = aiAdRepository.save(aiAd);

        //Backgroud proccess
        generateVideoAsync(savedAd.getId(), prompt);

        // immediate response
        try {
            return new AiResponseDto(
                    savedAd.getId(),
                    null,
                    savedAd.getPlatform(),
                    savedAd.getCreateAt(),
                    "Pending"
            );
        } catch (Exception e) {
            throw new AiGenerationException("Failed to save video date");
        }
    }

    // Background Thread-----
    @Async
    public void generateVideoAsync(String jobId, String prompt) {
        AiAdInfo aiAd = aiAdRepository.findById(jobId).orElseThrow();

        try {
            String videoUrl = aiClient.generateVideo(prompt);
            if (videoUrl == null || videoUrl.isEmpty()) {
                throw new AiGenerationException("Ai video generation is failed");
            }
            aiAd.setGeneratedVideoUrl(videoUrl);
            aiAd.setStatus("complete");
        } catch (Exception e) {
            aiAd.setStatus("Failed");
        }
        aiAdRepository.save(aiAd);
    }

    public Map<String, Object> getJobStatus(String jobID){
        AiAdInfo ad = aiAdRepository.findById(jobID)
                .orElseThrow(()-> new RuntimeException("Job not found"));

        Map<String, Object> response = new HashMap<>();

        response.put("jobId", ad.getId());
        response.put("status", ad.getStatus());
        response.put("videoUrl", ad.getGeneratedVideoUrl()); // null allowed
        response.put("createdAt", ad.getCreateAt());

        return response;
    }


    public List<AiResponseDto> getVideoHistory() {
        List<AiAdInfo> ads = aiAdRepository.findTop10ByOrderByCreateAtDesc();

        return ads.stream()
                .map(ad -> new AiResponseDto(
                        ad.getId(),
                        ad.getGeneratedVideoUrl(),
                        ad.getPlatform(),
                        ad.getCreateAt(),
                        "success"
                ))
                .toList();
    }

    //Prompt Builder Service only--
    private String buildPrompt(AiAdRequestDto dto) {
        return "Create an Ad for " + dto.getProductName() +
                " Target audience " + dto.getTargetAudience() +
                " for platform " + dto.getPlatform() +
                " with engaging visuals and branding.";
    }
}