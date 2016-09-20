package cronian.project.DB;

import cronian.project.model.pjJoinUpdate;
import cronian.project.model.pjMenumodel;
import cronian.project.model.pjOrdermodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by java on 2016-09-19.
 */
public class pjDAO {
    private static final String DRV = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@//192.168.139.128:1521/xe";
    private static final String USR = "cronian";
    private static final String PWD = "123456";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // SQL 목록

    private static final String JoinMB;
    private static final String JoinAdminMB;
    private static final String JoinCompanyMB;
    private static final String insertMenu;
    private static final String insertOrders;
    private static final String selectOneInfo;

    static {
        JoinMB = "insert into users values (sq_users.nextval,?,?,?,?,?)";
        JoinAdminMB = "insert into admin values (sq_admin.nextval,?,?,?,?,?)";
        JoinCompanyMB = "insert into company values (sq_company.nextval,?,?,?,?)";
        insertMenu = "insert into menu values (?,?,?,?)";
        insertOrders = "insert into orders (orderno,menuno,delinfo,billinfo,comno,ordervalue,userno) values (sq_orders.nextval,?,?,?,?,?,?)";
        selectOneInfo = "select * from ? where ? = ?";
    }

    public static Connection openConn() {
        Connection conn = null;
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
                pstmt = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void addMember(pjJoinUpdate pj, int type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = pjDAO.openConn();
            switch (type) {
                case 1:
                    pstmt = conn.prepareStatement(JoinMB);
                    pstmt.setString(1, pj.getName());
                    pstmt.setString(2, pj.getEmail());
                    pstmt.setString(3, pj.getNum());
                    pstmt.setString(4, pj.getAddr());
                    pstmt.setString(5, pj.getPw());
                    pstmt.executeUpdate();
                    break;
                case 2:
                    pstmt = conn.prepareStatement(JoinAdminMB);
                    pstmt.setString(1, pj.getName());
                    pstmt.setString(2, pj.getEmail());
                    pstmt.setString(3, pj.getNum());
                    pstmt.setString(4, pj.getAddr());
                    pstmt.setString(5, pj.getPw());
                    pstmt.executeUpdate();
                    break;
                case 3:
                    pstmt = conn.prepareStatement(JoinCompanyMB);
                    pstmt.setString(1, pj.getName());
                    pstmt.setString(2, pj.getEmail());
                    pstmt.setString(3, pj.getNum());
                    pstmt.setString(4, pj.getPw());
                    pstmt.executeUpdate();
                    break;
                default:
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            pjDAO.closeConn(conn, pstmt, null);
        }
    }

    public static void addMenu(pjMenumodel pj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = pjDAO.openConn();
            pstmt = conn.prepareStatement(insertMenu);
            pstmt.setString(1, pj.getMenuno());
            pstmt.setString(2, pj.getMenulist());
            pstmt.setString(3, pj.getMenuinfo());
            pstmt.setString(4, pj.getMenuname());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            pjDAO.closeConn(conn, pstmt, null);
        }
    }

    public static void addOrders(pjOrdermodel pj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = pjDAO.openConn();
            pstmt = conn.prepareStatement(insertOrders);
            pstmt.setString(1, pj.getMenuno());
            pstmt.setString(2, pj.getDelinfo());
            pstmt.setString(3, pj.getBillinfo());
            pstmt.setString(4, pj.getComno());
            pstmt.setInt(5, pj.getOrdervalue());
            pstmt.setString(6, pj.getUserno());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            pjDAO.closeConn(conn, pstmt, null);
        }
    }

    public static pjJoinUpdate memberInfo(String id,int type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pjJoinUpdate pj = null;
        try {
            conn = pjDAO.openConn();
            pstmt = conn.prepareStatement(selectOneInfo);
            switch(type){
                case 1:
                    pstmt.setString(1,"users");
                    pstmt.setString(2,"useremail");
                    pstmt.setString(3,id);
                    rs = pstmt.executeQuery(selectOneInfo);
                    while(rs.next())
                    {
                        pj = new pjJoinUpdate(
                                rs.getString("useremail"),
                                rs.getString("username"),
                                rs.getString("usernum"),
                                rs.getString("userpw"),
                                rs.getString("useraddr")
                        );
                    }
                    break;
                case 2:
                    pstmt.setString(1,"admin");
                    pstmt.setString(2,"adminemail");
                    pstmt.setString(3,id);
                    rs = pstmt.executeQuery(selectOneInfo);
                    while(rs.next())
                    {
                        pj = new pjJoinUpdate(
                                rs.getString("adminemail"),
                                rs.getString("adminname"),
                                rs.getString("adminnum"),
                                rs.getString("adminpw"),
                                rs.getString("adminaddr")
                        );
                    }
                    break;
                case 3:
                    pstmt.setString(1,"company");
                    pstmt.setString(2,"comemail");
                    pstmt.setString(3,id);
                    rs = pstmt.executeQuery(selectOneInfo);
                    while(rs.next())
                    {
                        pj = new pjJoinUpdate(
                                rs.getString("comemail"),
                                rs.getString("comname"),
                                rs.getString("comnum"),
                                rs.getString("compw"),
                                "");
                    }
                    break;
                default:
                    break;
            }

        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            pjDAO.closeConn(conn,pstmt,rs);
        }
        return pj;
    }

}
