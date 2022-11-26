/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import org.apache.lucene.analysis.id.IndonesianStemmer;

/**
 *
 * @author ASUS
 */
public class PI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         IndonesianStemmer stemmer = new IndonesianStemmer();
        
        String term = "beruang";
        char[] chars = term.toCharArray();
        int len = stemmer.stem(chars, chars.length, true);
        String stem = new String(chars, 0, len);
        System.out.println(term + "---" + stem);
    }
    }
    

