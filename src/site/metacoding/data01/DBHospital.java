package site.metacoding.data01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import site.metacoding.data01.ResponseDto.Response.Body.Items.Item;

public class DBHospital {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
            String sql = "INSERT INTO HOSPITALTBL(주소, 운영시작일자, 구분코드, RAT가능여부, 요양종별코드, 시군구명, 시도명, 전화번호, 세계x좌표, 요양기관명, 암호화된요양기호) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            List<ItemModeling> hospitalList = DownloadHospital.getResponseList();

            System.out.println("받은 사이즈" + hospitalList.size());
            for (int i = 0; i < hospitalList.size(); i++) {
                pstmt.setString(1, hospitalList.get(i).get주소());
                pstmt.setString(2, hospitalList.get(i).get운영시작일자());
                pstmt.setString(3, hospitalList.get(i).get구분코드());
                pstmt.setString(4, hospitalList.get(i).getRAT가능여부());
                pstmt.setString(5, hospitalList.get(i).get요양종별코드());
                pstmt.setString(6, hospitalList.get(i).get시군구명());
                pstmt.setString(7, hospitalList.get(i).get시도명());
                pstmt.setString(8, hospitalList.get(i).get전화번호());
                pstmt.setString(9, hospitalList.get(i).get세계x좌표());
                pstmt.setString(10, hospitalList.get(i).get요양기관명());
                pstmt.setString(11, hospitalList.get(i).get암호화된요양기호());

                int result = pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}