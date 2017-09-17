package ca.wglabs.messageboard.dto;

import java.time.Instant;
import java.time.LocalDateTime;

public class MessageDto {

    private String id;
    private String text;
    private LocalDateTime createDate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
