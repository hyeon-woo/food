package cronian.project.DB;

import cronian.project.model.pjJoinUpdate;

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

    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;

    // SQL 목록

    private static final String JoinMB;
    private static final String JoinAdminMB;
    private static final String JoinCompanyMB;

    static{
        JoinMB = "insert into users values (sq_users.nextval,?,?,?,?,?)";
        JoinAdminMB = "insert into users values (sq_admin.nextval,?,?,?,?,?)";
        JoinCompanyMB = "insert into users values (sq_company.nextval,?,?,?,?)";
    }

    public static Connection openConn() {
        Connection conn=null;
        try{
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL,USR,PWD);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn,PreparedStatement pstmt, ResultSet rs){
        try{if(rs!=null){rs.close(); rs=null;}}catch(Exception ex){ex.printStackTrace();}
        try{if(pstmt!=null){pstmt.close(); pstmt=null;}}catch(Exception ex){ex.printStackTrace();}
        try{if(conn!=null){conn.close(); conn=null;}}catch(Exception ex){ex.printStackTrace();}
    }

    public static void  joinMember(pjJoinUpdate pj,int type){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = pjDAO.openConn();
            switch(type){
                case 1:
                    pstmt = conn.prepareStatement(JoinMB);
                    pstmt.setString(1,pj.getName());
                    pstmt.setString(2,pj.getEmail());
                    pstmt.setString(3,pj.getNum());
                    pstmt.setString(4,pj.getAddr());
                    pstmt.setString(5,pj.getPw());
                    pstmt.executeUpdate();
                    break;
                case 2:
                    pstmt = conn.prepareStatement(JoinAdminMB);
                    pstmt.setString(1,pj.getName());
                    pstmt.setString(2,pj.getEmail());
                    pstmt.setString(3,pj.getNum());
                    pstmt.setString(4,pj.getAddr());
                    pstmt.setString(5,pj.getPw());
                    pstmt.executeUpdate();
                    break;
                case 3:
                    pstmt = conn.prepareStatement(JoinCompanyMB);
                    pstmt.setString(1,pj.getName());
                    pstmt.setString(2,pj.getEmail());
                    pstmt.setString(3,pj.getNum());
                    pstmt.setString(4,pj.getPw());
                    pstmt.executeUpdate();
                    break;
                default:
                    break;
            }

        } catch(Exception ex){
            ex.printStackTrace();
        } finally {
            pjDAO.closeConn(conn, pstmt,null);
        }
    }
}
