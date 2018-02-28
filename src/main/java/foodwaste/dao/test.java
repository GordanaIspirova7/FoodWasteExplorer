/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.dao;

import foodwaste.domain.Areofinterest;
import foodwaste.domain.Component;
import foodwaste.domain.ComponentList;
import foodwaste.domain.Country;
import foodwaste.domain.EditUser;
import foodwaste.domain.Food;
import foodwaste.domain.Institution;
import foodwaste.domain.Institutiontype;
import foodwaste.domain.Matrix;
import foodwaste.domain.Referencetype;
import foodwaste.domain.Unit;
import foodwaste.domain.User;
import foodwaste.domain.Wastestream;
import foodwaste.domain.UserPostClass;
import foodwaste.domain.UserRole;
import foodwaste.domain.WastestreamFood;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvalueResult;
import foodwaste.service.ServiceImpl;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import foodwaste.domain.WastreamPOSTClass;
import foodwaste.domain.WsvaluePostAdd;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Tome
 */
public class test {
      public static void main(String[] args) throws IOException {
          ServiceImpl service=new ServiceImpl();
          DAOImpl dao=new DAOImpl();
          List<Food> food=service.getDDFoods();
          System.out.println(food.get(0).getFoodname());
          
          List<Areofinterest> area=service.getDDAreofinterest();
          System.out.println(area.get(0).getInterestarea());
          
           List<Institution> institutions=service.getDDInstitution();
          System.out.println(institutions.get(0).getInsname());
          
           List<Institutiontype> institutiontype=service.getDDInstitutiontype();
          System.out.println(institutiontype.get(0).getInsttype());
          
           List<Country> countries=service.getDDCountry();
          System.out.println(countries.get(0).getCountrycode());
          



    

//           ADD FOOD
//           Food f=new Food();
//           f.setFoodname("KIFLA1");  
//           System.out.println(service.addFood(f));

//           ADD WASTE STREAM
//           WastreamPOSTClass ws=new WastreamPOSTClass();
//           ws.setEdible(1.2);
//           ws.setFoodid(1);
//           ws.setGcf(1.2);
//           ws.setNcf(1.2);
//           ws.setSpecgravity(1.2);
//           ws.setWastestream("Koshtiljka2");
   
//           System.out.println(service.addWastestream(ws));
        



//          EDIT WASTE STREAM
//            WastreamPOSTClass ws1=new WastreamPOSTClass();
//            ws1.setWsid(257);
//            ws1.setEdible(2.1);
//            ws1.setGcf(2.1);
//            ws1.setNcf(2.1);
//            ws1.setSpecgravity(2.1);
//            
//            System.out.println(service.editWastestream(ws1));


//          ADD WSVALUE          
//          WsvaluePostAdd w=new WsvaluePostAdd(); 
//          w.setCompid(9);
//          w.setWastestream("Pomace, powder, fermented with Candida");
//          w.setValue(1.2);
//          w.setUftc("g");
//          w.setEmail("gordana.ispirova@ijs.si");
//          w.setCitation("JOZEF STEFAN");
//          System.out.println(service.addWsvalue(w));
//                  
//WsvaluePostAdd ws=new WsvaluePostAdd(); 
//     ws.setCompid(1104);
//     ws.setWastestream("Apple cake");
//     ws.setValue(1.0);
//     ws.setUftc("g/100g");
//     ws.setEmail("gordana_ispirova@hotmail.com");
//     ws.setCitation("Nee");
// System.out.println(service.addWsvalue(ws));

//          EDIT WASTE VALUE
//          WsvaluePostClass w1=new WsvaluePostClass();
//          w1.setValueid(14621);
//          w1.setValue(1.0);
//          w1.setEmail("gordana_ispirova@hotmail.com");
//          w1.setFtc("g/kg");
//          w1.setCitation("Faaaa");
//          
//          System.out.println(service.editWsvalue(w1));

//          DELTE WASTE VALUE
//            WsvaluePostClass w2=new WsvaluePostClass();
//            w2.setValueid(20351);
//            System.out.println(service.deleteWsvalue(w2));


//          ALL COMPONENTS          
//          List<ComponentList> list=service.getcomponentList();
//          for(int i=0;i<list.size();i++)
//          { System.out.println(list.get(i).getCftc()+" - "+list.get(i).getCompgroupid());}
                  



//          DAOImpl dao=new DAOImpl();
//          User u=new User();
//          u.setEmail("tome.eftimov@ijs.si");
//          u.setPassword("tometome");
//          String login=service.login(u);
//          System.out.println(login);
//          List<WsvalueResult> list=service.searchCompsubgroup(3);
//          System.out.println(list.get(0).getWastestream());
//          
//           
//          UserPostClass upost=new UserPostClass();
//          upost.setName("Boris");
//          upost.setSurname("Janev");
//          upost.setEmail("boris.janev@gmail.com");
//          upost.setPassword("borisboris");
//          upost.setInsname("Faculty of electrical engineering");
//          upost.setInsttype("Research");
//          upost.setInterestarea("Research");
//          upost.setCountrycode("mk");
//          
//          
//          WsvaluePostClass waste=new WsvaluePostClass();
//          waste.setValueid(1);
//          waste.setEmail("tome.eftimov@ijs.si");
//          waste.setFtc("g");
//          waste.setMftc("");
//          waste.setValue(16.00);
//          waste.setCitation("Department of Health UK");
//          waste.setSrcode("");
//          waste.setRftc("");
//          
//          String edit=service.editWsvalue(waste);
//          System.out.println(edit);
//          
//          List<WsvalueResult> a=dao.getAllWsValues();
//          System.out.println(a.get(1).getValue());
//          
//          String register=service.register(upost);
//          System.out.println(register);
          
//          List<ComponentList> list=service.searchComponent("Vitamin C");
//          for(ComponentList object:list)
//          {
//              System.out.println(object);
//          }
    
//       String foodname="Sugar";
//       Integer foodid=service.getFoodId(foodname);
//       List<WastestreamFood> wsvalues=service.searchFood1(foodid);
//       for(WastestreamFood object:wsvalues)
//     
//        {
//            System.out.println(object.getWastestream());
//        }
//      

//
//        String mail="gordana.ispirova@ijs.si";
//        List<UserRole> ur=service.getUserRole();
//        for(UserRole object:ur)
//        {
//            if(object.getEmail().equals(mail))
//            {  System.out.println(object.getRoledesc());}
//        }
        
//           List<WastestreamFood> wsf=service.searchFood1(1);
//           int index=0;
//           Collections.sort(wsf, new Comparator<WastestreamFood>() {
//    @Override
//    public int compare(WastestreamFood s1, WastestreamFood s2) {
//        return s1.getWastestream().compareToIgnoreCase(s2.getWastestream());
//    }
//});
//           Map<String, WastestreamFood> map = new HashMap<String, WastestreamFood>();
//            for (WastestreamFood ws : wsf) {
//            String key = ws.getWastestream();
//            if (!map.containsKey(key)) {
//          map.put(key, ws);
//     }
//}
//            
//Collection<WastestreamFood> wsf1 = map.values();
//
//
//
//for(WastestreamFood ws:wsf)
//{
//    System.out.println(ws.getWastestream());
//}




      }
}
