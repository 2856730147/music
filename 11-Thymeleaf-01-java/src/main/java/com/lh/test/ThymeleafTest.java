package com.lh.test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresource.ClassLoaderTemplateResource;

//测试非web环境下使用thymeleaf
public class ThymeleafTest {
    @Test
    public  void testRenderStaticData(){
        //创建一个模板引擎对象
        //万物皆对象，使用TemplateEngine对象完成后续的操作
        TemplateEngine engine = new TemplateEngine();

        //准备一个模板
        //th:value是模板引擎所支持的标签属性
        //能够被thymeleaf所识别
        //有点类似jstl的扩展标签
        //被th：value标签的内容就是我们刚刚提到的占位符
        //可以给占位符传递参数所替代
        //替换后的效果和value属性是一样的
        String template="<input type='text' th:value='易烊千玺'>";

        //准备一个环境对象,给模板引擎提供一个可运行的环境
        Context context = new Context();

        //使用模板引擎去处理模板(渲染)
        //获取处理好(渲染)好的页面
        String process = engine.process(template, context);
        System.out.println(process);
    }
    //测试渲染动态数据
    @Test
    public void testRenderDynamicData(){
        //创建一个模板引擎的对象
        TemplateEngine engine = new TemplateEngine();

        //准备一个模板(动态模板)
        //注意，把静态的数据使用${}的方式变为动态的占位符，等会可以传递参数
        //外面的th：value就能被模板引擎所识别，并替换
        //和jsp的el表达式一模一样
        String template="<input type='text' th:value='${name}'>";
        //创建一个环境对象
        //就类似jsp中的ServletContext
        Context context = new Context();
        //设置占位符所对应的参数
        //当做成域对象.setAttribute(key,value)
        context.setVariable("name","易烊千玺");
        String process = engine.process(template, context);
        System.out.println(process);

    }

    //直接渲染一个html页面
    @Test
    public void testRenderHtml(){
       //创建一个模板引擎的对象
        TemplateEngine engine = new TemplateEngine();

        //这个时候不需要准备模板l，但是需要加载html
        //所以要准备一个html解析器
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        //给引擎设置解析器
        engine.setTemplateResolver(resolver);

        Context context = new Context();

        context.setVariable("name","马可波罗");
        //直接创建一个路径和环境对象就行了
        String process = engine.process("templates/main.html", context);
        System.out.println(process);

    }
    //如果我们有很多公共的前后缀时可以提供这种方式来手动设置前后缀
    @Test
    public void testPrefixAndSuffix() {
        //创建一个模板引擎的对象
        TemplateEngine engine = new TemplateEngine();

        //准备一个解析器用来进行html
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();


        //设置前后缀
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");

        //给模板引擎设置解析器
        engine.setTemplateResolver(resolver);

        Context context = new Context();
        context.setVariable("name","考牌偶发");

        //获取渲染后的hgtml页面
        //因为我们手动设置了前后缀，所以只有文件名就行了
        String html = engine.process("main", context);

        System.out.println(html);

    }







}
