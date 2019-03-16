package com.kuls.service;

import com.kuls.bean.Tb_admin;
import com.kuls.dao.AdminUserDao;

import java.sql.SQLException;

public class AdminUserService {
    AdminUserDao adminUserDao = new AdminUserDao();

    public Tb_admin login(String username, String password) throws SQLException {
        Tb_admin tb_admin = adminUserDao.login(username, password);
        return tb_admin;
    }
}
