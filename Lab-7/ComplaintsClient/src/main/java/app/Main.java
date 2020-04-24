/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author wojtek
 */
public class Main {

    public static void main(String args[]) {
        Client client = ClientBuilder.newClient();
        String count = client.target("http://localhost:43361/Complaints/"
                        + "resources/complaints/count")
                        .request(MediaType.TEXT_PLAIN)
                        .get(String.class);

        System.out.println("Count: " + count);
        
        // A
        List<Complaint> resultA = client.target("http://localhost:43361/Complaints/"+"resources/complaints").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Complaint>>(){});

        System.out.println("A: " + resultA);
        
        // B
        Complaint resultB2 = client.target("http://localhost:43361/Complaints/"+"resources/complaints").path("1").request(MediaType.APPLICATION_JSON).get(Complaint.class);

        
        System.out.println("B: " + resultB2);
        
        // C
        resultB2.setStatus("closed");
        Response response = client.target("http://localhost:43361/Complaints/"+"resources/complaints").path("1").request(MediaType.APPLICATION_JSON).put(Entity.entity(resultB2, MediaType.APPLICATION_JSON));

        System.out.println("C: " + response.getStatus());
        
        // D
        List<Complaint> resultD = client.target("http://localhost:43361/Complaints/"+"resources/complaints?status=open").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Complaint>>(){});

        System.out.println("D: " + resultD);
        
        client.close();
    }
}
