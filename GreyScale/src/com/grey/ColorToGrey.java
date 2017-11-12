package com.grey;

import edu.duke.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ColorToGrey{
    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());

            int average = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue());

            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }

        return outImage;
    }

    public static void main(String[] args){
        ImageResource inImage = new ImageResource("I:\\Pictures\\pic.jpg");
        ImageResource gray = makeGray(inImage);
        gray.draw();
    }
}
