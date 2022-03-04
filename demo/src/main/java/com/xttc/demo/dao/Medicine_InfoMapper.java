package com.xttc.demo.dao;

import com.xttc.demo.pojo.Medicine_Info;
import java.util.List;

public interface Medicine_InfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medicine_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medicine_info
     *
     * @mbggenerated
     */
    int insert(Medicine_Info record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medicine_info
     *
     * @mbggenerated
     */
    Medicine_Info selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medicine_info
     *
     * @mbggenerated
     */
    List<Medicine_Info> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table medicine_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Medicine_Info record);
}