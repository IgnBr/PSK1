package com.example.mybatis.dao;

import com.example.mybatis.model.Student;
import java.util.List;
import org.mybatis.cdi.Mapper;

@Mapper
public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    Student selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    List<Student> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.STUDENT
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    int updateByPrimaryKey(Student record);
    List<Student> selectStudentsForUniversity(Integer id);
}