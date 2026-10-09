package com.example.sp_lab;

public class AlignLeft implements AlignStrategy{

    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println(paragraph.getText());
    }
}
