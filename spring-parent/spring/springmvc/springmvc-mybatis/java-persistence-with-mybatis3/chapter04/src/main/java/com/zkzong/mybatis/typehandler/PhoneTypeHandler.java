package com.zkzong.mybatis.typehandler;

import com.zkzong.mybatis.domain.PhoneNumber;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Zong on 2017/3/10.
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, PhoneNumber phoneNumber, JdbcType jdbcType) throws SQLException {
        ps.setString(i, phoneNumber.getAsString());
    }

    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return new PhoneNumber(resultSet.getString(columnName));
    }

    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return new PhoneNumber(resultSet.getString(columnIndex));
    }

    @Override
    public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return new PhoneNumber(cs.getString(columnIndex));
    }
}
