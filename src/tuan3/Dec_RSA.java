/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tuan3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;

/**
 *
 * @author thanh
 */
public class Dec_RSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        BufferedReader in=
                new BufferedReader(new InputStreamReader
                (new FileInputStream("D:\\Enc_RSA.dat")));
        String ctext=in.readLine();
        BigInteger c= new BigInteger(ctext);
        FileInputStream f= new FileInputStream("D:\\Skey_RSA_priv.dat");
        ObjectInputStream b =new ObjectInputStream(f);
        RSAPrivateKey prk = (RSAPrivateKey)b.readObject();
        BigInteger d=prk.getPrivateExponent();
        BigInteger n=prk.getModulus();
        System.out.println("d= " +d);
        System.out.println("n= " +n);
        BigInteger m=c.modPow(d,n);
        System.out.println("m= " +m);
        byte[] mt=m.toByteArray();
        System.out.println("Plantext is");
        for(int i=0;i<mt.length;i++)
            System.out.print((char) mt[i]);
    }
    
}
