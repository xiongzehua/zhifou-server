package com.xiongzehua.freetalk.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiongzehua
 * @date 2019-06-26 14:42
 */
@MapperScan("com.xiongzehua.freetalk.mapper") // 或者不加这个，直接在每一个Mapper上加@Mapper
@Configuration
public class MybatisPlusConfig {
}
