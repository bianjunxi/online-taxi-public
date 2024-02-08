package com.mi.driveruser.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 自动生成代码工具类
 */
public class MysqlGenerator {
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://192.168.200.130:3306/service_driver_user?characterEncoding=utf-8&serverTimezone=GMT%2B8",
                "root","root")
                //全局配置
                .globalConfig(builder -> {
                    builder.author("Jay").fileOverride().outputDir("D:\\code\\IdeaProject\\online-taxi-public\\service-driver-user\\src\\main\\java");
                })
                //设置包的策略
                .packageConfig(builder -> {
                    //pathInfo mapper文件的设置
                    builder.parent("com.mi.driveruser").pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                            "D:\\code\\IdeaProject\\online-taxi-public\\service-driver-user\\src\\main\\java\\com\\mi\\driveruser\\mapper"));
                })
                //策略
                .strategyConfig(builder -> {
                    builder.addInclude("driver_car_binding_relationship");

                })
                //使用的模板引擎
                .templateEngine(new FreemarkerTemplateEngine())
                //执行
                .execute();
    }
}
