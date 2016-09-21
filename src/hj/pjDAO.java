package hj;

import cronian.project.model.pjJoinUpdate;
import cronian.project.model.pjMenumodel;
import cronian.project.model.pjOrdermodel;
import cronian.project.model.pjUOMmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2016-09-19.
 */
public class pjDAO {
    private static final String DRV = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@//192.168.160.131:1521/xe";
    private static final String USR = "hj";
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
    private static final String selectuserOneInfo;
    private static final String selectadminOneInfo;
    private static final String selectcomOneInfo;
    private static final String checkUserEmail;
    private static final String checkAdminEmail;
    private static final String checkComEmail;
    private static final String DeleteMB;
    private static final String DeleteAdminMB;
    private static final String DeleteCompanyMB;
    private static final String listUOM;
    private static final String checkMBLogin;
    private static final String checkAdminLogin;
    private static final String checkCompanyLogin;
    private static final String insertMB;
    private static final String insertAdminMB;
    private static final String insertCompanyMB;

    static {
        JoinMB = "insert into users values (sq_users.nextval,?,?,?,?,?)";
        JoinAdminMB = "insert into admin values (sq_admin.nextval,?,?,?,?,?)";
        JoinCompanyMB = "insert into company values (sq_company.nextval,?,?,?,?)";
        DeleteMB = "delete from users where useremail = ?";
        DeleteAdminMB = "delete from admin where adminemail = ?";
        DeleteCompanyMB = "delete from company where comemail = ?";
        insertMenu = "insert into menu values (?,?,?,?)";
        insertOrders = "insert into orders (orderno,menuno,delinfo,billinfo,comno,ordervalue,userno) values (sq_orders.nextval,?,?,?,?,?,?)";
        selectuserOneInfo = "select * from users where useremail = ?";
        selectadminOneInfo = "select * from admin where adminemail = ?";
        selectcomOneInfo = "select * from company where comemail = ?";
        checkUserEmail = "select count(useremail) as result from users where useremail = ?";
        checkAdminEmail = "select count(adminemail) as result from admin where adminemail = ?";
        checkComEmail = "select count(comemail) as result from company where comemail = ?";
        listUOM = "select * from UOM ";
        checkMBLogin = "select userpw from users where useremail = ?";
        checkAdminLogin = "select adminpw from admin where adminemail = ?";
        checkCompanyLogin = "select compw from company where comemail = ?";
        insertMB = "insert into users values (sq_user.nextval,?,?,?,?,?)";
        insertAdminMB = "insert into admin values (sq_admin.nextval,?,?,?,?,?)";
        insertCompanyMB = "insert into company values (sq_company.nextval,?,?,?,?)";
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

    // 이메일 체크 (중복 검사)
    // false가 반환되는 경우 중복값 있음
    public static boolean checkemail(String id, int type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            conn = pjDAO.openConn();

            switch (type) {
                case 1:
                    pstmt = conn.prepareStatement(checkUserEmail);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        if (rs.getInt("result") > 0) {
                            result = false;
                        } else {
                            result = true;
                        }
                    }
                    break;
                case 2:
                    pstmt = conn.prepareStatement(checkAdminEmail);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        if (rs.getInt("result") > 0) {
                            result = false;
                            break;
                        } else {
                            result = true;
                        }
                    }
                    break;
                case 3:
                    pstmt = conn.prepareStatement(checkComEmail);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        if (rs.getInt("result") > 0) {
                            result = false;
                            break;
                        } else {
                            result = true;
                        }
                    }
                    break;
                default:
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cronian.project.DB.pjDAO.closeConn(conn, pstmt, rs);
        }
        return result;
    }

    // 신규 맴버 추가 함수
    // 입력한 정보를 pjJoinUpdate 형식으로 받고, 접근 방식에 따라
    // id의 타입 (1:일반유저,2:관리자,3:업체) 를 부여받는다.
    public static boolean addMember(pjJoinUpdate pj, int type) {
        boolean result = false;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = cronian.project.DB.pjDAO.openConn();
            switch (type) {
                case 1:
                    pstmt = conn.prepareStatement(JoinMB);
                    pstmt.setString(1, pj.getName());
                    pstmt.setString(2, pj.getEmail());
                    pstmt.setString(3, pj.getNum());
                    pstmt.setString(4, pj.getAddr());
                    pstmt.setString(5, pj.getPw());
                    pstmt.executeUpdate();
                    result = true;
                    break;
                case 2:
                    pstmt = conn.prepareStatement(JoinAdminMB);
                    pstmt.setString(1, pj.getName());
                    pstmt.setString(2, pj.getEmail());
                    pstmt.setString(3, pj.getNum());
                    pstmt.setString(4, pj.getAddr());
                    pstmt.setString(5, pj.getPw());
                    pstmt.executeUpdate();
                    result = true;
                    break;
                case 3:
                    pstmt = conn.prepareStatement(JoinCompanyMB);
                    pstmt.setString(1, pj.getName());
                    pstmt.setString(2, pj.getEmail());
                    pstmt.setString(3, pj.getNum());
                    pstmt.setString(4, pj.getPw());
                    pstmt.executeUpdate();
                    result = true;
                    break;
                default:
                    result = false;
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cronian.project.DB.pjDAO.closeConn(conn, pstmt, null);
        }
        return result;
    }


    // 맴버 삭제 함수
    // id와 타입을 입력받아 일치하는 id 삭제
    public static void deleteMember(String id, int type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = cronian.project.DB.pjDAO.openConn();
            switch (type) {
                case 1:
                    pstmt = conn.prepareStatement(DeleteMB);
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
                    break;
                case 2:
                    pstmt = conn.prepareStatement(DeleteAdminMB);
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
                    break;
                case 3:
                    pstmt = conn.prepareStatement(DeleteCompanyMB);
                    pstmt.setString(1, id);
                    pstmt.executeUpdate();
                    break;
                default:
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cronian.project.DB.pjDAO.closeConn(conn, pstmt, null);
        }
    }


    // 신규 메뉴 추가 함수
    public static void addMenu(pjMenumodel pj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = cronian.project.DB.pjDAO.openConn();
            pstmt = conn.prepareStatement(insertMenu);
            pstmt.setString(1, pj.getMenuno());
            pstmt.setString(2, pj.getMenulist());
            pstmt.setString(3, pj.getMenuinfo());
            pstmt.setString(4, pj.getMenuname());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cronian.project.DB.pjDAO.closeConn(conn, pstmt, null);
        }
    }

    // 신규 주문 추가 함수
    public static void addOrders(pjOrdermodel pj) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = cronian.project.DB.pjDAO.openConn();
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
            cronian.project.DB.pjDAO.closeConn(conn, pstmt, null);
        }
    }

    // 개인정보 조회
    // 로그인 시에만 이용가능! 로그인 ID와 ID의 타입(1:일반유저,2:관리자,3:업체) 를 매개변수로 한다.
    // 조회된 결과를 pjJoinUpdate 형식으로 반환
    public static pjJoinUpdate memberInfo(String id, int type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        pjJoinUpdate pj = null;
        try {
            conn = cronian.project.DB.pjDAO.openConn();

            switch (type) {
                case 1:
                    pstmt = conn.prepareStatement(selectuserOneInfo);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
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
                    pstmt = conn.prepareStatement(selectadminOneInfo);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
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
                    pstmt = conn.prepareStatement(selectcomOneInfo);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
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

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cronian.project.DB.pjDAO.closeConn(conn, pstmt, rs);
        }
        return pj;
    }

    // 유저 + 주문정보 보기 함수
    // 글번호, 제목, 작성자, 작성일, 조회수
    public static List<pjUOMmodel> listUOM() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<pjUOMmodel> result = new ArrayList<>();
        // 전체 글 목록을 저장하기 위해 배열로 변수 선언
        // listBoard 변수에 정의된 질의문을 실행하고
        // 그 결과를 boardModel 객체 형태로 변환
        // 물론 모든 항목이 아닌 일부 항목을 선별
        // 일부 : 번호 제목 작성자 작성일 조회수


        try {
            conn = openConn();
            pstmt = conn.prepareStatement(listUOM);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                pjUOMmodel m = new pjUOMmodel(
                        rs.getString("userno"),
                        rs.getString("username"),
                        rs.getString("useremail"),
                        rs.getString("usernum"),
                        rs.getString("useraddr"),
                        rs.getString("orderno"),
                        rs.getString("delinfo"),
                        rs.getString("billinfo"),
                        rs.getInt("ordervalue"),
                        rs.getString("menuno"),
                        rs.getString("menulist"),
                        rs.getString("menuinfo"),
                        rs.getString("menuname"),
                        rs.getString("adminno"),
                        rs.getString("comno")
                );
                //조회한 결과들을 boardModel 객체로 생성
                result.add(m);
                //boardmodel 객체를 arraylist에 저장
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConn(conn, pstmt, rs);
        }
        return result;
    }

    // 로그인 함수
    // 아이디와 비밀번호를 각각 getText() 함수로 받아와서
    // 지정된 타입 (1:유저,2:관리자,3:업체) 과 함께 함수에 전달
    // 검사해준다.
    public static boolean Login(String id, String pw, int type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            conn = cronian.project.DB.pjDAO.openConn();
            switch (type) {
                case 1:
                    pstmt = conn.prepareStatement(checkMBLogin);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        if (rs.getString("userpw").equals(pw)) {
                            result = true;
                        }
                    }
                    break;
                case 2:
                    pstmt = conn.prepareStatement(checkAdminLogin);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        if (rs.getString(1).equals(pw)) {
                            result = true;
                        }
                    }
                    break;
                case 3:
                    pstmt = conn.prepareStatement(checkCompanyLogin);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        if (rs.getString("compw").equals(pw)) {
                            result = true;
                        }
                    }
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cronian.project.DB.pjDAO.closeConn(conn, pstmt, rs);
        }
        return result;
    }

    //회원가입


    // 회원가입
    // 가입 환경에 따라 타입(1:일반유저,2:관리자,3:업체) 를 매개변수로 한다.
    public static void joinMember(pjJoinUpdate pj, int type) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = cronian.project.DB.pjDAO.openConn();

            switch (type) {
                case 1:
                    pstmt = conn.prepareStatement(insertMB);
                    pstmt.setString(1, pj.getName());
                    pstmt.setString(2, pj.getEmail());
                    pstmt.setString(3, pj.getNum());
                    pstmt.setString(4, pj.getAddr());
                    pstmt.setString(5, pj.getPw());

                    break;
                case 2:
                    pstmt = conn.prepareStatement(insertAdminMB);
                    pstmt.setString(1, pj.getName());
                    pstmt.setString(2, pj.getEmail());
                    pstmt.setString(3, pj.getNum());
                    pstmt.setString(4, pj.getAddr());
                    pstmt.setString(5, pj.getPw());
                    break;
                case 3:
                    pstmt = conn.prepareStatement(insertCompanyMB);
                    pstmt.setString(1, pj.getName());
                    pstmt.setString(2, pj.getEmail());
                    pstmt.setString(3, pj.getNum());
                    pstmt.setString(4, pj.getPw());
                    break;
                default:
                    break;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cronian.project.DB.pjDAO.closeConn(conn, pstmt, null);
        }
    }
}
