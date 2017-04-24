/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author toni
 */
public class AdminModel {
    private int id;
    private String username;
    private String pass;
    private int number;
    private int p_Number;
    private int t_Number;
    private int r_number;

    public AdminModel(int id, String username, String pass, int number, int p_Number,int t_Number,int r_Number) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.number = number;
        this.p_Number = p_Number;
        this.t_Number = t_Number;
        this.r_number = r_Number;
    }
    
    
    public int getP_Number() {
        return p_Number;
    }

    public void setP_Number(int p_Number) {
        this.p_Number = p_Number;
    }

    public int getT_Number() {
        return t_Number;
    }

    public void setT_Number(int t_Number) {
        this.t_Number = t_Number;
    }

    public int getR_number() {
        return r_number;
    }

    public void setR_number(int r_number) {
        this.r_number = r_number;
    }
    

    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
