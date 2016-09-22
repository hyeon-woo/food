package cronian.project.model;

/**
 * Created by java on 2016-09-19.
 */
public class pjJoinUpdate {
    private String email;
    private String name;
    private String num;
    private String pw;
    private String addr;

    public pjJoinUpdate() {
    }

    public pjJoinUpdate(String email, String name, String num, String pw, String addr) {
        this.email = email;
        this.name = name;
        this.num = num;
        this.pw = pw;
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
