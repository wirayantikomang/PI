/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.lucene.analysis.id.IndonesianStemmer;

/**
 *
 * @author Lenovo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        invertedIndex cobaList;
        
        cobaList = new invertedIndex();
         
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Masukkan Kata 1: " );
        String kata1 = sc.nextLine();
        System.out.println("Masukkan Kata 2: " );
        String kata2 = sc.nextLine();
                
//        cobaList.Intersect(kata1, kata2);
        
        cobaList.add("dia", "doc1");
        cobaList.add("dan", "doc3");
        cobaList.add("kamu", "doc2");
        cobaList.add("pada", "doc2");
        cobaList.add("hari", "doc1");
        try {
        
            System.out.println(cobaList.Intersect(kata1,kata2).toString());
        }catch(Exception ex){
            System.out.println("Kata Tidak Ditemukan");
        }
        
        

//
//        System.out.println(cobaList);
//        System.out.println("");
//        cobaList.searchTerm("pada");
        
    }

}
