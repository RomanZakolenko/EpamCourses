package com.zakolenko.epam.block05.labwork1;

import java.util.Date;

public class Answer extends ForumMessage {
    private String receiverName;

    public Answer() {
    }

    public Answer(String author, Theme theme, String text, String receiverName) {
        super(author, theme, text);
        setDateOfCreate(new Date());
        setDateOfUpdate(getDateOfCreate());
        this.receiverName = receiverName;
    }

    public Answer(String author, Theme theme, String text, String receiverName, Date dateOfCreate, Date dateOfUpdate) {
        super(author, theme, text, dateOfCreate, dateOfUpdate);
        this.receiverName = receiverName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Answer answer = (Answer) obj;
        return receiverName.equals(answer.receiverName);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + receiverName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Answer{" + super.toString() +
                "receiverName='" + receiverName + '\'' +
                '}';
    }
}

