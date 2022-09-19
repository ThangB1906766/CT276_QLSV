/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseHelper;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author admin
 */
/*
    Ngày 23/06/2022
    Chức năng: lấy ảnh, hiển thị, lưu vào csdl
 */
public class AnhDaiDien {

    public static Image ThayDoiKichThuoc(Image anhGoc, int chieuRong, int chieuCao) {
        Image resultImage = anhGoc.getScaledInstance(chieuRong, chieuCao, Image.SCALE_SMOOTH);
        return resultImage;
    }

    /*
        Chức năng: chuyển hình ảnh về mảng các byte[]
     */
    public static byte[] toByteArray(Image img, String type) throws IOException {
        BufferedImage bImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bImage.createGraphics();
        g.drawImage(img, 0, 0, null);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bImage, type, baos);
        byte[] imageInByte = baos.toByteArray();

        return imageInByte;
    }

    /*
        Chức năng: chuyển mảng các byte[] thành đối tượng image trên lable giao diện
     */
    public static Image TaoAnhFormByteArray(byte[] data, String type) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        BufferedImage bImage2 = ImageIO.read(bais);

        Image img = bImage2.getScaledInstance(bImage2.getWidth(), bImage2.getHeight(), Image.SCALE_SMOOTH);
        return img;
    }
}
