package com.niantou.testcontainer.mysql.test;

import com.niantou.testcontainer.author.JustryDeng;
import com.niantou.testcontainer.mysql.Mysql5_7EnvSupport;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 测试
 *
 * @author {@link JustryDeng}
 * @since 2020/11/13 16:36:21
 */
@Slf4j
@SpringBootTest
public class Mysql5_7Test extends Mysql5_7EnvSupport {
    
    @Resource
    TestMapper testMapper;
    
    @Test
    void one() {
        System.err.println(testMapper.count());
        System.err.println(testMapper.selectAll());
    }
    
    @Mapper
    public interface TestMapper {
        
        @Select("select count(*) from employee")
        int count();
        
        @Select("select * from employee")
        List<Map<String, Object>> selectAll();
    }
    
}
