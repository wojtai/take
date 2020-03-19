/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author wojtek
 */
@Named(value="backingBean")
@RequestScoped
public class BackingBean {
    
    private int v1;
    private int v2;
    
    private int result = 0;
    
    private Date date = new Date();
    
    public void sum(){
        this.result = v1 + v2;
        addMessage(String.valueOf(this.v1) + "+" + String.valueOf(this.v2) + "=" + String.valueOf(this.result));
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the v1
     */
    public int getV1() {
        return v1;
    }

    /**
     * @param v1 the v1 to set
     */
    public void setV1(int v1) {
        this.v1 = v1;
    }

    /**
     * @return the v2
     */
    public int getV2() {
        return v2;
    }

    /**
     * @param v2 the v2 to set
     */
    public void setV2(int v2) {
        this.v2 = v2;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
