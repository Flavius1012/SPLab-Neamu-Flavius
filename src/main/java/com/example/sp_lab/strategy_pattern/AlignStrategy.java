package com.example.sp_lab.strategy_pattern;

import com.example.sp_lab.Context;
import com.example.sp_lab.Paragraph;

public interface AlignStrategy {
    void render(Paragraph paragraph, Context context);
}
