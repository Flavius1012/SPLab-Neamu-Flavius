package com.example.sp_lab.strategy_pattern;

import com.example.sp_lab.Context;
import com.example.sp_lab.Paragraph;

public class AlignCenter implements AlignStrategy{
    @Override
    public void render(Paragraph paragraph, Context context) {
        int width = context.getWidth();
        int spaces = Math.max(0, (width - paragraph.getText().length()) / 2);
        System.out.println(" ".repeat(spaces) + paragraph.getText());
    }
}
