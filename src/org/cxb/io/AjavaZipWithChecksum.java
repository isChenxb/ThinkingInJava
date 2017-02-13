package org.cxb.io;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Adler32;

public class AjavaZipWithChecksum {
    public static void main(String[] args) {
        try {
            String target = "ajavachecksum.zip";

            FileOutputStream fos = new FileOutputStream(target);

            //使用Adler32算法创建CheckedOutputStream校验输出流
            CheckedOutputStream checksum = new CheckedOutputStream(fos, new Adler32());
            ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(checksum));

            int size = 0;
            byte[] buffer = new byte[1024];

            //
            // Get all text files on the working folder.
            //通过FilenameFilter取得所有txt文件
//            File dir = new File(".");
//            String[] files = dir.list(new FilenameFilter() {
//                public boolean accept(File dir, String name) {
//                    if (name.endsWith(".txt")) {
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }
//            });
            String[] files = {
            		".\\src\\org\\cxb\\io\\TextFile.java", 
            		".\\src\\org\\cxb\\io\\ZipCompress.java"
            };
            
            //压缩成ajavachecksum.zip
            for (int i = 0; i < files.length; i++) {
                System.out.println("压缩中...: " + files[i]);

                FileInputStream fis = new FileInputStream(files[i]);
                BufferedInputStream bis = new BufferedInputStream(fis, buffer.length);

                ZipEntry zipEntry = new ZipEntry(new File(files[i]).getName());
                zos.putNextEntry(zipEntry);

                while ((size = fis.read(buffer, 0, buffer.length)) > 0) {
                    zos.write(buffer, 0, size);
                }

                zos.closeEntry();
                fis.close();
            }

            zos.close();

            System.out.println(" 校验码  : " + checksum.getChecksum().getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
