package com.example.sp_lab;

public class AlignRight implements AlignStrategy{
    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println("Right Alignment");
    }
}
