package cronian.project.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-20.
 */
public class pjOrdermodel {
    private SimpleStringProperty orderno;
    private SimpleStringProperty menuno;
    private SimpleStringProperty delinfo;
    private SimpleStringProperty billinfo;
    private SimpleStringProperty comno;
    private SimpleIntegerProperty ordervalue;
    private SimpleStringProperty adminno;
    private SimpleStringProperty userno;

    public pjOrdermodel() {
    }

    public pjOrdermodel(String orderno,
                        String menuno,
                        String delinfo,
                        String billinfo,
                        String comno,
                        Integer ordervalue,
                        String adminno,
                        String userno) {
        this.orderno = new SimpleStringProperty(orderno);
        this.menuno = new SimpleStringProperty(menuno);
        this.delinfo = new SimpleStringProperty(delinfo);
        this.billinfo = new SimpleStringProperty(billinfo);
        this.comno = new SimpleStringProperty(comno);
        this.ordervalue = new SimpleIntegerProperty(ordervalue);
        this.adminno = new SimpleStringProperty(adminno);
        this.userno = new SimpleStringProperty(userno);
    }

    public String getOrderno() {
        return orderno.get();
    }


    public void setOrderno(String orderno) {
        this.orderno.set(orderno);
    }

    public String getMenuno() {
        return menuno.get();
    }


    public void setMenuno(String menuno) {
        this.menuno.set(menuno);
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

    public String getComno() {
        return comno.get();
    }


    public void setComno(String comno) {
        this.comno.set(comno);
    }

    public int getOrdervalue() {
        return ordervalue.get();
    }


    public void setOrdervalue(int ordervalue) {
        this.ordervalue.set(ordervalue);
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
}
