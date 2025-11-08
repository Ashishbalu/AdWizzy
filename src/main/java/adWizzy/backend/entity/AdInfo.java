package adWizzy.backend.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "ads")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class AdInfo {

    @Id
    private String id;
    private String prompt;
    private String generatedText;

    private String productName;

    private String targetAudience;

    public AdInfo() {

    }

    public AdInfo(String prompt, String generatedText) {
        this.prompt = prompt;
        this.generatedText = generatedText;
    }



//    --getters------
    public String getId() {
        return id;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getGeneratedText() {
        return generatedText;
    }


    public String getTargetAudience() {
        return targetAudience;
    }
//    ---setters-------

    public void setId(String id) {
        this.id = id;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setGeneratedText(String generatedText) {
        this.generatedText = generatedText;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }
}
