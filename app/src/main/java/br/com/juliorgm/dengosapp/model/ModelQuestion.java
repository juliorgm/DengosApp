package br.com.juliorgm.dengosapp.model;

import java.util.List;

public class ModelQuestion {
    private String statement;
    private List<String> textAlternative;
    private enum TypeEnum {OPEN_QUESTION, SINGLE_CHOICE, MULTIPLE_CHOICE};
    private String correctAnswer;

    public ModelQuestion(String statement, List<String> textAlternative, String correctAnswer) {
        this.statement = statement;
        this.textAlternative = textAlternative;
        this.correctAnswer = correctAnswer;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public List<String> getTextAlternative() {
        return textAlternative;
    }

    public void setTextAlternative(List<String> textAlternative) {
        this.textAlternative = textAlternative;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
