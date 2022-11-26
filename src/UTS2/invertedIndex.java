/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS2;

import static java.lang.Math.E;
import java.util.LinkedList;
import java.util.ListIterator;
import java.io.*;

/**
 *
 * @author Lenovo
 */
public class invertedIndex<E> extends LinkedList<E> {
    
    
    private LinkedListOrderedUnique<Term> termList;

    public invertedIndex() {
        termList = new LinkedListOrderedUnique<Term>();
    }

    public LinkedListOrderedUnique getTermList() {
        return termList;
    }

    public void add(String pTerm, String pDocument) {

        // cari pTerm dalam Term list
        Term vTerm = termList.get(new Term(pTerm));
        // Jika term belum ada
        if (vTerm == null) {
            // Buat simpul Term list
            Term oTerm = new Term(pTerm);
            // Buat document list
            oTerm.documentList = new LinkedListOrderedUnique<Document>();
            // tambahkan simpul document ke documentList dari oTerm
            oTerm.getDocumentList().addSort(new Document(pDocument));
            // Tambahkan term object oTerm baru pertama ke termList;
            termList.addSort(oTerm);
        } // Jika term sudah ada
        else {
            // tambahkan simpul document ke documentList dari pTerm
            vTerm.getDocumentList().addSort(new Document(pDocument));
        }
    }

    @Override
    public String toString(){
        return termList.toString();
    }
    
        public LinkedList search(String data){
            LinkedList hasil = new LinkedList();
            Term kata = termList.get(new Term(data));
            
            for (int i = 0; i < kata.getDocumentList().size(); i++) {
                hasil.add(kata.getDocumentList().get(i).getDocument());
            }
            return hasil;
            
    }
        public LinkedList Intersect(String k1, String k2){
            Document doc = new Document();
            ListIterator list1 = this.listIterator();
            ListIterator list2 = this.listIterator();
            
             LinkedList hasil = new LinkedList();
             LinkedList kata1 = search(k1);
             LinkedList kata2 = search (k2);
             
             while (list1.hasNext() && list2.hasNext()){
                 String buat1 = (String)list1.next();
                 String buat2 = (String)list2.next();
                 if (buat1.compareTo(buat2)> 0){
                     hasil.add(buat1);
                 }else if(buat1.compareTo(buat2)== 0){
                     list1.previous();
                     
                 }else {
                     list2.previous();
                 } 
                     
             }
        return hasil;
            
        }
}