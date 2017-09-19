package ca.wglabs.messageboard.model;


import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="message")
public class Message {

    private Long id;
    private String text;
    private Calendar createDate;
    private Long userId;
    private Long originalMessageId;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "original_message_id")
    public Long getOriginalMessageId() {
        return originalMessageId;
    }

    public void setOriginalMessageId(Long originalMessageId) {
        this.originalMessageId = originalMessageId;
    }
}
