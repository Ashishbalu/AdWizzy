package adWizzy.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class AiAdRequestDto {

    private String prompt;

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Target audience section should not be empty")
    private String targetAudience;

    @NotBlank(message = "Platform is required")
    private String platform;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getTargetAudience(){
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience){
        this.targetAudience = targetAudience;
    }

    public String getPlatform(){
        return platform;
    }

    public void setPlatform(String platform){
        this.platform = platform;
    }

}


//productName
//targetAudience
//platform
//tone
