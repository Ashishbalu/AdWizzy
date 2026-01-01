package adWizzy.backend.dto;

import java.time.LocalDateTime;

public class ApiErrorResponse {
    private final String status;
    private final String message;
    private final LocalDateTime timeStamp;

    public ApiErrorResponse(String status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
