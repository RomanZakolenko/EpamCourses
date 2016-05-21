package com.zakolenko.epam.block05.labwork1;

import java.util.Date;

public class ForumMessage {
    private String author;
    private Theme theme;
    private String text;
    private Date dateOfCreate;
    private Date dateOfUpdate;

    public ForumMessage() {
    }

    public ForumMessage(String author, Theme theme, String text) {
        this.author = author;
        this.theme = theme;
        this.text = text;
        this.dateOfCreate = new Date();
        this.dateOfUpdate = this.dateOfCreate;
    }

    public ForumMessage(String author, Theme theme, String text, Date dateOfCreate, Date dateOfUpdate) {
        this.author = author;
        this.theme = theme;
        this.text = text;
        this.dateOfCreate = dateOfCreate;
        this.dateOfUpdate = dateOfUpdate;
    }

    public void appendText(String text) {
        this.text += text;
    }

    public void appendText(String... texts) {
        StringBuilder text = new StringBuilder(this.text);
        for (String t : texts) {
            text.append(t);
        }
        this.text = text.toString();
    }

    public boolean findStringInText(String string) {
        return text.contains(string);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public void setDateOfUpdate(Date dateOfUpdate) {
        this.dateOfUpdate = dateOfUpdate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ForumMessage message = (ForumMessage) obj;
        if (!author.equals(message.author)) return false;
        if (theme != message.theme) return false;
        if (!text.equals(message.text)) return false;
        if (!dateOfCreate.equals(message.dateOfCreate)) return false;
        return dateOfUpdate.equals(message.dateOfUpdate);

    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + theme.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + dateOfCreate.hashCode();
        result = 31 * result + dateOfUpdate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ForumMessage{" +
                "author='" + author + '\'' +
                ", theme=" + theme +
                ", text='" + text + '\'' +
                ", dateOfCreate=" + dateOfCreate +
                ", dateOfUpdate=" + dateOfUpdate +
                '}';
    }
}
