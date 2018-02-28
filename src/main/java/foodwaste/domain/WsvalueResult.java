/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.domain;

/**
 *
 * @author Tome
 */
public class WsvalueResult implements java.io.Serializable {
    
    private String wastestream;
    private int wsid;
    private int priorityid;
    private Double value;
    private int valueid;
    private String uftc;
    private int unitid;
    private String mftc;
    private int matrixid;
    private String cftc;
    private int compid;
    private String compsubgroup;
    private int compsubgroupid;
    private int compgroupid;
    private String compgroup;
    private String foodname;
    private int foodid;
    private int ccid;
    private String fcdbdesc;
    private int fcdbid;
    private int refid;
    private int reftypeid;
    private String srcode;
    private String citation;
    private int acqtypeid;
    private String aqftc;
    private int methindid;
    private String miftc;
    private int methtypeid;
    private String mtftc;
    private int valuetypeid;
    private String remark;
    private int userid;
    private int roleid;
    private int intareaid;
    private int instid;
    private int insttypeid;
    private String checked;
    
    
    public WsvalueResult() {
    }

    public WsvalueResult(String wastestream, int wsid, Double value, int valueid, String uftc, int unitid, String mftc, int matrixid, String cftc, int compid, String compsubgroup, int compgroupid, String compgroup, String foodname, int foodid, String fcdbdesc, int fcdbid, int refid, String srcode, String citation, int acqtypeid, String aqftc, int methindid, String miftc, int methtypeid, String mtftc, int valuetypeid, String remark, int userid) {
        this.wastestream = wastestream;
        this.wsid = wsid;
        this.value = value;
        this.valueid = valueid;
        this.uftc = uftc;
        this.unitid = unitid;
        this.mftc = mftc;
        this.matrixid = matrixid;
        this.cftc = cftc;
        this.compid = compid;
        this.compsubgroup = compsubgroup;
        this.compgroupid = compgroupid;
        this.compgroup = compgroup;
        this.foodname = foodname;
        this.foodid = foodid;
        this.fcdbdesc = fcdbdesc;
        this.fcdbid = fcdbid;
        this.refid = refid;
        this.srcode = srcode;
        this.citation = citation;
        this.acqtypeid = acqtypeid;
        this.aqftc = aqftc;
        this.methindid = methindid;
        this.miftc = miftc;
        this.methtypeid = methtypeid;
        this.mtftc = mtftc;
        this.valuetypeid = valuetypeid;
        this.remark = remark;
        this.userid = userid;
    }

    public int getReftypeid() {
        return reftypeid;
    }

    public void setReftypeid(int reftypeid) {
        this.reftypeid = reftypeid;
    }

    public int getInstid() {
        return instid;
    }

    public void setInstid(int instid) {
        this.instid = instid;
    }

    public int getInsttypeid() {
        return insttypeid;
    }

    public void setInsttypeid(int insttypeid) {
        this.insttypeid = insttypeid;
    }

    public int getPriorityid() {
        return priorityid;
    }

    public void setPriorityid(int priorityid) {
        this.priorityid = priorityid;
    }

    public int getFcdbid() {
        return fcdbid;
    }

    public void setFcdbid(int fcdbid) {
        this.fcdbid = fcdbid;
    }

    public int getCcid() {
        return ccid;
    }

    public void setCcid(int ccid) {
        this.ccid = ccid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getIntareaid() {
        return intareaid;
    }

    public void setIntareaid(int intareaid) {
        this.intareaid = intareaid;
    }


    public int getCompsubgroupid() {
        return compsubgroupid;
    }

    public void setCompsubgroupid(int compsubgroupid) {
        this.compsubgroupid = compsubgroupid;
    }

    public int getWsid() {
        return wsid;
    }

    public void setWsid(int wsid) {
        this.wsid = wsid;
    }

    public int getValueid() {
        return valueid;
    }

    public void setValueid(int valueid) {
        this.valueid = valueid;
    }

    public int getUnitid() {
        return unitid;
    }

    public void setUnitid(int unitid) {
        this.unitid = unitid;
    }

    public int getMatrixid() {
        return matrixid;
    }

    public void setMatrixid(int matrixid) {
        this.matrixid = matrixid;
    }

    public int getCompid() {
        return compid;
    }

    public void setCompid(int compid) {
        this.compid = compid;
    }

    public int getCompgroupid() {
        return compgroupid;
    }

    public void setCompgroupid(int compgroupid) {
        this.compgroupid = compgroupid;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }



    public int getRefid() {
        return refid;
    }

    public void setRefid(int refid) {
        this.refid = refid;
    }

    public int getAcqtypeid() {
        return acqtypeid;
    }

    public void setAcqtypeid(int acqtypeid) {
        this.acqtypeid = acqtypeid;
    }

    public int getMethindid() {
        return methindid;
    }

    public void setMethindid(int methindid) {
        this.methindid = methindid;
    }

    public int getMethtypeid() {
        return methtypeid;
    }

    public void setMethtypeid(int methtypeid) {
        this.methtypeid = methtypeid;
    }

    public int getValuetypeid() {
        return valuetypeid;
    }

    public void setValuetypeid(int valuetypeid) {
        this.valuetypeid = valuetypeid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

       
   

    public String getWastestream() {
        return wastestream;
    }

    public void setWastestream(String wastestream) {
        this.wastestream = wastestream;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUftc() {
        return uftc;
    }

    public void setUftc(String uftc) {
        this.uftc = uftc;
    }

    public String getMftc() {
        return mftc;
    }

    public void setMftc(String mftc) {
        this.mftc = mftc;
    }

    public String getCftc() {
        return cftc;
    }

    public void setCftc(String cftc) {
        this.cftc = cftc;
    }

    public String getCompsubgroup() {
        return compsubgroup;
    }

    public void setCompsubgroup(String compsubgroup) {
        this.compsubgroup = compsubgroup;
    }

    public String getCompgroup() {
        return compgroup;
    }

    public void setCompgroup(String compgroup) {
        this.compgroup = compgroup;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFcdbdesc() {
        return fcdbdesc;
    }

    public void setFcdbdesc(String fcdbdesc) {
        this.fcdbdesc = fcdbdesc;
    }

    public String getSrcode() {
        return srcode;
    }

    public void setSrcode(String srcode) {
        this.srcode = srcode;
    }

    public String getCitation() {
        return citation;
    }

    public void setCitation(String citation) {
        this.citation = citation;
    }

    public String getAqftc() {
        return aqftc;
    }

    public void setAqftc(String aqftc) {
        this.aqftc = aqftc;
    }

    public String getMiftc() {
        return miftc;
    }

    public void setMiftc(String miftc) {
        this.miftc = miftc;
    }

    public String getMtftc() {
        return mtftc;
    }

    public void setMtftc(String mtftc) {
        this.mtftc = mtftc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
       
       
       
       
    
}
