package cronian.project.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by java on 2016-09-20.
 */
public class pjMenumodel {

    private SimpleStringProperty menuno;
    private SimpleStringProperty menulist;
    private SimpleStringProperty menuinfo;
    private SimpleStringProperty menuname;

    public pjMenumodel() {
    }

    public pjMenumodel(String menuno,
                       String menulist,
                       String menuinfo,
                       String menuname) {
        this.menuno = new SimpleStringProperty(menuno);
        this.menulist = new SimpleStringProperty(menulist);
        this.menuinfo = new SimpleStringProperty(menuinfo);
        this.menuname = new SimpleStringProperty(menuname);
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
}
