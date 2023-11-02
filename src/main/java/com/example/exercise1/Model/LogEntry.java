package com.example.exercise1.Model;


public class LogEntry {
    private String time;
    private String level;
    private String message;
    private String line;





    public String getTime() {
        return time;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getLine() {
        return line;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLine(String line) {
        this.line = line;
    }


    public LogEntry(String time, String level, String message, String line) {
        this.time = time;
        this.level = level;
        this.message = message;
        this.line = line;
    }
}
