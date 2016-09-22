package cronian.project.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-19.
 * @author Cronian
 * @desc 메뉴 - 주문 - 업체 뷰 모델
 */
public class pjMOCmodel {
    //주문정보 테이블 관련변수
    private SimpleStringProperty orderno;
    private SimpleStringProperty delinfo;
    private SimpleStringProperty billinfo;
    private SimpleIntegerProperty ordervalue;

    //메뉴 테이블 관련변수
    private SimpleStringProperty menuno;
    private SimpleStringProperty menulist;
    private SimpleStringProperty menuinfo;
    private SimpleStringProperty menuname;

    //업체 테이블 관련변수
    private SimpleStringProperty comno;
    private SimpleStringProperty comnum;
    private SimpleStringProperty comname;
    private SimpleStringProperty comemail;

    //관리자 테이블 관련변수
    private SimpleStringProperty adminno;

    // 고객정보 테이블 관련번수
    private SimpleStringProperty userno;

    public pjMOCmodel() {
    }

    public pjMOCmodel(String menuno,
                      String menulist,
                      String menuinfo,
                      String menuname,
                      String orderno,
                      String delinfo,
                      String billinfo,
                      Integer ordervalue,
                      String comno,
                      String comnum,
                      String comname,
                      String comemail,
                      String adminno,
                      String userno) {
        this.orderno = new SimpleStringProperty(orderno);
        this.delinfo = new SimpleStringProperty(delinfo);
        this.billinfo = new SimpleStringProperty(billinfo);
        this.ordervalue = new SimpleIntegerProperty(ordervalue);
        this.menuno = new SimpleStringProperty(menuno);
        this.menulist = new SimpleStringProperty(menulist);
        this.menuinfo = new SimpleStringProperty(menuinfo);
        this.menuname = new SimpleStringProperty(menuname);
        this.comno = new SimpleStringProperty(comno);
        this.comnum = new SimpleStringProperty(comnum);
        this.comname = new SimpleStringProperty(comname);
        this.comemail = new SimpleStringProperty(comemail);
        this.adminno = new SimpleStringProperty(adminno);
        this.userno = new SimpleStringProperty(userno);
    }

    public String getUserno() {
        return userno.get();
    }

    public void setUserno(String userno) {
        this.userno.set(userno);
    }

    public String getAdminno() {
        return adminno.get();
    }

    public void setAdminno(String adminno) {
        this.adminno.set(adminno);
    }

    public String getOrderno() {
        return orderno.get();
    }


    public void setOrderno(String orderno) {
        this.orderno.set(orderno);
    }

    public String getDelinfo() {
        return delinfo.get();
    }

    public void setDelinfo(String delinfo) {
        this.delinfo.set(delinfo);
    }

    public String getBillinfo() {
        return billinfo.get();
    }

    public void setBillinfo(String billinfo) {
        this.billinfo.set(billinfo);
    }

    public int getOrdervalue() {
        return ordervalue.get();
    }

    public void setOrdervalue(int ordervalue) {
        this.ordervalue.set(ordervalue);
    }

    public String getMenuno() {
        return menuno.get();
    }

    public void setMenuno(String menuno) {
        this.menuno.set(menuno);
    }

    public String getMenulist() {
        return menulist.get();
    }

    public void setMenulist(String menulist) {
        this.menulist.set(menulist);
    }

    public String getMenuinfo() {
        return menuinfo.get();
    }

    public void setMenuinfo(String menuinfo) {
        this.menuinfo.set(menuinfo);
    }

    public String getMenuname() {
        return menuname.get();
    }

    public void setMenuname(String menuname) {
        this.menuname.set(menuname);
    }

    public String getComno() {
        return comno.get();
    }

    public void setComno(String comno) {
        this.comno.set(comno);
    }

    public String getComnum() {
        return comnum.get();
    }

    public void setComnum(String comnum) {
        this.comnum.set(comnum);
    }

    public String getComname() {
        return comname.get();
    }

    public void setComname(String comname) {
        this.comname.set(comname);
    }

    public String getComemail() {
        return comemail.get();
    }

    public void setComemail(String comemail) {
        this.comemail.set(comemail);
    }
}
