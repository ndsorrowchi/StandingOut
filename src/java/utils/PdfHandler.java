/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author chiming
 */
public class PdfHandler {
    public static byte convert(byte[] arr)[] throws IOException {
        // TODO Auto-generated method stub

        ByteBuffer buf = ByteBuffer.wrap(arr);
        PDFFile pdf = new PDFFile(buf);

        if(pdf.getNumPages()>0)
        {
            PDFPage page=pdf.getPage(0);
            Rectangle rect = new Rectangle(0, 0, (int) page.getBBox().getWidth(),
                (int) page.getBBox().getHeight());
            BufferedImage bufImage = new BufferedImage(rect.width, rect.height,
                         BufferedImage.TYPE_INT_RGB);
            Image image = page.getImage(rect.width, rect.height,rect,null,
                       true,                       //background white
                       true                        //block until drawing is done
            );
            Graphics2D bufImageGraphics = bufImage.createGraphics();
            bufImageGraphics.drawImage(image, 0, 0, null);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufImage, "jpg", baos);
            baos.flush();
            baos.close();
            return baos.toByteArray();
        }//    createImage(pdf.getPage(i), "c:\\PICTURE_"+i+".jpg");
        else
        { return null; }
    }

}
