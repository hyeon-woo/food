package cronian.project.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-19.
 */
public class pjModel {
    // 고객정보 테이블 관련번수
    private SimpleStringProperty userno;
    private SimpleStringProperty username;
    private SimpleStringProperty useremail;
    private SimpleStringProperty usernum;
    private SimpleStringProperty useraddr;

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

    //관리자 테이블 관련변수
    private SimpleStringProperty adminno;
    private SimpleStringProperty adminname;
    private SimpleStringProperty adminemail;
    private SimpleStringProperty adminnum;
    private SimpleStringProperty adminaddr;

    //업체 테이블 관련변수
    private SimpleStringProperty comno;
    private SimpleStringProperty comnum;
    private SimpleStringProperty comname;
    private SimpleStringProperty comemail;

    //기본 생성자
    public pjModel() {
    }


    // 전체정보 생성자
    public pjModel(String userno, String username,
                   String useremail, String usernum,
                   String useraddr, String orderno,
                   String delinfo, String billinfo,
                   Integer ordervalue, String menuno,
                   String menulist, String menuinfo,
                   String menuname, String adminno,
                   String adminname, String adminemail,
                   String adminnum, String adminaddr,
                   String comno, String comnum,
                   String comname, String comemail) {
        this.userno = new SimpleStringProperty(userno);
        this.username = new SimpleStringProperty(username);
        this.useremail = new SimpleStringProperty(useremail);
        this.usernum = new SimpleStringProperty(usernum);
        this.useraddr = new SimpleStringProperty(useraddr);
        this.orderno = new SimpleStringProperty(orderno);
        this.delinfo = new SimpleStringProperty(delinfo);
        this.billinfo = new SimpleStringProperty(billinfo);
        this.ordervalue = new SimpleIntegerProperty(ordervalue);
        this.menuno = new SimpleStringProperty(menuno);
        this.menulist = new SimpleStringProperty(menulist);
        this.menuinfo = new SimpleStringProperty(menuinfo);
        this.menuname = new SimpleStringProperty(menuname);
        this.adminno = new SimpleStringProperty(adminno);
        this.adminname = new SimpleStringProperty(adminname);
        this.adminemail = new SimpleStringProperty(adminemail);
        this.adminnum = new SimpleStringProperty(adminnum);
        this.adminaddr = new SimpleStringProperty(adminaddr);
        this.comno = new SimpleStringProperty(comno);
        this.comnum = new SimpleStringProperty(comnum);
        this.comname = new SimpleStringProperty(comname);
        this.comemail = new SimpleStringProperty(comemail);
    }

    public String getUserno() {
        return userno.get();
    }

    public void setUserno(String userno) {
        this.userno.set(userno);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getUseremail() {
        return useremail.get();
    }

    public void setUseremail(String useremail) {
        this.useremail.set(useremail);
    }

    public String getUsernum() {
        return usernum.get();
    }


    public void setUsernum(String usernum) {
        this.usernum.set(usernum);
    }

    public String getUseraddr() {
        return useraddr.get();
    }

    public void setUseraddr(String useraddr) {
        this.useraddr.set(useraddr);
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

    public String getAdminno() {
        return adminno.get();
    }


    public void setAdminno(String adminno) {
        this.adminno.set(adminno);
    }

    public String getAdminname() {
        return adminname.get();
    }

    public void setAdminname(String adminname) {
        this.adminname.set(adminname);
    }

    public String getAdminemail() {
        return adminemail.get();
    }


    public void setAdminemail(String adminemail) {
        this.adminemail.set(adminemail);
    }

    public String getAdminnum() {
        return adminnum.get();
    }


    public void setAdminnum(String adminnum) {
        this.adminnum.set(adminnum);
    }

    public String getAdminaddr() {
        return adminaddr.get();
    }


    public void setAdminaddr(String adminaddr) {
        this.adminaddr.set(adminaddr);
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
