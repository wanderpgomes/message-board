package ca.wglabs.messageboard.dto;

import java.util.Date;

public class MessageDto {

    private Long id;
    private String text;
    private Date createDate;
    private Long userId;
    private Long originalMessageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOriginalMessageId() {
        return originalMessageId;
    }

    public void setOriginalMessageId(Long originalMessageId) {
        this.originalMessageId = originalMessageId;
    }
}
