package com.zdzc.electrocar;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"com.zdzc.electrocar.mapper","org.dozer"})
public class Application extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);

		// 初始化转换器
		FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
		// 初始化一个转换器配置
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");    // 自定义时间格式
		fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
		// 将配置设置给转换器并添加到HttpMessageConverter转换器列表中
		fastConvert.setFastJsonConfig(fastJsonConfig);

		converters.add(fastConvert);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
