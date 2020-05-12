/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notwist;

import rombo.crypt.CrypterImplementation;

//import emily.notwist.master_gui;


public class Main {

    
    public static void main(String[] args) {
    	
    	CrypterImplementation temp = new CrypterImplementation();
    	String s = "Prova di testo 1";
    	String d = "prova";
    	
    	System.out.println("Testo orginale==>"+s);
    	System.out.println("Testo criptato==>"+temp.Crypt(s));
    	System.out.println("Testo decriptato==>"+temp.Decrypt(temp.Crypt(s)));
    	System.out.println("Testo orginale==>"+d);
    	System.out.println("Testo criptato==>"+temp.Crypt(d));
    	System.out.println("Testo decriptato==>"+temp.Decrypt(temp.Crypt(d)));
    
    }
    
}

