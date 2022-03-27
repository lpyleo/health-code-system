package com.code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class QuickMarkUtil {
    //生成二维码时的编码表
    private static final String encode = "utf-8";
    //二维码的图片格式
    private static final String formatImg = "JPG";
    //二维码的宽与高
    private static final int quickMarkSize = 300;

    /**
     * 生成二维码
     * @param content   二维码内容
     * @param rgbColor  二维码颜色
     * @throws Exception    主要是IO异常、溢出异常
     */
    public static BufferedImage buildQuickMarkImage(String content, Integer rgbColor) throws Exception {
        //定义集合，存放与二维码有关联的部分数据参数
        HashMap<EncodeHintType, Object> hintsMap = new HashMap<>();
        hintsMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hintsMap.put(EncodeHintType.CHARACTER_SET, encode);
        hintsMap.put(EncodeHintType.MARGIN, 0);
        //使用Google的二维码工具类来生成二维码
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, quickMarkSize, quickMarkSize, hintsMap);
        //把二维码画到图片缓冲区中，理解成画板
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //定义二维码颜色
        if (rgbColor == null) {
            rgbColor = 0x00000;
        }
        //开始画二维码矩阵
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? rgbColor : 0xFFFFFFFF);
            }
        }
        return bufferedImage;
    }

    /**
     * 图片写到本地
     * @param path  保存路径
     * @param image 图片内容
     * @throws IOException  Io异常
     */
    public static void writeToLocal(String path,BufferedImage image) throws IOException {
        File file = new File(path);
        // 当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
        ImageIO.write(image, formatImg, new File(path));
    }
}

