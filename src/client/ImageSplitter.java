package client;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageSplitter {

	public static List<BufferedImage> splitImage(String filePath, int rows, int cols) {
	    try {
	        File file = new File(filePath);
	        System.out.println("Trying to read file from path: " + file.getAbsolutePath());

            BufferedImage image = ImageIO.read(new File(filePath));
            int tileWidth = image.getWidth() / cols;
            int tileHeight = image.getHeight() / rows;

            List<BufferedImage> tiles = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    BufferedImage tile = image.getSubimage(
                        j * tileWidth, 
                        i * tileHeight, 
                        tileWidth, 
                        tileHeight
                    );
                    tiles.add(tile);
                }
            }
            return tiles;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
