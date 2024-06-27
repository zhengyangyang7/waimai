package com.veliona.elemebackend.mapper;

import com.veliona.elemebackend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author veliona
 * @since 2024-06-26 02:55:34
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User searchByUserAccount(String userAccount);
}
