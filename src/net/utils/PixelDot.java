package net.utils;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class PixelDot {
    private int x;
    private int y;

    Color color;

    public PixelDot(int x, int y){
        this.x = x;
        this.y = y;
    }
}
