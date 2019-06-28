springboot2.x学习模块
地址：https://so.csdn.net/so/search/s.do?p=2&q=springboot+2.1&t=blog&domain=&o=&s=&u=java_cxrs&l=&f=&rbg=0

springboot 2.1 实践教程（四)-相关配置.YAML格式
1. @Value
2. @ConfigurationProperties
3. yml内random

springboot 2.1 实践教程（五)-多环境配置
1. 激活配置 spring.profiles.active = *** 与application-***.yml对应
2. 包含配置 spring.profiles.include
3. 激活包含搭配使用

springboot 2.1 实践教程（六)-日志配置
1. springboot 自动读取 resources目录下logback-spring.xml作为日志配置文件
2. property标签，有name和value，使用${}取值
3. appender标签，追加，通过appender标签的信息进入root，logger下
4. file标签，指定日志输出位置与文件名
5. rollingPolicy标签，日志回滚策略
6. fileNamePattern标签，回滚文件名
7. maxHistory,日志最大历史天数
8. encoder日志输出模板
9. filter，appender过滤条件,LevelFilter相等匹配，ThresholdFilter，大于等于匹配,通过过滤器的进入logger/root
10. logger指定哪个包或类的输出级别
11. root跟logger

springboot 2.1 实践教程（七)-开发Web应用
1. springboot模板引擎 Thymeleaf
2. templaates/error下建立404.html/500.html/4xx.html 出现对应异常会跳转到对应错误码

springboot 2.1 实践教程（八)-国际化
1. resource下建立文件夹i18n，新建3个文件message.properties,message_zh_CN.properties,message_en_US.properties
2. 国际化配置类I18nConfig实现WebMvcConfigurer接口
3. 模板通过#{property}获取，后端通过Locale locale = LocaleContextHolder.getLocale(); messageSource.getMessage("welcome", null, locale) 获取

springboot 2.1 实践教程（十)-嵌入式Servlet容器支持
1. springboot支持嵌入式tomcat,jetty,undertow等web服务器支持，默认tomcat,若要选用其他，在依赖中排除tomcat，引入其他依赖





