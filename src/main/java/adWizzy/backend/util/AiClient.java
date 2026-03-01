package adWizzy.backend.util;

import io.swagger.v3.oas.models.headers.Header;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class AiClient {
    @Value("${ai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String generateVideo(String prompt) {

        System.out.println("=== Mock AI video running ===");
        System.out.println("Prompt -> " + prompt);

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return "https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";

    }
}


//        try {
//            Thread.sleep(5000);
//        }catch (InterruptedException e){
//            Thread.currentThread().interrupt();
//        }
//        return "https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";


