package com.example.sp_lab;

public class AlignRight implements AlignStrategy{
    @Override
    public void render(Paragraph paragraph, Context context) {
        int width = context.getWidth();
        int spaces = width - paragraph.getText().length();
        System.out.println(" ".repeat(spaces) + paragraph.getText());
    }
}
