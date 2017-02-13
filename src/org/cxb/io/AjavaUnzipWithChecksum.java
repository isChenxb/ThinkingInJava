package org.cxb.io;
import java.io.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.CheckedInputStream;
import java.util.zip.Adler32;

public class AjavaUnzipWithChecksum {
    public static void main(String[] args) {
        String zipname = "test.zip";

        try {
            FileInputStream fis = new FileInputStream(zipname);

            //使用Adler32算法创建CheckedInputStream校验输出流
            CheckedInputStream checksum = new CheckedInputStream(fis, new Adler32());
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(checksum));
            ZipEntry entry;

            //解压ajavachecksum.zip
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("解压中....: " + entry.getName());

                int size;
                byte[] buffer = new byte[2048];

                FileOutputStream fos = new FileOutputStream(entry.getName());
                BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length);

                while ((size = zis.read(buffer, 0, buffer.length)) != -1) {
                    bos.write(buffer, 0, size);
                }
                bos.flush();
                bos.close();
            }

            zis.close();
            fis.close();

            System.out.println("校验码 = " + checksum.getChecksum().getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
