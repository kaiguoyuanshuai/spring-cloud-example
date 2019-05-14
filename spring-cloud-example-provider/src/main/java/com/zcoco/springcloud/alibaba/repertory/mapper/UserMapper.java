package com.zcoco.springcloud.alibaba.repertory.mapper;

import com.zcoco.springcloud.alibaba.api.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 * 描述:
 * @auth zhengkk19738
 * @time 2019/5/10
 */
@Mapper
public interface UserMapper {
    // @Select("SELECT * FROM USER WHERE id = #{id}")
    User findById(@Param("id") String id);

    int saveUser(User user);
}
