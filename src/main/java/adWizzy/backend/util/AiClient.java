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

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String Body = """
                {
                "version": "Model_version",
                "input": {
                "prompt": "%s"
                }
                }
                """.formatted(prompt);

        HttpEntity<String> httpEntity = new HttpEntity<>(Body, headers);

        //Create Prediction
        ResponseEntity<Map> response = restTemplate.postForEntity(
                "https://api.replicate.com/v1/predictions",
                httpEntity,
                Map.class
        );

        Map responseBody = response.getBody();
        Map urls = (Map) responseBody.get("urls");
        String statusUrl = (String) urls.get("get");

        //Polling untill completed
        while (true){
            ResponseEntity<Map> statusResponse = restTemplate.exchange(
                    statusUrl,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    Map.class
            );

            Map statusBody = statusResponse.getBody();
            String status = (String) statusBody.get("status");

            if ("succeeded".equals(status)){
                Object output = statusBody.get("output");

                if (output instanceof String){
                    return (String) output;
                }

                if (output instanceof List<?> list && !list.isEmpty() ){
                    return (String) list.get(0);
                }

                throw new RuntimeException("unexpected output format");
            }
            if ("failed".equals(status)){
                throw new RuntimeException("video generation failed");
            }

            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }

    }
}


//        try {
//            Thread.sleep(5000);
//        }catch (InterruptedException e){
//            Thread.currentThread().interrupt();
//        }
//        return "https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";


