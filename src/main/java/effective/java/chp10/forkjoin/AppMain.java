package effective.java.chp10.forkjoin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class AppMain {

    public static void main(String [] args) throws IOException {
        String srcName = "/home/abegley/techbites/effective_java/src/main/resources/Screenshot.png";
        File srcFile = new File(srcName);
        BufferedImage image = ImageIO.read(srcFile);

        System.out.println("Source image: " + srcName);

        BufferedImage blurredImage = blur(image);

        String dstName = "blurred-Screenshot.png";
        File dstFile = new File(dstName);
        ImageIO.write(blurredImage, "jpg", dstFile);

        System.out.println("Output image: " + dstName);
    }

    private static BufferedImage blur(BufferedImage srcImage) {
        int w = srcImage.getWidth();
        int h = srcImage.getHeight();

        int[] src = srcImage.getRGB(0,0,w,h,null,0,w);
        int[] dst = new int[src.length];

        System.out.println("Array size is " + src.length);
        System.out.println("Threshold is " + ForkBlur.sThreshold);

        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(Integer.toString(processors) + " processor"
                + (processors != 1 ? "s are " : " is ") + "available");

        ForkBlur fb = new ForkBlur(src, 0, src.length, dst);

        ForkJoinPool pool = new ForkJoinPool();

        long startTime = System.nanoTime();
        pool.invoke(fb);
        long endTime = System.nanoTime();

        System.out.println("Time taken to blur image: " + (endTime - startTime)/1.0e09);

        BufferedImage dstImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        dstImage.setRGB(0,0,w,h,dst,0,w);

        return dstImage;
    }
}
