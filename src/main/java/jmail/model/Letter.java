package jmail.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Admin on 04.10.14.
 */
@Entity
@Table(name = "letters")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "to_user")
    private User to;

    @OneToOne
    @JoinColumn(name = "from_user")
    private User from;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "send_date")
    private Date date;

    public Letter() {
    }

    public Letter(int id, String title, User to, User from, Date date, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.to = to;
        this.from = from;
        this.date = date;
    }

    public Letter(String title, User to, User from, Date date, String body) {
        this.title = title;
        this.body = body;
        this.to = to;
        this.from = from;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", from=" + from.getLogin() +
                ", to=" + to.getLogin() +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }

}
