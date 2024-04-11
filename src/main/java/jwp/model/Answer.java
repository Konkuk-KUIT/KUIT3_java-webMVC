package jwp.model;

import java.sql.Date;
import java.time.LocalDate;

public class Answer {
    private int answerId;
    private int questionId;
    private String author;
    private String contents;
    private Date createdDate;

    public Answer(int questionId, String author, String contents) {
        this.answerId = 0;
        this.questionId = questionId;
        this.author = author;
        this.contents = contents;
        this.createdDate = Date.valueOf(LocalDate.now());
    }

    public int getAnswerId() {
        return answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContents() {
        return contents;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
