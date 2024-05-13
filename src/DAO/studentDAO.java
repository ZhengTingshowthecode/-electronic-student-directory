package DAO;

import entity.student;
import util.jdbcUtil;
import util.pageModel;

import java.sql.*;
import java.util.*;

/**
 * 从数据库得到同学表信息
 * @author zt
 */
public class studentDAO {
    public List<student> getStudent(pageModel pageModel){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        List<student> stu_list=new ArrayList<>();
        try{
            cn= jdbcUtil.getCn();
            if(pageModel.getSearchText()!=null&&!pageModel.getSearchText().equals("")){
                String s = "select * from student where name like ? or " +
                        " sno like ? or " +
                        " Birth like ? or " +
                        " gender like ? or " +
                        " phone like ? or " +
                        " info like ? " +
                        " limit ?,?";
                pst=cn.prepareStatement(s);
                pst.setString(1,"%"+pageModel.getSearchText()+"%");
                pst.setString(2,"%"+pageModel.getSearchText()+"%");
                pst.setString(3,"%"+pageModel.getSearchText()+"%");
                pst.setString(4,"%"+pageModel.getSearchText()+"%");
                pst.setString(5,"%"+pageModel.getSearchText()+"%");
                pst.setString(6,"%"+pageModel.getSearchText()+"%");
                pst.setInt(7, (pageModel.getPageNO()-1)*pageModel.getPageSize());
                pst.setInt(8,pageModel.getPageSize());
            }else{
                pst=cn.prepareStatement("select * from student limit ?,?");
                pst.setInt(1, (pageModel.getPageNO()-1)*pageModel.getPageSize());
                pst.setInt(2,pageModel.getPageSize());
            }
            rs=pst.executeQuery();
            while(rs.next()){
                student stu=new student();
                stu.setSno(rs.getString("sno"));
                stu.setName(rs.getString("name"));
                stu.setBirth(rs.getString("Birth"));
                stu.setGender(rs.getString("gender"));
                stu.setPhone(rs.getString("phone"));
                stu.setInfo(rs.getString("info"));
                stu_list.add(stu);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            jdbcUtil.closeCn();
        }
        return stu_list;
    }

    public Long getStudentTotal(String searchText){
        Connection cn;
        PreparedStatement pst=null;
        ResultSet rs;
        long totalCnt=0;
        try{
            cn= jdbcUtil.getCn();
            StringBuilder sb;
            //encode 加密   decode 解密
            if(searchText!=null&&!searchText.equals("")){
                sb=new StringBuilder("select count(*) from student where name like ? or " +
                        " sno like ? or "+
                        " Birth like ? or "+
                        " gender like ? or "+
                        " phone like ? or "+
                        " info like ?");
                for (int i = 1; i < 7; i++) {
                    pst.setString(i,"%"+searchText+"%");
                }
            }else{
                sb=new StringBuilder("select count(*) from student");
            }
            pst=cn.prepareStatement(sb.toString());
            rs=pst.executeQuery();
            if(rs.next()){
                totalCnt=rs.getLong(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            jdbcUtil.closeCn();
        }
        return totalCnt;
    }

    public void add(student student){
        Connection cn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            cn= jdbcUtil.getCn();
            String s="insert into student values(?,?,?,?,?,?);";
            pst=cn.prepareStatement(s);
            pst.setString(1,student.getSno()+"");
            pst.setString(2, student.getName());
            pst.setString(3, student.getGender());
            pst.setString(5, student.getPhone());
            pst.setString(6,student.getInfo());
            pst.setString(4,student.getBirth()+"");
            pst.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            jdbcUtil.closeCn();
        }
    }
}
