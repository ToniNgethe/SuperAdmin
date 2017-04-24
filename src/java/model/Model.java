/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author toni
 */
public class Model {
    private int id;
    private String fName;
    private String sName;
    private String pass;
    private String docID;
    private Date dob;
    private Date dateCreated;
    
    public Model(){
        
    }

    public Model(int id, String fName, String sName, String pass, String docID, Date dob) {
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.pass = pass;
        this.docID = docID;
        this.dob = dob;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
      
}
