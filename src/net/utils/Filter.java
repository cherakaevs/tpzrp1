package net.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Filter {
    public static void filterImage(String src, String res) throws IOException {
        BufferedImage tmp = ImageIO.read(new File(src));

        for(int i=1; i<tmp.getHeight()-1; i++)
        {
            for(int j=1; j < tmp.getWidth()-1; j++)
            {
                int x = j;
                int y = i;

                PixelDot p1 = new PixelDot(x-1, y-1);
                PixelDot p2 = new PixelDot(x, y-1);
                PixelDot p3 = new PixelDot(x+1, y-1);
                PixelDot p4 = new PixelDot(x-1, y);
                PixelDot p = new PixelDot(x, y);
                PixelDot p6 = new PixelDot(x+1, y);
                PixelDot p7 = new PixelDot(x-1, y+1);
                PixelDot p8 = new PixelDot(x, y+1);
                PixelDot p9 = new PixelDot(x+1, y+1);


                p1.setColor(new Color(tmp.getRGB(p1.getX(), p1.getY())));
                p2.setColor(new Color(tmp.getRGB(p2.getX(), p2.getY())));
                p3.setColor(new Color(tmp.getRGB(p3.getX(), p3.getY())));
                p4.setColor(new Color(tmp.getRGB(p4.getX(), p4.getY())));
                p.setColor(new Color(tmp.getRGB(p.getX(), p.getY())));
                p6.setColor(new Color(tmp.getRGB(p6.getX(), p6.getY())));
                p7.setColor(new Color(tmp.getRGB(p7.getX(), p7.getY())));
                p8.setColor(new Color(tmp.getRGB(p8.getX(), p8.getY())));
                p9.setColor(new Color(tmp.getRGB(p9.getX(), p9.getY())));

                int[] redArray = new int[9];
                redArray[0] = p1.getColor().getRed();
                redArray[1] = p2.getColor().getRed();
                redArray[2] = p3.getColor().getRed();
                redArray[3] = p4.getColor().getRed();
                redArray[4] = p.getColor().getRed();
                redArray[5] = p6.getColor().getRed();
                redArray[6] = p7.getColor().getRed();
                redArray[7] = p8.getColor().getRed();
                redArray[8] = p9.getColor().getRed();
                Arrays.sort(redArray);
                int medianRed = redArray[4];


                int[] greenArray = new int[9];
                greenArray[0] = p1.getColor().getRed();
                greenArray[1] = p2.getColor().getRed();
                greenArray[2] = p3.getColor().getRed();
                greenArray[3] = p4.getColor().getRed();
                greenArray[4] = p.getColor().getRed();
                greenArray[5] = p6.getColor().getRed();
                greenArray[6] = p7.getColor().getRed();
                greenArray[7] = p8.getColor().getRed();
                greenArray[8] = p9.getColor().getRed();
                Arrays.sort(greenArray);
                int medianGreed = greenArray[4];

                int[] blueArray = new int[9];
                blueArray[0] = p1.getColor().getRed();
                blueArray[1] = p2.getColor().getRed();
                blueArray[2] = p3.getColor().getRed();
                blueArray[3] = p4.getColor().getRed();
                blueArray[4] = p.getColor().getRed();
                blueArray[5] = p6.getColor().getRed();
                blueArray[6] = p7.getColor().getRed();
                blueArray[7] = p8.getColor().getRed();
                blueArray[8] = p9.getColor().getRed();
                Arrays.sort(blueArray);
                int medianBlue = blueArray[4];

                Color nc = new Color(medianRed, medianGreed, medianBlue);
                tmp.setRGB(x, y, nc.getRGB());
            }
        }
        File result = new File(res);
        ImageIO.write(tmp, "jpeg", result);
    }
}


