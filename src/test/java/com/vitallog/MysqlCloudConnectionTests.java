package com.vitallog;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;

@SpringBootTest
public class MysqlCloudConnectionTests {
    @Autowired
    DataSource dataSource;

    @DisplayName("MySQLCloud 연결 테스트")
    @Test
    void mysql_connection_test(){
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("MySQL 연결 성공! 실제 연결 정보 = " + conn.getMetaData().getURL());
        } catch (Exception e) {
            System.out.println("MySQL 연결 실패!");
            e.printStackTrace();
            fail("MySQL 연결에 실패했습니다.");
        }
    }

}