/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;



import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 * @author chiming
 */
public class PdfHandler {
    public static byte convert(byte[] arr)[] throws IOException {

        // TODO Auto-generated method stub

        ByteBuffer buf = ByteBuffer.wrap(arr);
        ByteArrayInputStream bis = new ByteArrayInputStream(arr);
        
        PDDocument document = PDDocument.load(bis);
        List<PDPage> pages= document.getDocumentCatalog().getAllPages();

        if(pages.size()>0)
        {
            PDPage page=pages.get(0);
            BufferedImage bufimage = page.convertToImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufimage, "jpg", baos);
            baos.flush();
            baos.close();
            return baos.toByteArray();
        }
        else
        { return null; }
    }

}

