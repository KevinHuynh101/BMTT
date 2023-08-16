/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author thanh
 */
public class RSA {
        int primeSize ;
    BigInteger p,q;
    BigInteger N, E,D;
    BigInteger r;
    
    public RSA()
    {
        
    }
    
    public RSA( int primeSize )
    {  
	this.primeSize = primeSize ;
	generatePrimeNumbers() ;
	generatePublicPrivateKeys() ;
    }

    private void generatePrimeNumbers() 
    {
        p = new BigInteger( primeSize, 10, new Random()) ; 
	do
	{
	    q = new BigInteger( primeSize, 10, new Random()) ;
	}
	while( q.compareTo( p ) == 0 ) ;
    }

    private void generatePublicPrivateKeys() {
        N = p.multiply(q);
	r = p.subtract( BigInteger.valueOf( 1 ) ) ;
	r = r.multiply( q.subtract( BigInteger.valueOf( 1 ) ) ) ;
	do
        {
	E = new BigInteger( 2 * primeSize, new Random() ) ;
	}
	while( ( E.compareTo( r ) != -1 ) || ( E.gcd( r ).compareTo( BigInteger.valueOf( 1 ) ) != 0 ) ) ;
		D = E.modInverse( r ) ;
    }
    public BigInteger[] encrypt( String message )
    {
        int i ;
        byte[] temp = new byte[1] ;
	byte[] digits = message.getBytes() ;
	BigInteger[] bigdigits = new BigInteger[digits.length] ;
	for( i = 0 ; i < bigdigits.length ; i++ )
	{
            temp[0] = digits[i] ;
            bigdigits[i] = new BigInteger( temp ) ;
	}
        BigInteger[] encrypted = new BigInteger[bigdigits.length] ;
        for( i = 0 ; i < bigdigits.length ; i++ )
        {
            encrypted[i] = bigdigits[i].modPow( E, N ) ;
        }	
	return( encrypted ) ;
    }


    public BigInteger[] encrypt( String message,BigInteger userD,BigInteger userN)
    {
	int i ;
	byte[] temp = new byte[1] ;
        byte[] digits = message.getBytes() ;
        BigInteger[] bigdigits = new BigInteger[digits.length] ;
        for( i = 0 ; i < bigdigits.length ; i++ )
        {
            temp[0] = digits[i] ;
            bigdigits[i] = new BigInteger( temp ) ;
	}
        BigInteger[] encrypted = new BigInteger[bigdigits.length] ;
        for( i = 0 ; i < bigdigits.length ; i++ )
        {
            encrypted[i] = bigdigits[i].modPow( userD, userN ) ;
        }
        return( encrypted ) ;
    }
    
    public String decrypt( BigInteger[] encrypted,BigInteger D,BigInteger N )
    {
	int i ;
        BigInteger[] decrypted = new BigInteger[encrypted.length] ;
	for( i = 0 ; i < decrypted.length ; i++ )
        {
            decrypted[i] = encrypted[i].modPow( D, N ) ;
        }
	char[] charArray = new char[decrypted.length] ;
	for( i = 0 ; i < charArray.length ; i++ )
        {
            charArray[i] = (char) ( decrypted[i].intValue() ) ;
        }		
	return( new String( charArray ) ) ;
    }
    public BigInteger getp()
	{
		return( p ) ;
	}

    public BigInteger getq()
	{
		return( q ) ;
	}
    public BigInteger getr()
	{
		return( r ) ;
	}
    public BigInteger getN()
	{
		return( N ) ;
	}
    public BigInteger getE()
	{
		return( E ) ;
	}
    public BigInteger getD()
	{
		return( D) ;
	}
    
    public static void main( String[] args ) throws IOException
	{
		int primeSize =8;
		RSA rsa = new RSA( primeSize ) ;

		System.out.println( "Key Size: [" + primeSize + "]" );
		System.out.println( "" ) ;

		System.out.println( "Generated prime numbers p and q" );
		System.out.println( "p: [" + rsa.getp().toString( 16 ).toUpperCase() + "]" );
		System.out.println( "q: [" + rsa.getq().toString( 16 ).toUpperCase() + "]" );
		System.out.println( "" ) ;

		System.out.println( "The public key is the pair (N, E) which will be published." ) ;
		System.out.println( "N: [" + rsa.getN().toString( 16 ).toUpperCase() + "]" ) ;
		System.out.println( "E: [" + rsa.getE().toString( 16 ).toUpperCase() + "]" ) ;
		System.out.println( "" ) ;

		System.out.println( "The private key is the pair (N, D) which will be kept private." ) ;
		System.out.println( "N: [" + rsa.getN().toString( 16 ).toUpperCase() + "]" ) ;
		System.out.println( "D: [" + rsa.getD().toString( 16 ).toUpperCase() + "]" ) ;
		System.out.println( "" ) ;

		System.out.println( "Please enter message (plaintext):" ) ;
		String plaintext = ( new BufferedReader( new InputStreamReader( System.in ) ) ).readLine() ;
		System.out.println( "" ) ;

		BigInteger[] ciphertext = rsa.encrypt( plaintext ) ;

		System.out.print( "Ciphertext: [" ) ;
		for( int i = 0 ; i < ciphertext.length ; i++ )
		{
			System.out.print( ciphertext[i].toString( 16 ).toUpperCase() ) ;

			if( i != ciphertext.length - 1 )
				System.out.print( " " ) ;
		}
		System.out.println( "]" ) ;
		System.out.println( "" ) ;

		RSA rsa1 = new RSA(8);

		String recoveredPlaintext = rsa1.decrypt( ciphertext ,rsa.getD(),rsa.getN()) ;

		System.out.println( "Recovered plaintext: [" + recoveredPlaintext + "]" ) ;
            
           
            
            
	}
}
