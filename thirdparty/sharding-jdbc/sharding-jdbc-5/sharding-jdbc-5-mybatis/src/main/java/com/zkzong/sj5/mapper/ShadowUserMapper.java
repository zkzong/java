
package com.zkzong.sj5.mapper;

import com.zkzong.sj5.entity.ShadowUser;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ShadowUserMapper {

    void createTableIfNotExists();

    void truncateTable();

    void dropTable();

    int insert(ShadowUser shadowUser);

    void delete(Long userId, boolean shadow);

    default List<ShadowUser> selectAll() throws SQLException {
        List<ShadowUser> result = new ArrayList<>();
        result.addAll(selectAllByShadow(true));
        result.addAll(selectAllByShadow(false));
        return result;
    }

    List<ShadowUser> selectAllByShadow(boolean shadow) throws SQLException;
}
