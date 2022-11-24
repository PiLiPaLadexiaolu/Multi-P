package com.sxd.apimobile.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String... arg) {
        // 代码生成器 右键直接执行
        FastAutoGenerator.create("jdbc:mysql://1270.0.1:3306/test1?useUnicode=true&characterEncoding=UTF-8", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("axd") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.sxd.apimobile") // 设置父包名
                            .moduleName("svc") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://code/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("test_info") // 设置需要生成的表名
                            .addTablePrefix("", ""); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
