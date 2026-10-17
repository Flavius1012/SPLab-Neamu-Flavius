package com.example.sp_lab.strategy_pattern;

import com.example.sp_lab.Context;
import com.example.sp_lab.Paragraph;

public class AlignLeft implements AlignStrategy{

    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println(paragraph.getText());
    }
}
