/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.service;

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
import foodwaste.domain.UserPostClass;
import foodwaste.domain.UserRole;
import foodwaste.domain.Wastestream;
import foodwaste.domain.WastestreamFood;
import foodwaste.domain.WsvalueResult;
import java.util.List;
import foodwaste.domain.WastreamPOSTClass;
import foodwaste.domain.Wsvalue;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvaluePostAdd;

/**
 *
 * @author Tome
 */
public interface Service {
    
    public List<Wastestream> searchFood(String foodname);
    public List<WastestreamFood> searchFood1(Integer foodid);
    public List<WsvalueResult> searchWastestream(String wastestream);
    public List<ComponentList> searchComponent(String component);
    public List<WsvalueResult> searchCompsubgroup(int compsubgroupid);
    public List<WsvalueResult> searchCompgroup(int compgroupid);
    public List<Food> getDDFoods();
    public List<Wastestream> getDDWastestreams();
    public List<Component> getDDComponents();
    public List<Compsubgroup> getDDCompsubgroups();
    public List<Compgroup> getDDCompgroups();
    public List<Areofinterest> getDDAreofinterest();
    public List<Institution> getDDInstitution();
    public List<Institutiontype> getDDInstitutiontype();
    public List<Country> getDDCountry();
    public List<Unit> getDDUnit();
    public List<Matrix> getDDMatrix();
    public List<Referencetype> getDDReferencetype();
    public String username(User u);
    public List<WsvalueResult> getAllWsvalues();
    public String login(User u);
    public String register(UserPostClass u);
    public List<ComponentList> getcomponentList();
    public String addFood(Food f);
    public String addWastestream(WastreamPOSTClass w);
    public String editWastestream(WastreamPOSTClass w);
    public String editWsvalue(WsvaluePostClass w);
    public String addWsvalue(WsvaluePostAdd w);
    public String deleteWsvalue(WsvaluePostClass w);
    public List<ComponentList> searchCompgroup(String compgroup);
    public User user(String email);
    public Integer getFoodId(String foodname);
    public List<UserRole> getUserRole();
    public List<WastestreamFood> getWastestreamsFood();
    public Integer getWastestreamId (String wastestream);
    public Integer getWsid (String wastestream, String compgroup, String comp);
    public Integer getCompid (String component);
    public Integer getRole (String email);
    public WastestreamFood getWSF(Integer wsid, Integer foodid);
}
