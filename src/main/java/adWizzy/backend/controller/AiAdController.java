package adWizzy.backend.controller;

import adWizzy.backend.dto.AiAdRequestDto;
import adWizzy.backend.dto.AiResponseDto;
import adWizzy.backend.service.AiVideoGen;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/ads/video")
public class AiAdController {

    private final AiVideoGen aiVideoGen;

    public AiAdController(AiVideoGen aiVideoGen) {
        this.aiVideoGen = aiVideoGen;
    }

    @PostMapping("/generate")
    public ResponseEntity<AiResponseDto> generateVideo(@RequestBody AiAdRequestDto dto) {
        AiResponseDto response = aiVideoGen.startVideoGeneration(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status/{jobId}")
    public ResponseEntity<Map<String, Object>> getStatus(
            @PathVariable("jobId") String jobId) {

        return ResponseEntity.ok(aiVideoGen.getJobStatus(jobId));
    }

    @GetMapping("/history")
    public ResponseEntity<List<AiResponseDto>> getAdsHistory() {
        List<AiResponseDto> history = aiVideoGen.getVideoHistory();
        return ResponseEntity.ok(history);
    }

}
