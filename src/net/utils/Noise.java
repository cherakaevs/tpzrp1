package net.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Noise {
    public static void addNoise(String src, String res) throws IOException {
        BufferedImage tmp = ImageIO.read(
                new File(src));
        
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < tmp.getWidth(); i += 5) {
            for (int j = 0; j < tmp.getHeight(); j++){
                int r = random.nextInt(255);
                int g = random.nextInt(255);
                int b = random.nextInt(255);
                Color c = new Color(r, g, b);
                tmp.setRGB(i, j, c.getRGB());
           }
        }

        File result = new File(res);
        ImageIO.write(tmp, "jpeg", result);
    }
}
