package com.zkzong.mybatis.sqlproviders;

import com.zkzong.mybatis.domain.Tutor;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by Zong on 2017/3/12.
 */
public class TutorDynaSqlProvider {

    public String findAllTutorsSql() {
        return new SQL() {
            {
                SELECT("tutor_id as tutorId, name, email");
                FROM("tutors");
            }
        }.toString();
    }

    public String findTutorByIdSql(final int tutorId) {
//        return new SQL() {
//            {
//                SELECT("tutor_id as tutorId, name, email");
//                FROM("tutors");
//                WHERE("tutor_id = #{tutorId}");
//            }
//        }.toString();

        return new SQL() {
            {
                SELECT("tutor_id as tutorId, name, email");
                FROM("tutors");
                WHERE("tutor_id = " + tutorId);
            }
        }.toString();
    }

    public String findTutorByNameAndEmailSql(Map<String, Object> map) {
//        String name = (String) map.get("name");
//        String email = (String) map.get("email");
//        System.out.println(name + ":" + email);

        return new SQL() {
            {
                SELECT("tutor_id as tutorId, name, email");
                FROM("tutors");
                WHERE("name=#{name} and email=#{email}");
            }
        }.toString();
    }

    public String insertTutor(final Tutor tutor) {
        return new SQL() {
            {
                INSERT_INTO("tutors");

                if (tutor.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (tutor.getEmail() != null) {
                    VALUES("email", "#{email}");
                }
            }
        }.toString();
    }

    public String updateTutor(final Tutor tutor) {
        return new SQL() {
            {
                UPDATE("tutors");

                if (tutor.getName() != null) {
                    SET("name = #{name}");
                }
                if (tutor.getEmail() != null) {
                    SET("email = #{email}");
                }
                WHERE("tutor_id = #{tutorId}");
            }
        }.toString();
    }

    public String deleteTutor(int tutorId) {
        return new SQL() {
            {
                DELETE_FROM("tutors");
                WHERE("tutor_id = #{tutorId}");
            }
        }.toString();
    }

    public String selectTutorById() {
        return new SQL() {
            {
                SELECT("t.tutor_id, t.name as tutor_name, email");
                SELECT("a.addr_id, street, city, state, zip, country");
                SELECT("course_id, c.name as course_name, description, start_date, end_date");
                FROM("tutors t");
                LEFT_OUTER_JOIN("addresses a on t.addr_id = a.addr_id");
                LEFT_OUTER_JOIN("courses c on t.tutor_id = c.tutor_id");
                WHERE("t.tutor_id = #{id}");
            }
        }.toString();
    }
}
