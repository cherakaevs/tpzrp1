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


                p1.setColor(new Color(tmp.getRGB(p1.x, p1.y)));
                p2.setColor(new Color(tmp.getRGB(p2.x, p2.y)));
                p3.setColor(new Color(tmp.getRGB(p3.x, p3.y)));
                p4.setColor(new Color(tmp.getRGB(p4.x, p4.y)));
                p.setColor(new Color(tmp.getRGB(p.x, p.y)));
                p6.setColor(new Color(tmp.getRGB(p6.x, p6.y)));
                p7.setColor(new Color(tmp.getRGB(p7.x, p7.y)));
                p8.setColor(new Color(tmp.getRGB(p8.x, p8.y)));
                p9.setColor(new Color(tmp.getRGB(p9.x, p9.y)));

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

    private static class PixelDot{
        private int x;
        private int y;

        Color color;

        public PixelDot(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }
}


