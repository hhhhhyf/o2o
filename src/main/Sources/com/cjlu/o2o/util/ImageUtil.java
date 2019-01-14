package com.cjlu.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) throws IOException {

        String realFileName = getRandomFileName();
        String extenstion = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extenstion;
        File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
        try{
            Thumbnails.of(thumbnail.getInputStream()).size(200,200)
.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        }catch (IOException e){
            throw new RuntimeException("创建缩略图失败：" + e.toString());
    }
        return relativeAddr;
    }

    private static void makeDirPath(String targetAddr){
        String realFileParentPath = PathUtil.getImgBasePath()+targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }


    }
    private static String getFileExtension(CommonsMultipartFile cFile) {
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    private static String getRandomFileName() {
        int rannum = r.nextInt(89999) + 100000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    public static void main(String[] args) throws IOException {

        Thumbnails.of(new File("C:/Users/hyf/Pictures/xiaohuangren.jpg"))
                .size(200, 200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                .outputQuality(0.8f).toFile("C:/Users/hyf/Pictures/xiaohuangren6.jpg");
    }
}
