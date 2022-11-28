package EncDecAlgo;

import javax.crypto.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES {
    public static void main(String[] args) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\Surmo\\Downloads\\Enc1.mp4"));
        File outfile = new File("C:\\Users\\Surmo\\Downloads\\Enc3.mp4");
        int read;
        if (!outfile.exists())
            outfile.createNewFile();
        File decfile = new File("C:\\Users\\Surmo\\Downloads\\Enc4.mp4");
        if (!decfile.exists())
            decfile.createNewFile();
        FileOutputStream fos = new FileOutputStream(outfile);
        FileInputStream encfis = new FileInputStream(outfile);
        FileOutputStream decfos = new FileOutputStream(decfile);
        Cipher encipher = Cipher.getInstance("AES");
        Cipher decipher = Cipher.getInstance("AES");
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        //byte key[] = {0x00,0x32,0x22,0x11,0x00,0x00,0x00,0x00,0x00,0x23,0x00,0x00,0x00,0x00,0x00,0x00,0x00};
        SecretKey skey = kgen.generateKey();
        //Lgo
        encipher.init(Cipher.ENCRYPT_MODE, skey);
        CipherInputStream cis = new CipherInputStream(fis, encipher);
        decipher.init(Cipher.DECRYPT_MODE, skey);
        CipherOutputStream cos = new CipherOutputStream(decfos, decipher);
        while ((read = cis.read()) != -1) {
            fos.write((char) read);
            fos.flush();
        }
        fos.close();
        while ((read = encfis.read()) != -1) {
            cos.write(read);
            cos.flush();
        }
        cos.close();
    }
}
