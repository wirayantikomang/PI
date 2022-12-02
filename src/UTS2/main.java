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
        
        invertedIndex coba = new invertedIndex();
        
        String path = "C:\\Users\\ASUS\\Downloads\\Koleksi\\Koleksi";
        Scanner sc;
        String directory[];
        
        File name = new File(path);
        
        if (name.exists()) {
            directory = name.list();
            
            for (String directoryName : directory) {
                
                try {
                    sc = new Scanner(new File(name.getAbsolutePath() + "\\" + directoryName));
                    
                    try {
                        while (sc.hasNext()) {
                            String sentence = sc.nextLine();
                            String[] tokens = sentence.split(" ");
                            for (String token : tokens) {
                                coba.add(token, directoryName);

//                                System.out.println(directoryName + " " + token);
                            }
                        }
                    } catch (NoSuchElementException elementException) {
                        System.err.println("File improperly formed");
                        sc.close();
                        System.exit(1);
                    } catch (IllegalStateException stateException) {
                        System.err.println("Error reading from file.");
                        System.exit(1);
                    }
                } catch (FileNotFoundException fileNotFoundException) {
                    System.err.println("Error reading from file.");
                    System.exit(1);
                }
                //System.out.println("");
            }
        } else {
            System.out.printf("%s %s", path, "does not exist");
        }
        System.out.println(coba.toString());
        
        System.out.println("");
        Scanner pd = new Scanner(System.in);
        System.out.print("Masukan kata 1: ");
        String kata1 = pd.nextLine();
        System.out.print("Masukan kata 2: ");
        String kata2 = pd.nextLine();
        
        try {
//            System.out.println(coba);
            System.out.println("Kata " + kata1 + " terdapat pada dokumen" + coba.search(kata1));
            System.out.println("Kata " + kata2 + " terdapat pada dokumen" + coba.search(kata2));
            System.out.println("Kata " + kata1 + " dan kata " + kata2 + " Terdapat pada dokumen " + coba.Intersect(kata1, kata2));
        } catch (NullPointerException e) {
            System.out.println("Kata " + kata1 + " tidak ditemukan pada dokumen");
        }
        
    }
    
}
//        invertedIndex cobaList;
//        
//        cobaList = new invertedIndex();
//         
//        Scanner sc = new Scanner(System.in);
//        
//        System.out.println("Masukkan Kata 1: " );
//        String kata1 = sc.nextLine();
//        System.out.println("Masukkan Kata 2: " );
//        String kata2 = sc.nextLine();
//                
////        cobaList.Intersect(kata1, kata2);
//        
//        cobaList.add("dia", "doc1");
//        cobaList.add("dan", "doc3");
//        cobaList.add("kamu", "doc2");
//        cobaList.add("pada", "doc2");
//        cobaList.add("hari", "doc1");
//        try {
//        
//            System.out.println(cobaList.Intersect(kata1,kata2).toString());
//        }catch(Exception ex){
//            System.out.println("Kata Tidak Ditemukan");
//        }
//        

//
//        System.out.println(cobaList);
//        System.out.println("");
//        cobaList.searchTerm("pada");

