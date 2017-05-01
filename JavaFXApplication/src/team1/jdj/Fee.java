/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.jdj;

/**
 *
 * @author dongju
 */
public class Fee {

    private String month;
    private String howManyUse;
    private String fee;
    private String check;

    public Fee(String month, String howManyUse, String fee, String check) {
        this.month = month;
        this.howManyUse = howManyUse;
        this.fee = fee;
        this.check = check;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getHowManyUse() {
        return howManyUse;
    }

    public void setHowManyUse(String howManyUse) {
        this.howManyUse = howManyUse;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
    
    
}
