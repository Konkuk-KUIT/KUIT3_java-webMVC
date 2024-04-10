package jwp.model;

import java.sql.Date;
import java.time.LocalDate;

public class Question {
    private int questionId;
    private String author;
    private String title;
    private String contents;
    private Date createdDate;
    private int countOfAnswer;

    public Question(String author, String title, String contents) {
        this.questionId = 0;
        this.author = author;
        this.title = title;
        this.contents = contents;
        this.createdDate = Date.valueOf(LocalDate.now());
        this.countOfAnswer = 0;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public int getCountOfAnswer() {
        return countOfAnswer;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void increaseCountOfAnswer() {
        countOfAnswer++;
    }

    public void decreaseCountOfAnswer() {
        countOfAnswer--;
    }

    public void updateTitleAndContents(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public void update(Question question) {
        this.questionId = question.questionId;
        this.author = question.author;
        this.title = question.title;
        this.contents = question.contents;
        this.createdDate = question.createdDate;
        this.countOfAnswer = question.countOfAnswer;
    }
}
