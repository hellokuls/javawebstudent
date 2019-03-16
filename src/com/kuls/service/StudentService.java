package com.kuls.service;

import com.kuls.bean.Page;
import com.kuls.bean.Tb_student_info;
import com.kuls.dao.StudentDao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class StudentService {
    public boolean add(String name, int xb, String data, String minzu, String zzmm, String zhiwu) throws SQLException {
        StudentDao studentDao = new StudentDao();
        boolean b = studentDao.add(name,xb,data,minzu,zzmm,zhiwu);
        return b;
    }

    public List<Tb_student_info> getstudents() throws SQLException {
        StudentDao studentDao1 = new StudentDao();
        List<Tb_student_info> students = studentDao1.getStudents();
        return students;
    }

    public Page getPageStudents(int currentPage,int currentCount) throws SQLException {
        StudentDao studentDao1 = new StudentDao();
//        private int totalPage; //总页数
//        private int currentPage; //当前页数  从前端获取
//        private int currentCount; //当前页显示的数目   从前端获取
//        private int totalCount; //总共的数据
        //查询出学生总数
        int totalCount = studentDao1.queryCount();
        System.out.println("totalCount"+totalCount);
        // ceil函数是取最大整数
        int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
        System.out.println("totalPage"+totalPage);
        Page page = new Page();
        page.setCurrentCount(currentCount);
        page.setCurrentPage(currentPage);
        page.setTotalCount(totalCount);
        page.setTotalPage(totalPage);
         //计算出起始位置
        int startPosition = (currentPage-1)*currentCount;
        List<Tb_student_info> students = studentDao1.getPageStudents(startPosition,currentCount);
        page.setList(students);
        return page;
    }

    public boolean update(Tb_student_info student_info) throws SQLException {
        StudentDao studentDao = new StudentDao();
        boolean b = studentDao.update(student_info);
        return b;
    }

    public boolean delete(int id) throws SQLException {
        StudentDao studentDao = new StudentDao();
        boolean b = studentDao.delete(id);
        return b;
    }
}
