package com.kuls.dao;

import com.kuls.bean.Tb_student_info;
import com.kuls.utils.KulsUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {


    public boolean add(String name, int xb, String data, String minzu, String zzmm, String zhiwu) throws SQLException {
        KulsUtils kulsUtils = new KulsUtils();
        Connection dbConn = kulsUtils.createDBConn();
        String sql = "insert into tb_student_info values(null,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = dbConn.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,xb);
        preparedStatement.setString(3,data);
        preparedStatement.setString(4,minzu);
        preparedStatement.setString(5,zzmm);
        preparedStatement.setString(6,zhiwu);
        int i = preparedStatement.executeUpdate();
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    public List<Tb_student_info> getStudents() throws SQLException {
        List<Tb_student_info> list = new ArrayList<Tb_student_info>();
        KulsUtils kulsUtils = new KulsUtils();
        Connection dbConn = kulsUtils.createDBConn();
        String sql = "select * from tb_student_info";
        PreparedStatement preparedStatement = dbConn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Tb_student_info student_info = new Tb_student_info();
            student_info.setId(resultSet.getInt("s_id"));
            student_info.setName(resultSet.getString("s_name"));
            student_info.setMinzu(resultSet.getString("s_minzu"));
            student_info.setXb(resultSet.getInt("s_xb"));
            student_info.setDate(String.valueOf(resultSet.getDate("s_date")));
            student_info.setZhiwu(resultSet.getString("s_zhiwu"));
            student_info.setZzmm(resultSet.getString("s_zzmm"));
            list.add(student_info);
        }
        kulsUtils.closeConn(dbConn);
        return list;
    }
    public List<Tb_student_info> getPageStudents(int startPosition,int currentCount) throws SQLException {
        List<Tb_student_info> list = new ArrayList<Tb_student_info>();
        KulsUtils kulsUtils = new KulsUtils();
        Connection dbConn = kulsUtils.createDBConn();
        String sql = "select * from tb_student_info limit ?,? ";
        PreparedStatement preparedStatement = dbConn.prepareStatement(sql);
        preparedStatement.setInt(1, startPosition);
        preparedStatement.setInt(2,currentCount);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            Tb_student_info student_info = new Tb_student_info();
            student_info.setId(resultSet.getInt("s_id"));
            student_info.setName(resultSet.getString("s_name"));
            student_info.setMinzu(resultSet.getString("s_minzu"));
            student_info.setXb(resultSet.getInt("s_xb"));
            student_info.setDate(String.valueOf(resultSet.getDate("s_date")));
            student_info.setZhiwu(resultSet.getString("s_zhiwu"));
            student_info.setZzmm(resultSet.getString("s_zzmm"));
            list.add(student_info);
        }
        kulsUtils.closeConn(dbConn);
        return list;
    }
    public int queryCount() throws SQLException {
        KulsUtils kulsUtils = new KulsUtils();
        Connection dbConn = kulsUtils.createDBConn();
        String sql = "select count(*) from tb_student_info ";
        PreparedStatement preparedStatement = dbConn.prepareStatement(sql);
        ResultSet query = preparedStatement.executeQuery();
        int queryCount = 0;
        while (query.next()){
            queryCount=query.getInt(1);
        }
        kulsUtils.closeConn(dbConn);
        return queryCount;


    }

    public boolean update(Tb_student_info student_info) throws SQLException {
        KulsUtils kulsUtils = new KulsUtils();
        Connection dbConn = kulsUtils.createDBConn();
        String sql = "update tb_student_info set s_name=?,s_xb=?,s_date=?,s_minzu=?,s_zzmm=?,s_zhiwu=? where s_id=?";
        PreparedStatement preparedStatement = dbConn.prepareStatement(sql);
        preparedStatement.setString(1,student_info.getName());
        preparedStatement.setInt(2,student_info.getXb());
        preparedStatement.setString(3,student_info.getDate());
        preparedStatement.setString(4,student_info.getMinzu());
        preparedStatement.setString(5,student_info.getZzmm());
        preparedStatement.setString(6,student_info.getZhiwu());
        preparedStatement.setInt(7,student_info.getId());
        int i = preparedStatement.executeUpdate();
        kulsUtils.closeConn(dbConn);
        if (i>0){
        return true;
        }else{
            return false;
        }


    }

    public boolean delete(int id) throws SQLException {
        KulsUtils kulsUtils = new KulsUtils();
        Connection dbConn = kulsUtils.createDBConn();
        String sql = "delete from tb_student_info where s_id=?";
        PreparedStatement preparedStatement = dbConn.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int i = preparedStatement.executeUpdate();
        kulsUtils.closeConn(dbConn);
        if (i>0){
            return true;
        }else {
            return false;
        }

    }
}
