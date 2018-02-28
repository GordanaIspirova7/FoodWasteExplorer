/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.service;

import foodwaste.dao.DAO;
import foodwaste.dao.DAOImpl;
import foodwaste.domain.Areofinterest;
import foodwaste.domain.Compgroup;
import foodwaste.domain.Component;
import foodwaste.domain.ComponentList;
import foodwaste.domain.Compsubgroup;
import foodwaste.domain.Country;
import foodwaste.domain.Food;
import foodwaste.domain.Institution;
import foodwaste.domain.Institutiontype;
import foodwaste.domain.Matrix;
import foodwaste.domain.Referencetype;
import foodwaste.domain.Unit;
import foodwaste.domain.User;
import foodwaste.domain.Role;
import foodwaste.domain.UserPostClass;
import foodwaste.domain.UserRole;
import foodwaste.domain.Wastestream;
import foodwaste.domain.WastestreamFood;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvalueResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import foodwaste.domain.WastreamPOSTClass;
import foodwaste.domain.Wsvalue;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvaluePostAdd;
/**
 *
 * @author Tome
 */
public class ServiceImpl implements Service {
     
    private DAOImpl dao= new DAOImpl();
    @Override
    public List<ComponentList> searchCompgroup(String compgroup)
    {
         
         List<ComponentList> list=dao.getcomponentList();
         List<ComponentList> result=new ArrayList<ComponentList>();
         Map<String, Integer> compgroupList=new HashMap<String, Integer>();
         for (ComponentList object:list)
         {
             if(object.getCompsubgroup().equals(compgroup))
                 result.add(object);
         }
         return result;
    }
    
        @Override
     public List<ComponentList> searchComponent(String component){
         List<ComponentList> list=dao.getcomponentList();
         List<Component> listC=dao.getAllComponenets();
         List<ComponentList> result=new ArrayList<ComponentList>();
         int compid=0;
         for(Component object:listC)
         {
             if(object.getFtc().equals(component))
             {
                 compid=object.getCompid();
             }
         }
         for (ComponentList object:list)
         {
             if(object.getCompid()==compid)
                 result.add(object);
         }
         return result;

     
    } 
     @Override
    public List<Wastestream> searchFood(String foodname){
        List<Wastestream> allWs=dao.getAllWasteStreams();
        List<WsvalueResult> allWsvalues=dao.getAllWsValues();
        List<Food> foodData=dao.getAllFoods();
        Map<String, Integer> foodList = new HashMap<String, Integer>();
         
    
      for(Food object : foodData){
          foodList.put(object.getFoodname(),object.getFoodid());
      }
      int foodid=foodList.get(foodname);
//        int foodid=0;
//        for(Food object:foodData)
//        {
//            if(object.getFoodname().equals(foodname))
//            {
//                foodid=object.getFoodid();
//            }
//        }
        List<Integer> result1= new ArrayList<Integer>();
          if(!allWsvalues.isEmpty()){
                    for(WsvalueResult object : allWsvalues){
                        if(object.getFoodid()==foodid){
                            result1.add(object.getWsid());
                        }
                    }
                }
         
          Set<Integer> hs = new HashSet<>();
          hs.addAll(result1);
          result1.clear();
          result1.addAll(hs);
       
          List<Wastestream> result=new ArrayList<Wastestream>();
          if(!result1.isEmpty()){
              for(Integer object:result1)
              {
                  for(Wastestream object1:allWs)
                     
                  if(object.equals(object1.getWsid()))
                      result.add(object1);
              }
          }
    
        
     return result;
     
    }    
    
    
     @Override
    public List<WastestreamFood> searchFood1(Integer foodid){
               List<WastestreamFood> allWs=dao.getAllWasteStreamsFood();

      List<WastestreamFood> result=new ArrayList<WastestreamFood>();
      for(WastestreamFood object:allWs)
      {
      if(object.getFoodid()==foodid)
          result.add(object);
      }
      
      return result;
    }
    
    
     @Override
      public String username(User u){
          String username=u.getName();
          return username;
      }
      
      
      @Override
      public User user(String email){
          User u=new User();
          List<User> users=dao.getallUser();
          for (User object:users)
          {
              if(object.getEmail().equals(email))
              {
                  u=object;
              }
          }
          return u;
      }
      
    
      @Override
    public List<WsvalueResult> searchWastestream(String wastestream){
        List<WsvalueResult> allWsvalues=dao.getAllWsValues();
//	    List<Wastestream> wastestreamData=dao.getAllWasteStreams();
//            Map<String, Integer> wastestreamList= new HashMap<String, Integer>();
//
//		for(Wastestream object : wastestreamData){
//          wastestreamList.put(object.getWastestream(),object.getWsid());
//      }
//      int Wsid=wastestreamList.get(wastestream);
       
        List<WsvalueResult> result= new ArrayList<WsvalueResult>();
          if(!allWsvalues.isEmpty()){
                    for(WsvalueResult object : allWsvalues){
                        if(object.getWastestream().equals(wastestream)){
                            result.add(object);
                        }
                    }
                }
        
     return result;
     
    }
    
    
    @Override
     public List<WsvalueResult> searchCompgroup(int compgroupid){
        List<WsvalueResult> allWsvalues=dao.getAllWsValues();
        
        List<WsvalueResult> result= new ArrayList<WsvalueResult>();
          if(!allWsvalues.isEmpty()){
                    for(WsvalueResult object : allWsvalues){
                        if(object.getCompgroupid()==compgroupid){
                            result.add(object);
                        }
                    }
                }
        
     return result;
     
    } 
//     
//    @Override
//    public List<WsvalueResult> searchWastestream(int wsid){
//        List<WsvalueResult> allWsvalues=dao.getAllWsValues();
//        
//        List<WsvalueResult> result= new ArrayList<WsvalueResult>();
//          if(!allWsvalues.isEmpty()){
//                    for(WsvalueResult object : allWsvalues){
//                        if(object.getWsid()==wsid){
//                            result.add(object);
//                        }
//                    }
//                }
//        
//     return result;
//     
//    }
    
//    @Override
//     public List<WsvalueResult> searchComponent(int compid){
//        List<WsvalueResult> allWsvalues=dao.getAllWsValues();
//        
//        List<WsvalueResult> result= new ArrayList<WsvalueResult>();
//          if(!allWsvalues.isEmpty()){
//                    for(WsvalueResult object : allWsvalues){
//                        if(object.getCompid()==compid){
//                            result.add(object);
//                        }
//                    }
//                }
//        
//     return result;
//     
//    } 
    
