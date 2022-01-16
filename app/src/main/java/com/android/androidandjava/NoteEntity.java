package com.android.androidandjava;

public class NoteEntity {

    private String title;
    private String body;
    private long editData;

    public NoteEntity(String title, String body) {
        this.title = title;
        this.body = body;
        editData = getCurrentTime ();
    }

    private static long getCurrentTime() {
        return 0;
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
        editData = getCurrentTime ();
    }

    public long getEditData() {
        return editData;
    }

}
