/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Random;

/**
 *
 * @author wojtek
 */
public class Student {
    
    private String firstName;
    private String lastName;
    private double avg;
    
    public Student(String firstName, String lastName, double avg) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avg = avg;
    }
    
    public static Student randomStudent() {
        String[] firstNames = {
            "Janusz",
            "Mirosław",
            "Brian",
            "Jan",
            "Tadeusz",
            "Michał",
            "Tomasz",
            "Mikołaj"
        };
        String[] lastNames = {
            "Kowalski",
            "Kalski",
            "Kubicki",
            "Zielewicz",
            "Mikołajczak",
            "Zajączkowski",
            "Miły",
            "Pilarski",
            "Pudlicki",
            "Łopatowski"
        };
        return new Student(firstNames[new Random().nextInt(firstNames.length)], lastNames[new Random().nextInt(lastNames.length)], Math.random()*3.0 + 2.0);
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the avg
     */
    public double getAvg() {
        return avg;
    }

    /**
     * @param avg the avg to set
     */
    public void setAvg(double avg) {
        this.avg = avg;
    }
    
    
    
}
