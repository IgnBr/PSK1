package com.example.mybatis.dao;

import com.example.mybatis.model.University;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface UniversityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    int insert(University record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    University selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    List<University> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.UNIVERSITY
     *
     * @mbg.generated Tue May 03 23:31:01 EEST 2022
     */
    int updateByPrimaryKey(University record);
}