    @Override
     public List<WsvalueResult> searchCompsubgroup(int compsubgroupid){
        List<WsvalueResult> allWsvalues=dao.getAllWsValues();
        
        List<WsvalueResult> result= new ArrayList<WsvalueResult>();
          if(!allWsvalues.isEmpty()){
                    for(WsvalueResult object : allWsvalues){
                        if(object.getCompsubgroupid()==compsubgroupid){
                            result.add(object);
                        }
                    }
                }
        
     return result;
     
    } 
     
  
    @Override
      public List<Food> getDDFoods(){
          List<Food> allFoods = new ArrayList<Food>();  
          allFoods=dao.getAllFoods();
        
       
        
     return allFoods;
      }
      
      @Override
      public List<Wastestream> getDDWastestreams(){
          List<Wastestream> allWastestreams = new ArrayList<Wastestream>();  
          allWastestreams=dao.getAllWasteStreams();
        
       
        
     return allWastestreams;
      }
      
      @Override
      public List<Component> getDDComponents(){
          List<Component> allComponents = new ArrayList<Component>();  
          allComponents=dao.getAllComponenets();
        
       
        
          return allComponents;
      }
      
      @Override
      public List<Compsubgroup> getDDCompsubgroups(){
          List<Compsubgroup> allCompsubgroups = new ArrayList<Compsubgroup>();  
          allCompsubgroups=dao.getAllCompsubgroups();
        
       
        
          return allCompsubgroups;
      }
      
      @Override
      public List<Compgroup> getDDCompgroups(){
          List<Compgroup> allCompgroups = new ArrayList<Compgroup>();  
          allCompgroups=dao.getAllCompgroups();
        
       
        
          return allCompgroups;
      }
       @Override
      public List<Unit> getDDUnit(){
          List<Unit> allUnits = new ArrayList<Unit>();  
          allUnits=dao.getAllUnits();
        
       
        
          return allUnits;
      }
      
      @Override
      public List<Matrix> getDDMatrix(){
          List<Matrix> allMatrix = new ArrayList<Matrix>();  
          allMatrix=dao.getAllMatrix();
        
       
        
          return allMatrix;
      }
      
      @Override
      public List<Referencetype> getDDReferencetype(){
          List<Referencetype> allReferencetype = new ArrayList<Referencetype>();  
          allReferencetype=dao.getAllReferencetype();
        
       
        
          return allReferencetype;
      }
      
