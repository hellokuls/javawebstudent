package com.kuls.dao;

import com.kuls.bean.Tb_admin;
import com.kuls.utils.KulsUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminUserDao {

    public Tb_admin login(String username, String password) throws SQLException {
        KulsUtils kulsUtils = new KulsUtils();
        Connection conn = kulsUtils.createDBConn();
        Tb_admin admin = null;
        String sql = "select * from tb_admin where a_user=? and a_pass=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                admin = new Tb_admin();
                admin.setA_user(resultSet.getString("a_user"));
                admin.setA_pass(resultSet.getString("a_pass"));
            }

        return admin;
    }
}
