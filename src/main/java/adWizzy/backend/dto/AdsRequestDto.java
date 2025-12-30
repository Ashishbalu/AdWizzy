package adWizzy.backend.dto;

public class AdsRequestDto {

    private String prompt;
    private String productName;
    private String targetAudience;
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
