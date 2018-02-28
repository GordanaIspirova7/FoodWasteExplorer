/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.dao;

import foodwaste.domain.Areofinterest;
import foodwaste.domain.Compgroup;
import foodwaste.domain.Component;
import foodwaste.domain.Compsubgroup;
import foodwaste.domain.Country;
import foodwaste.domain.Food;
import foodwaste.domain.Institution;
import foodwaste.domain.Institutiontype;
import foodwaste.domain.Matrix;
import foodwaste.domain.Reference;
import foodwaste.domain.Referencetype;
import foodwaste.domain.Unit;
import foodwaste.domain.User;
import foodwaste.domain.UserPostClass;
import foodwaste.domain.Wastestream;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvalueResult;
import java.util.List;
import foodwaste.domain.ComponentList;
import foodwaste.domain.EditUser;
import foodwaste.domain.UserRole;
import foodwaste.domain.WastestreamFood;
import foodwaste.domain.WastreamPOSTClass;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvaluePostAdd;
/**
 *
 * @author Tome
 */
public interface DAO {
    
    public List<Food> getAllFoods();
    public List<Wastestream> getAllWasteStreams();
    public List<Component> getAllComponenets();
    public List<WsvalueResult> getAllWsValues();
    public List<Compsubgroup> getAllCompsubgroups();
    public List<Compgroup> getAllCompgroups();
    public List<Reference> getAllReferences();
    public List<Unit> getAllUnits();
    public List<Matrix> getAllMatrix();
    public List<Referencetype> getAllReferencetype();
    public List<User> getallUser();
    public String login(User u);
    public String register(UserPostClass u);
    public List<Areofinterest> getAllAreofinterest();
    public List<Institution> getAllInstitutions();
    public List<Institutiontype> getAllIstitutiontypes();
    public List<Country> getAllCountries();
    public List<ComponentList> getcomponentList();
    public String addFood(Food f);
    public String addWastestream(WastreamPOSTClass w);
    public String editWastestream(WastreamPOSTClass w);
    public String editWsvalue(WsvaluePostClass w);
    public String addWsvalue(WsvaluePostAdd w);
    public String deleteWsvalue(WsvaluePostClass  w);
    public List<UserRole> getUserRole();
    public List<WastestreamFood> getAllWasteStreamsFood();
    public String ChangePassword(User u);
    public String editUser(EditUser u);
    public String activeUser(String token);

}
