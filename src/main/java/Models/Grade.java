package Models;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Grade {
    @NotBlank(message="Name cannot be Blank")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @NotBlank(message="Subject cannot be blank")
    private String subject;
    private String score;

    private String id;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}