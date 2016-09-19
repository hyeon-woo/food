package cronian.project.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-19.
 *
 * @author Cronian
 * @desc 고객 - 주문 - 업체 뷰 모델
 */
public class pjUOCmodel {
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

    //업체 테이블 관련변수
    private SimpleStringProperty comno;
    private SimpleStringProperty comnum;
    private SimpleStringProperty comname;
    private SimpleStringProperty comemail;

    //메뉴 테이블 관련변수
    private SimpleStringProperty menuno;

    //관리자 테이블 관련변수
    private SimpleStringProperty adminno;

    public pjUOCmodel() {
    }

    public pjUOCmodel(String userno,
                      String username,
                      String useremail,
                      String usernum,
                      String useraddr,
                      String orderno,
                      String delinfo,
                      String billinfo,
                      Integer ordervalue,
                      String comno,
                      String comnum,
                      String comname,
                      String comemail,
                      String menuno,
                      String adminno) {
        this.userno = new SimpleStringProperty(userno);
        this.username = new SimpleStringProperty(username);
        this.useremail = new SimpleStringProperty(useremail);
        this.usernum = new SimpleStringProperty(usernum);
        this.useraddr = new SimpleStringProperty(useraddr);
        this.orderno = new SimpleStringProperty(orderno);
        this.delinfo = new SimpleStringProperty(delinfo);
        this.billinfo = new SimpleStringProperty(billinfo);
        this.ordervalue = new SimpleIntegerProperty(ordervalue);
        this.comno = new SimpleStringProperty(comno);
        this.comnum = new SimpleStringProperty(comnum);
        this.comname = new SimpleStringProperty(comname);
        this.comemail = new SimpleStringProperty(comemail);
        this.menuno = new SimpleStringProperty(menuno);
        this.adminno = new SimpleStringProperty(adminno);
    }

    public String getMenuno() {
        return menuno.get();
    }

    public void setMenuno(String menuno) {
        this.menuno.set(menuno);
    }

    public String getAdminno() {
        return adminno.get();
    }

    public void setAdminno(String adminno) {
        this.adminno.set(adminno);
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
