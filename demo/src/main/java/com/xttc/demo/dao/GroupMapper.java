package com.xttc.demo.dao;

import com.xttc.demo.pojo.Group;
import java.util.List;

public interface GroupMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer parentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    int insert(Group record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    Group selectByPrimaryKey(Integer parentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    List<Group> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Group record);
}