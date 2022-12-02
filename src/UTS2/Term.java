/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS2;

import java.util.LinkedList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author basis28
 */
public class Term implements Comparable{
    protected String term;
    protected LinkedListOrderedUnique<Document> documentList;
    
    public Term(String inTerm){
        term = inTerm;
    }

    public Term() {
    }
    

    public String getTerm() {
        return term;
    }

    public LinkedListOrderedUnique<Document> getDocumentList() {
        return documentList;
    }

    public int compareTo(Object o) {
        return term.compareTo(((Term) o).term);
    }

    @Override
    public String toString(){
        String temp = term + " => ";
        temp = temp + documentList.toString()+"\n";
        return temp;
    }
   
}