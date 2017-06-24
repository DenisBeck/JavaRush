package com.javarush.task.task35.task3513;

import java.awt.*;

/**
 * Created by Dennis on 24.06.2017.
 */
public class Tile implements Cloneable {
    int value;

    public Tile() {
        value = 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Tile(int value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == 0;
    }

    public Color getFontColor() {
        if (value < 16)
            return Color.decode("0x776e65");
        return Color.decode("0xf9f6f2");
    }

    public Color getTileColor() {
        Color color = null;
        switch (value) {
            case 0:
                color = Color.decode("0xcdc1b4"); break;
            case 2:
                color = Color.decode("0xeee4da"); break;
            case 4:
                color = Color.decode("0xede0c8"); break;
            case 8:
                color = Color.decode("0xf2b179"); break;
            case 16:
                color = Color.decode("0xf59563"); break;
            case 32:
                color = Color.decode("0xf67c5f"); break;
            case 64:
                color = Color.decode("0xf65e3b"); break;
            case 128:
                color = Color.decode("0xedcf72"); break;
            case 256:
                color = Color.decode("0xedcc61"); break;
            case 512:
                color = Color.decode("0xedc850"); break;
            case 1024:
                color = Color.decode("0xedc53f"); break;
            case 2048:
                color = Color.decode("0xedc22e"); break;
            default:
                color = Color.decode("0xff0000"); break;
        }
        return color;
    }
}
