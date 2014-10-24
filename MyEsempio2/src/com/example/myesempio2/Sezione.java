package com.example.myesempio2;

public class Sezione {
	
    private String sezione;
    private int photoRes;
    
    public Sezione(String sezione, int photoRes) {
            super();
            this.sezione = sezione;
            this.photoRes = photoRes;
    }
    
    public String getSezione() {
            return sezione;
    }
    public int getPhotoRes() {
            return photoRes;
    }
}
