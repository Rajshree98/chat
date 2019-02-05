package com.nema.rajshree.chitchatting;


import java.util.List;

public class Message {
   // private String text;
    private String name;
   private String photourl;
    public String text;

    public Message()
   {}


    public Message(String text,String name,String photourl){
        this.text=text;
        this.name=name;
       this.photourl=photourl;
    }
    public String getText(){ return text;

    }
    public  String getName(){return name;}


   public String getPhotourl() {
        return photourl;
    }


}
