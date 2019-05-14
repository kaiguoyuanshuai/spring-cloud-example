package com.zcoco.springcloud.alibaba.repertory.mapper;

import com.zcoco.springcloud.alibaba.api.vo.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/5/10
 */
@Mapper
public interface CityMapper {
    // @Select("SELECT * FROM USER WHERE id = #{id}")
    City findById(@Param("id") String id);

    int saveCity(City city);
}