    @Override
      public List<WsvalueResult> getAllWsvalues(){
      List<WsvalueResult> allWsvalues = new ArrayList<WsvalueResult>();  
          allWsvalues=dao.getAllWsValues();
        
       
        
          return allWsvalues;
      }
    @Override
      public String login(User u){
          String output=dao.login(u);
          return output;
      }
      
    @Override
       public String register(UserPostClass u){
           String output=dao.register(u);
          return output;
       }
    @Override
      public List<Areofinterest> getDDAreofinterest(){
          List<Areofinterest> areas=new ArrayList<Areofinterest>();
          areas=dao.getAllAreofinterest();
          return areas;
      }
    @Override
      public List<Institution> getDDInstitution(){
          List<Institution> institutions=new ArrayList<Institution>();
          institutions=dao.getAllInstitutions();
          return institutions;
      }
    @Override
      public List<Institutiontype> getDDInstitutiontype(){
           List<Institutiontype> institutiontype=new ArrayList<Institutiontype>();
          institutiontype=dao.getAllIstitutiontypes();
          return institutiontype;
      }
    @Override
      public List<Country> getDDCountry(){
           List<Country> countries=new ArrayList<Country>();
          countries=dao.getAllCountries();
          return countries;
      }
  
    @Override
        public List<ComponentList> getcomponentList(){
            List<ComponentList> componentList=dao.getcomponentList();
            return componentList;
        }
        
    @Override
        public  String addFood(Food f)
        {
            String edit=dao.addFood(f);
            return edit;
        }
    @Override
        public String addWastestream(WastreamPOSTClass w)
        {
            String edit=dao.addWastestream(w);
            return edit;
        }
        
     @Override
        public  String editWastestream(WastreamPOSTClass w)
        {
            String edit=dao. editWastestream (w);
            return edit;
        }


     @Override
        public  String editWsvalue(WsvaluePostClass w)
        {
            String edit=dao. editWsvalue (w);
            return edit;
        }
        
     @Override
        public  String addWsvalue(WsvaluePostAdd w){
            String edit=dao. addWsvalue (w);
            return edit;
        }

     @Override
        public String deleteWsvalue(WsvaluePostClass  w){
            String edit=dao. deleteWsvalue (w);
            return edit;
        }
        
    @Override
        public Integer getFoodId(String foodname){
            List<Food> foods=dao.getAllFoods();
            Integer foodId=0;
            for(Food object:foods)
            {
                if(object.getFoodname().equals(foodname))
                {
                    foodId=object.getFoodid();
                }
            }
            return foodId;
        }

     @Override
      public List<UserRole> getUserRole(){
          List<UserRole> userRole = new ArrayList<UserRole>();  
          userRole=dao.getUserRole();
          return userRole;
                  }

      
      @Override
      public List<WastestreamFood> getWastestreamsFood(){
          List<WastestreamFood> wsf = new ArrayList<WastestreamFood>();  
          wsf=dao.getAllWasteStreamsFood();
          return wsf;
                  }
      

     @Override
     public Integer getWastestreamId (String wastestream)
     {
         List<Wastestream> ws=dao.getAllWasteStreams();
         Integer wsid=0;
         for(Wastestream object:ws)
         {
             if(object.getWastestream().equals(wastestream))
             {
                 wsid=object.getWsid();
             }
         }
         return wsid;
     }
          @Override
     public Integer getCompid (String component)
     {
         List<Component> cs=dao.getAllComponenets();
         Integer cid=0;
         for(Component c:cs)
         {
             if(c.getFtc().equals(component))
             {
                 cid=c.getCompid();
             }
         }
         return cid;
     }
     
     @Override
     public Integer getWsid (String wastestream, String compgroup, String comp)
     {
         List<WsvalueResult> ws=dao.getAllWsValues();
         Integer wsid=0;
         for(WsvalueResult object:ws)
         {
             if((object.getWastestream().equals(wastestream))&&(object.getCompgroup().equals(compgroup))&&(object.getCftc().equals(comp)))
                     {
                         wsid=object.getValueid();
                     }
         }
         return wsid;
     }
     @Override
     public Integer getRole (String email)
     {
     List<UserRole> userroles=getUserRole();
           int userrole=3;
           for(UserRole object:userroles)
           {
               if(object.getEmail().equals(email))
               {
                   userrole=object.getRoleid();
                 
               }
           }
           return userrole;
     }
     @Override
     public WastestreamFood getWSF(Integer wsid, Integer foodid)
     {
         WastestreamFood result=new WastestreamFood();
        List<WastestreamFood> wsf1=searchFood1(foodid); 
        for(WastestreamFood o:wsf1)
        {
            if(o.getWsid()==wsid)
                result=o;
        }
        return result;
     }
}
