package cn.com.beila.code.deflater;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.Delayed;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * @author wanbeila
 * @date 2021-08-23-11:31
 * @desc 字符串压缩
 */
public class DeflaterMain {

    public static void main(String[] args) throws IOException {
        String src = "12345678901234567890123456789012345678901234567890";
        String base64 = new String(Base64.getEncoder().encode(src.getBytes(StandardCharsets.UTF_8)));
        System.out.println(base64);
        byte[] encode = encode(base64.getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(encode));
        System.out.println(new String(decode(encode)));
    }

    public static byte[] encode(byte[] src) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setInput(src);
        deflater.finish();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytesOut = new byte[1024];
        int len = 0;
        try {
            while (!deflater.finished()) {
                // 将压缩后的内容输出到字节流
                len = deflater.deflate(bytesOut);
                byteArrayOutputStream.write(bytesOut, 0, len);
            }
            deflater.end();
        } finally {
            byteArrayOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] decode(byte[] src) throws IOException {
        Inflater inflater = new Inflater();
        inflater.setInput(src);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytesOut = new byte[1024];
        int len = 0;
        try {
            while (!inflater.finished()) {
                // 将压缩后的内容输出到字节流
                len = inflater.inflate(bytesOut);
                if (len == 0) {
                    break;
                }
                byteArrayOutputStream.write(bytesOut, 0, len);
            }
            inflater.end();
        } catch (DataFormatException e) {
            e.printStackTrace();
        } finally {
            byteArrayOutputStream.close();
        }
        return byteArrayOutputStream.toByteArray();
    }

}
