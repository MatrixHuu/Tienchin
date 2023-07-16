package org.javaboy.tienchin;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/7/12 23:38
 */
@SpringBootTest
public class GenerateCode {

    String path = "D:\\code\\java_project\\tienchin\\tienchin-channel\\src\\main\\";
    @Test
    void generateChannelCode() {
        FastAutoGenerator.create("jdbc:mysql:///tienchin-video?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8", "root", "root")
                .globalConfig(builder -> {
                    builder.author("xyma") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(path + "/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("org.javaboy.tienchin") // 设置父包名
                            .moduleName("channel") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, path + "/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("tienchin_channel") // 设置需要生成的表名
                            .addTablePrefix("tienchin_", "tienchin_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
