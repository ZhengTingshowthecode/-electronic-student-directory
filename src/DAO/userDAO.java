package DAO;

import entity.user;
import util.jdbcUtil;
import java.sql.*;

/**
 * 从数据库得到用户表信息
 * @author zt
 */
public class userDAO {
    public user checklogin(String username, String pwd){
        user user=null;
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        try{
            cn= jdbcUtil.getCn();
            //encode 加密   decode 解密
            String sb = " select id,username from user where username=? and decode(pwd,?)=?";
            pst=cn.prepareStatement(sb);
            pst.setString(1,username);
            pst.setString(2, 123+"");
            pst.setString(3,pwd);
            rs=pst.executeQuery();
            while(rs.next()){
                user=new user();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setRealName(rs.getString("realName"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            jdbcUtil.closeCn();
        }
        return user;
    }
}
