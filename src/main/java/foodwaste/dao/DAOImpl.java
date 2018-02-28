/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.dao;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import foodwaste.domain.Areofinterest;
import foodwaste.domain.Compgroup;
import foodwaste.domain.Component;
import foodwaste.domain.ComponentList;
import foodwaste.domain.Compsubgroup;
import foodwaste.domain.Country;
import foodwaste.domain.EditUser;
import foodwaste.domain.Food;
import foodwaste.domain.Institution;
import foodwaste.domain.Institutiontype;
import foodwaste.domain.Matrix;
import foodwaste.domain.Reference;
import foodwaste.domain.Referencetype;
import foodwaste.domain.Unit;
import foodwaste.domain.User;
import foodwaste.domain.UserPostClass;
import foodwaste.domain.UserRole;
import foodwaste.domain.Wastestream;
import foodwaste.domain.WastestreamFood;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvalueResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import foodwaste.domain.WastreamPOSTClass;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvaluePostAdd;
/**
 *
 * @author Tome
 */
public class DAOImpl implements DAO{
    
    public Client client = Client.create();
    
    @Override
    public List<Food> getAllFoods(){
         WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/food");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Food> myObjects=new ArrayList<Food>();
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Food[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
    }
    
    @Override
    public List<Wastestream> getAllWasteStreams(){
          WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/wastestream");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

	        ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Wastestream> myObjects=new ArrayList<Wastestream>();;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Wastestream[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
    }
    
    @Override
    public List<Component> getAllComponenets(){
            WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/component");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Component> myObjects=new ArrayList<Component>();;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Component[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
    }
    
    @Override
     public List<Compsubgroup> getAllCompsubgroups(){
         WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/compsubgroup");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Compsubgroup> myObjects=new ArrayList<Compsubgroup>();;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Compsubgroup[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
     }
    
    @Override
      public List<Compgroup> getAllCompgroups(){
          WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/compgroup");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Compgroup> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Compgroup[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
          
      }
      
    @Override
       public List<Reference> getAllReferences(){
           WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/reference");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Reference> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Reference[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
       }
       
    @Override
       public List<Unit> getAllUnits(){
           WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/unit");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Unit> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Unit[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
       }
       
       @Override
       public List<Matrix> getAllMatrix(){
           WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/matrix");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Matrix> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Matrix[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
       }
       
       @Override
       public List<Referencetype> getAllReferencetype(){
           WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/referencetype");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Referencetype> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Referencetype[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
       }
       
    @Override
         public List<User> getallUser(){
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/user");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<User> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, User[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
         }
         
    @Override
         public List<WsvalueResult> getAllWsValues(){
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/wastevalue");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<WsvalueResult> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, WsvalueResult[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
         }
         
    @Override
         public String login(User u){
              ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/login");
              
              String input=null;
        try {
            input = mapper.writeValueAsString(u);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

             
                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);
               
                String output = response.getEntity(String.class);

		               
               
                    
              
           
        
              return output;
         }
         
    @Override
         public String register(UserPostClass u){
            ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/register");
              
              String input=null;
        try {
            input = mapper.writeValueAsString(u);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

             
                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);
               
                String output = response.getEntity(String.class);

		               
               
                    
              
           
        
              return output;  
         }
    @Override
         public List<Areofinterest> getAllAreofinterest(){
             WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/areaofinterest");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Areofinterest> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Areofinterest[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
             
         }
    @Override
    public List<Institution> getAllInstitutions(){
        WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/institution");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Institution> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Institution[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
             
    }
    @Override
      public List<Institutiontype> getAllIstitutiontypes(){
          WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/institutiontype");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Institutiontype> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Institutiontype[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
      }
    @Override
      public List<Country> getAllCountries(){
          WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/country");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<Country> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, Country[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
      }
      
       @Override
      public List<ComponentList> getcomponentList(){
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/componentList");
               ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
               String output = response.getEntity(String.class);
               ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<ComponentList> myObjects=null;

        try {
            myObjects = Arrays.asList(mapper.readValue(output, ComponentList[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
              return myObjects; 
          
      }

      @Override
      public String addFood(Food f){
           ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/addFood");
              
              String input=null;
        try {
            input = mapper.writeValueAsString(f);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);   
                String output = response.getEntity(String.class);
              return output;  
      }

     @Override
      public String addWastestream(WastreamPOSTClass w){
           ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/addWastestream");  
              String input=null;
        try {
            input = mapper.writeValueAsString(w);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input); 
                String output = response.getEntity(String.class);
        
              return output;  
      }
      
      @Override
      public String editWastestream(WastreamPOSTClass w){
           ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/editWastestream");
              
              String input=null;
        try {
            input = mapper.writeValueAsString(w);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);              
                String output = response.getEntity(String.class);
        
              return output;  
      }
      
      @Override
      public String editWsvalue(WsvaluePostClass w){
          ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/editWastevalue");
              
              String input=null;
        try {
            input = mapper.writeValueAsString(w);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);              
                String output = response.getEntity(String.class);

              return output;  
      }
      
      public String addWsvalue(WsvaluePostAdd w){
          ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/addWastevalue");  
              String input=null;
        try {
            input = mapper.writeValueAsString(w);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
   
                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);         
                String output = response.getEntity(String.class);
                
              return output;  
          
      }
      
      
      public String deleteWsvalue(WsvaluePostClass  w){
          ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/deleteWastevalue");             
              String input=null;
        try {
            input = mapper.writeValueAsString(w);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);          
                String output = response.getEntity(String.class);
        
              return output;  
          
      }

     
@Override
      public List<UserRole> getUserRole(){
          WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/userrole");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

		               
                ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<UserRole> myObjects=null;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, UserRole[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
      }
      
      
       @Override
    public List<WastestreamFood> getAllWasteStreamsFood(){
          WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/wastestreamfood");
                ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
                String output = response.getEntity(String.class);

	        ObjectMapper mapper = new ObjectMapper();
                    
              
                 List<WastestreamFood> myObjects=new ArrayList<WastestreamFood>();;
        try {
            myObjects = Arrays.asList(mapper.readValue(output, WastestreamFood[].class));
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return myObjects;
    }
@Override
         public String ChangePassword(User u){
            ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/changePassword");
              
              String input=null;
        try {
            input = mapper.writeValueAsString(u);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

             
                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);
               
                String output = response.getEntity(String.class);

		               
               
                    
              
           
        
              return output;  
         }
          @Override
      public String editUser(EditUser u){
           ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/editUser");
              
              String input=null;
        try {
            input = mapper.writeValueAsString(u);
        } catch (IOException ex) {
            Logger.getLogger(DAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

             
                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);
               
                String output = response.getEntity(String.class);

		               
               
                    
              
           
        
              return output;  
      }
      
    @Override
      public String activeUser(String token){
          ObjectMapper mapper = new ObjectMapper();
              WebResource webResource = client.resource("http://localhost:8080/FoodWaste/service/activeUser");
              
              String input=null;
              input = token;

             
                ClientResponse response = response = webResource.type("application/json").post(ClientResponse.class, input);
               
                String output = response.getEntity(String.class);

		               
               
                    
              
           
        
              return output;  
      }



}
