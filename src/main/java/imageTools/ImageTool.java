package imageTools;

import java.awt.image.BufferedImage;

public class ImageTool {

    public static boolean differenceLessThan(int percentOfDiff, int percentOfBrokenPixels, byte[] a, byte[] b){
        boolean isLess = false;
        int brokenPixel = 0;
        int similar = 0;

        for (int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                if((Math.abs(a[i] - b[i])*100/256) > percentOfDiff){
                    brokenPixel++;
                } else {
                    similar++;
                }
            }
        }
     //   System.out.println(brokenPixel + " - broken pixels, " + similar + " - similar pixels, " + a.length + " - all pixels");
        int percent = 100*brokenPixel/a.length;
        if ( percent < percentOfBrokenPixels){
            isLess = true;
        }
        return isLess;
    }

    private byte[] getDataFromBufferedImageAsByte(BufferedImage bufferedImage){
        int pixels = bufferedImage.getHeight()*bufferedImage.getWidth();
        byte[] arr = new byte[pixels*3];
        for (int i = 0; i < bufferedImage.getHeight(); i++){
            for (int j = 0; j < bufferedImage.getWidth(); j++) {
                int rgb = bufferedImage.getRGB(j, i);
                arr[j + i*bufferedImage.getWidth()] = (byte) (rgb >>> 16);
                arr[j + i*bufferedImage.getWidth() + pixels] = (byte) (rgb >>> 8);
                arr[j + i*bufferedImage.getWidth() + pixels*2] = (byte) (rgb );
            }
        }
        return arr;
    }
}
