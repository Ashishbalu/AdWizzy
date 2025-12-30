package adWizzy.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Ai_Ads")
public class AiAdInfo {


    @Id
    private String id;
    private String prompt;
    private String generatedText;
    private String generatedVideoUrl;
    private String modelUsed;
    private String platform;
    private LocalDateTime createAt;

    public AiAdInfo() {

    }

    public AiAdInfo(String prompt, String generatedText, String modelUsed) {
        this.prompt = prompt;
        this.generatedText = generatedText;
        this.modelUsed = modelUsed;
    }

    //    -----Getters & Setters for prompt---------
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    //    ------getters & Setters for getGeneratedText---------
    public String getGeneratedText() {
        return generatedText;
    }

    public void setGeneratedText(String generatedText) {
        this.generatedText = generatedText;
    }

    //     ------getters & Setters for getGeneratedVideoUrl---------
    public String getGeneratedVideoUrl() {
        return generatedVideoUrl;
    }

    public void setGeneratedVideoUrl(String generatedVideoUrl) {
        this.generatedVideoUrl = generatedVideoUrl;
    }

    //  ------getters & Setters for modelUsed---------
    public String getModelUsed() {
        return modelUsed;
    }

    public void setModelUsed(String modelUsed) {
        this.modelUsed = modelUsed;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }


}
