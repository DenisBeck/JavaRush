package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Dennis on 08.06.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        boolean hasType = false;
        for (ImageTypes it : ImageTypes.values()) {
            if (it.equals(type))
                hasType = true;
        }
        if (!hasType)
            throw new IllegalArgumentException();

        ImageReader ir = null;
        switch (type) {
            default: throw new IllegalArgumentException();
            case BMP: ir = new BmpReader(); break;
            case JPG: ir = new JpgReader(); break;
            case PNG: ir = new PngReader(); break;
        }
        return ir;
    }
}
