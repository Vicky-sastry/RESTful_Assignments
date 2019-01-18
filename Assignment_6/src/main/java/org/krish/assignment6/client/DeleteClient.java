package org.krish.assignment6.client;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

import org.krish.assignment6.model.Employee;
 
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
 
public class DeleteClient {
 
  public static void main(String[] args) {
 
      ClientConfig clientConfig = new DefaultClientConfig();
 
      // Create Client based on Config
      Client client = Client.create(clientConfig);
 
      WebResource webResource = client.resource("http://localhost:8080/Assignment_6/rest/employees/E05");
 
      Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
              .header("content-type", MediaType.APPLICATION_JSON);
 
      ClientResponse response = builder.delete(ClientResponse.class);
 
      // Status 200 is successful.
      if (response.getStatus() != 204) {
          System.out.println("Failed with HTTP Error code: " + response.getStatus());
         String error= response.getEntity(String.class);
         System.out.println("Error: "+error);
          return;
      }
 
      System.out.println("Deleted Successfully");
 
      
 
  }
 
}
