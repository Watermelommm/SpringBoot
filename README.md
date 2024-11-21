# SpringBoot
study github test


### SpringBoot概述
    概念: 是一个基于SpringMVC的Web应用程序框架
    特点：
        约定大于配置
        开箱即用
        支持微服务
    
    SpringBoot使用步骤：
        1. 配置maven 构建工具(镜像仓库 jar包的本地存储位置)
        2. 在idea下创建springboot项目 设定groupld(cn.edu.ccut)和artifactld(frispringboot)
        3. 在static目录下创建静态文件(可直接打开 无需经过springboot)
        4. 在jvav目录下创建controller目录以及Controller类，并在类中使用@Controller标注类，使用@RequestMapping标注请求的方法
        5. 在template目录下，创建被springboot访问的html文件，文件中需要引入thymeleaf
    
        注意：
            static目录下放置静态资源，包括js文件，css文件，图片和可直接访问的页面
            templates目录下放置Controller访问的页面
            通过Controller访问templates资源默认为转发，可使用”redirect:资源名“改为重定向方式访问static目录下的页面
            pom.xml（POM -- Project Object Model）是Maven的配置文件，用于设置项目的依赖和构建项目时需要用到的插件
                格式：
                    <project>
                        <groupld>机构名称</groupld>
                        <artfactld>项目名称</artfactld>

                        ......
                        <dependencies>
                            <dependency>
                                <groupid></groupid>
                                <artifactid></artifactid>
                                
                                <scope>被引入的依赖在哪个阶段起作用 (compile / provided / runtime / test / system)</scope>
                            </dependency>
                        </dependencies>

                        <build>
                            <plugins>
                                <plugin>
                                    <groupid> </groupid>
                                    <artifactid> </artifactid>
                                </plugin>
                            </plugins>
                        </build>
            
                    </project>
            
    

    
    SpringBoot常用注解
        1. 类上注解：
    
                SpringBootApplication: @SpringBootApplication 作用：标注启动类
                Controller : @Controller 作用短：标注控制器类
                RestController: @RestController 作用：用于标注类中各方法返回的PO对象 以json串的形式进行解析
                Service: @Service("id 值")
                Repository: @Rrpository("id") 作用：标注类是DAO类
                Component: @Component("id") 作用标注工具类
                RequestMapping: @RequestMapping("访问层级") 作用：设置一个访问层级
    
        2. Controller类中方法上的注解：
                
                方法格式：public 返回值类型（ModelAndView / String / void / 基本数据类型 / PO对象 / ResponseEntity对象 / 集合对象） 
                        方法名（与提交参数同名的参数 / 封装同名提交参数的PO对象 / request对象 / response对象 / session对象 / Model对象）
                
                        Model.addAttribute("key" , 值) 等同于存储在request

                    注意 ：存储在Model中的数据，可在thymeleaf模板页进行获取${key}
                
                
                @RequestMapping("请求格式" / value="请求格式" , method="请求方法") 
                作用：设定对方法的请求格式

                @PathVariable(value = "路径变量名")
                作用：获取定义访问格式时，格式中的路径值，访问格式--xxxController/{路径变量名}
                注意：如果省略value属性，则必须保证路径变量名与方法参数名一致

                @RequestParam(value = "提交参数名")
                作用：将提交参数值传递给修饰的方法参数
                
                @ModelAttribute("键")
                作用：应用于PO对象形式的方法参数，表示蒋该参数直接放入Model
                
                @RequestBody
                作用：应用于PO对象，表示将提交的JSON串传递给该PO对象
                
                @ResponseBody
                作用：可应用于方法之上或方法返回值类型之前，表示将方法返回的PO对象转换成JSON串

                

        3. 应用于成员变量的注解
            
                格式： @Autowired
                作用： 将符合类型的对象自动注入给标注的成员变量
                
                格式： @Qualifier("Bean对象id")
                作用： 按id值寻找被注入的对象给标注的成员变量

                格式： @Scope("propotype/singleton")
                作用： 指定加载的bean对象是否为单例
            
                格式： @Lazy(true/false) 默认值true 延迟加载
                作用： 表示其所在的Bean对象创建时是否加载标注的成员变量

        JSON专题：
            概念： 一种以js对象形式表示数据层级关系的字符串
            作用： 应用程序中不同层级的业务处理交互数据的格式
            创建： var jsonStr =JSON.stringify(JS对象);
                                (jQuery中的一个内置对象)
        


        异步提交格式：
            $.ajax({
                url:"提交地址",
                contentType:"提交数据的内容类型(application/json;charset=utf-8)/(application/x-www-form-urlencode;charset=utf-8)",
                data:提交的数据,
                type:"post/get/delete/put",
                dataType:"回传数据的类型",   //<-----json
                statusCode:{
                    200:function(returnData){
                            //执行操作
                        },
                    
                

                }
                            
                
            });


            注意：使用@RequestBody于参数PO对象之前，以获取提交的JSON数据
                 使用@ResponseBody于返回值类型之前或请求方法之上，以保证返回值封装成JSON串
                 当使用默认的contentType时，提交数据是js对象
                 响应函数function的参数包括三种，分别为--returnData，status，xhr，表示存储返回值，存储响应的状态和存储整体的相应信息。在使用时，可根据情况选择使用但不能破坏前后关系。
                 可使用
                    succuss:function(returnData){
                        //请求成功后的处理
                    }
                     error:function(){
                        //请求失败后的处理
                    }
                    
                 error中的参数只有status和xhr


            4.RESTful风格
                
                概念：是一种网络应用程序中相关资源的请求格式
                标准：
                    1.使用uri表示请求的资源  Unit Resource Identifier 统一资源定位符
                    2.使用请求方式表示功能处理
                        增 -- post
                        删 -- delete
                        改 -- put
                        查 -- get
                    3.无状态
                    核心要求：在请求时，表述功能操作和目标；在相应时要求既回传数据又回传响应结果
                    4.SpringBoot 下RESTful编程风格使用
                        步骤：
                            在静态页面下利用$.ajax(......) 方法完成向Controller的异步提交
                            在Controller中，利用@RestController标注Controller，利用@XxxMapping标注请求方法，利用@RequestBody标注请求方法的参数
                            利用ResponseEntity作为请求方法的返回值类型，并在返回值中封装回传的数据和相应的状态码
                        注意：
                            在请求成功时，返回值可以写为ResponseEntity.ok(po对象)，或者ResponseEntity.status(200/404/500).body(po对象)
                            若无回传数据,则格式为ResponseEntity.status(状态码).build()

                            在页面中对状态码进行相应的函数格式分两类：
                                成功格式------- function(returndata[,status,xhr])
                                失败格式------- function(xhr[,status,exception])
                    
                        


                    5.yml文件
                        作用：SpringBoot的配置文件 yet another markup language
                        格式：树状 缩进形式
                                根节点:
                                  子节点:
                                    叶子节点: 值
                        
                        例子：
                                server:
                                    port: 9090
                        注意：
                            文件默认命名为application.properties / application.yml
                            文件位于main/resources目录中
                            application.properties 的格式为 server.port = 9090
                        yml的数值形式：
                            布尔值 -- true/false
                            数值 -- 8080 ，100 ， 3.14
                            空值 -- null
                            字符串 -- /xyz ，"/xyz"
                            Date值 -- 2024/10/29
                            数组/List/Set -- [值1，值2，值3]
                            对象/map -- {属性名1 : 值1 , ...........}
                            数组/List/Set和对象/Map 也可以采用如下菜单形式进行赋值 -- 
                                - 值1            属性名1 ：值1
                                - 值2            属性名2 ：值2
                                - 值3            属性名3 ：值3
                                

                                在yml中生成随机值 -- ${random.int} , ${random.double} , ${random.uuid}

                        yml文件的读取
                            yml数据赋值给Bean
                                创建bean类，其成员变量名与yml中相应对象成员变量名一致，并生成get/set方法
                                在bean类上使用@Component和@ConfigurationProperties("yml中的相应对象名")
                                在Controller类中声明bean对象做成员变量，并为其添加@Autowired



### SpringBoot整合Mybatis **************************************************************


    步骤：
        1.加载依赖：SpringBoot , DB Driver , Mybatis
        2.根据数据库表结构创建PO类
        3.在resource目录下创建映射文件(XxxMapper.xml),并在配置文件中利用mybatis.mapper-locations参数进行映射文件的引入
        4.在配置文件中，设置与数据库访问相关的参数 driver-class-name , url , username , password 
        5.根据映射文件创建 映射接口，并在其上添加@Mapper
        6.创建Service接口及其实现类，并在类上添加@Service,再声明映射接口对象做成员变量，最后使用@Autowired完成注入
        7.创建Controller类，在其上添加@RestControler或@Controller，并声明Service接口对象做成员变量，再使用@Autowired进行注入。最后使用@XxxMapping标注请求方法
        8.编辑前端页面
