package imageTools;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Base64;

public class Image{
    public int x;
    public int y;
    public int width;
    public int height;
    public byte[] byteData;

    public Image() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.byteData = null;
    }

    public Image(BufferedImage bufferedImage) {
        this.x = 0;
        this.y = 0;
        this.width = bufferedImage.getWidth();
        this.height = bufferedImage.getHeight();
        this.byteData = getDataFromBufferedImageAsByte(bufferedImage);
    }

    public Image(BufferedImage bufferedImage, Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
        this.byteData = getDataFromBufferedImageAsByte(bufferedImage);
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

    private int[] getDataFromBufferedImage(BufferedImage bufferedImage){
        int[] arr = new int[bufferedImage.getHeight()*bufferedImage.getWidth()];
        for (int i = 0; i < bufferedImage.getHeight(); i++){
            for (int j = 0; j < bufferedImage.getWidth(); j++) {
                arr[j + i*bufferedImage.getWidth()] = bufferedImage.getRGB(j, i);
            }
        }
        return arr;
    }

    public String getAsEncodedString (){
        return Base64.getEncoder().encodeToString(this.byteData);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return x == image.x && y == image.y && width == image.width && height == image.height && equalsArrays(byteData, image.byteData);
    }

    private boolean equalsArrays(byte[] a, byte[] b){
        boolean isEquals = true;
        for (int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                isEquals = false;
                break;
            }
        }
        return isEquals;
    }

    @Override
    public String toString() {
        return "Image{" +
                ", x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", height=" + height +
                ", data=" + Arrays.toString(byteData) +
                '}';
    }
}
