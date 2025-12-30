package adWizzy.backend.dto;

import java.time.LocalDateTime;

public class AiResponseDto {

    private String id;
    private String videoUrl;
    private String platform;
    private LocalDateTime createAt;
    private String status;

    public AiResponseDto(){
    }

    public AiResponseDto(String id, String videoUrl, String platform, LocalDateTime createAt, String status){
        this.id = id;
        this.videoUrl = videoUrl;
        this.platform = platform;
        this.createAt = createAt;
        this.status = status;
    }

    //getters & setters
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getPlatform(){
        return platform;
    }

    public void setPlatform(String platform){
        this.platform = platform;
    }

    public String getVideoUrl(){
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl){
        this.videoUrl = videoUrl;
    }


    public LocalDateTime getCreateAt(){
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt){
        this.createAt = createAt;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }


}
