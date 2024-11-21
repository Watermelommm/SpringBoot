# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.3/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.3/maven-plugin/build-image.html)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#using.devtools)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the project POM.
While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the
parent.
To prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.

### Spring IoC
    inversion of Control ���Ʒ�ת


### Spring AOP
    AOP: Aspect-Oriented Programming,���������,�������е�ģ�鰴��"����"��֯ ʹ���໥֮��û��ֱ��Ӱ���һ�ֱ�̷�ʽ���Ȳ�Σ���
    
    ����ģʽ�����ģʽ����
        ��̬���������� ������ҵ�����ɽӿڣ�����Ŀ����ʹ�����ֱ���иýӿڵ�ʵ�֣�����ڴ��������Խӿڶ�������Ա��������ɶ�Ŀ���������롣

        ��̬���������� ���Զ�������࣬���Ǵ���һ��ʹ��invocationHandler�ӿڵ��࣬��������н���Ŀ�����е�ҵ����������������Ĺ�ϵ��

            ע�⣺��̬������Ҫ�ڴ��������趨Ŀ���࣬���̻��˴����ϵ������̬�����޴����࣬�ڳ������й����У���̬�趨Ŀ���� �����ҵ��������ӿڣ���
                �ʹ����ִ���ࣨInvocationHandler����󣩡�


    AOP���
        ���棨Aspect���������� ���ܵķ�װ�࣬������Ĺ��ܵķ�װ��  (������ ��֯�����棩)
        ֪ͨ��Advice���������� ����Ĺ��� (��֯��ķ���)
        ���ӵ㣨JoinPoint���������� ����������Ĺ���ִ�еĵ��ò���(����ִ֪ͨ�е����)
        ����㣨Poincut���������� �������ӵ�ĸ�ʽ


    AOP��ʵ�ֹ���
        ���裺
            1.����jar����Spring Ioc�����+ AOP��������
            2.����ҵ��ӿ� ���� ʵ����
            3.�������棨@Aspect��
            4.���������ǩ����@Pointcut��
            5.����֪ͨ��@Befor��
            6.��ac.xml�ļ���ʹ��<aop:aspectj-autoproxy/>����AOP

        ע�⣺
            1.�����ǩ���ĸ�ʽ�������� execution(Ȩ�����η� ����ֵ���� ����.����/�ӿ���.������(�����б�)throws �쳣����)
            2.��������ʱ��ʹ��@Conponet
            3.֪ͨ���ࡪ����@Before,@AfterReturing,@AFterThrowing,@Around,@After
            4.֪ͨ�ĸ�ʽ������@֪ͨ���("ǩ��") / @֪ͨ���(pointcut="execution(��ʽ)")
            5.��ִ��AOPʱ������getBean("id ֵ")�������ص��ǽӿڶ���


    ��ȡ���ӵ���ύ����:
            ��������֪ͨ�Ĳ���λ�ã�����JoinPoint����������
            ��֪ͨ�У����ò���JoinPoint����ִ��getArgs()����
            
    AOP֪ͨ��ʹ��
        1.Before֪ͨ

           ��ʽ�� @Before

            ִ���ص㣺�����ӵ�֮ǰ���ִ��

        2.AfterReturning֪ͨ
           ��ʽ�� @AfterReturning(poincut = "ǩ��/execution/", returing = "���ӵ㷵��ֵ������")
                public void xxx(�������� ������)
            
            ִ���ص㣺�����ӵ�ִ��֮�����ִ�� �����ɻ�����ӵ㷵��ֵ

                ע��: AfterReturning ���Է���ֵ���ж����� ���ܸı����ӵ�ķ���ֵ
                        JoinPoint ����������ʱ������λ��֪ͨ�ĵ�һ����λ

        3.AfterThrowing֪ͨ
        
            ��ʽ��@AfterThrowing(pointcut = "ǩ��/execution" , throwing = "���ӵ��׳����쳣������")
                    public void xxx(�쳣�� �쳣������)
            
            ִ���ص�: �����ӵ�ִ�й������׳��쳣ʱ�������쳣����

            
        4. Around֪ͨ
            
            ��ʽ�� @Around("ǩ��/execution()")
            
            ִ���ص㣺 �����ӵ���̵� ǰ �� �� ���ִ��

            ע�⣺ʹ��Around֪ͨ ��ҪProceedingJoinPoint��������� ���ֶ�����proceed()/proceed(Object[] o)������������ӵ��ִ�С�
                ��ʱ,proceed(....)���Ըı����ӵ���ύ�����ͷ���ֵ;

        5. After֪ͨ
            ��ʽ�� @After("ǩ��/execution")
            ִ���ص�: �����ӵ�֮�����ִ��
            
            ע�⣺��ִ֪ͨ��˳�� around before -> before -> ���ӵ� -> around after -> after -> afterReturning



[//]: # (test: ��aop���� ���������ε����� ������� Ҫ��aopʵ�֣�1.������������ֵ �и��� ����aop����ת������)

[//]: # (                                                2.������������ж��������ǲ��Ǹ�ֱ��������)



### SpringBoot����
    ����: ��һ������SpringMVC��WebӦ�ó�����
    �ص㣺
        Լ����������
        ���伴��
        ֧��΢����
    
    SpringBootʹ�ò��裺
        1. ����maven ��������(����ֿ� jar���ı��ش洢λ��)
        2. ��idea�´���springboot��Ŀ �趨groupld(cn.edu.ccut)��artifactld(frispringboot)
        3. ��staticĿ¼�´�����̬�ļ�(��ֱ�Ӵ� ���辭��springboot)
        4. ��jvavĿ¼�´���controllerĿ¼�Լ�Controller�࣬��������ʹ��@Controller��ע�࣬ʹ��@RequestMapping��ע����ķ���
        5. ��templateĿ¼�£�������springboot���ʵ�html�ļ����ļ�����Ҫ����thymeleaf
    
        ע�⣺
            staticĿ¼�·��þ�̬��Դ������js�ļ���css�ļ���ͼƬ�Ϳ�ֱ�ӷ��ʵ�ҳ��
            templatesĿ¼�·���Controller���ʵ�ҳ��
            ͨ��Controller����templates��ԴĬ��Ϊת������ʹ�á�redirect:��Դ������Ϊ�ض���ʽ����staticĿ¼�µ�ҳ��
            pom.xml��POM -- Project Object Model����Maven�������ļ�������������Ŀ�������͹�����Ŀʱ��Ҫ�õ��Ĳ��
                ��ʽ��
                    <project>
                        <groupld>��������</groupld>
                        <artfactld>��Ŀ����</artfactld>

                        ......
                        <dependencies>
                            <dependency>
                                <groupid></groupid>
                                <artifactid></artifactid>
                                
                                <scope>��������������ĸ��׶������� (compile / provided / runtime / test / system)</scope>
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
            
    

    
    SpringBoot����ע��
        1. ����ע�⣺
    
                SpringBootApplication: @SpringBootApplication ���ã���ע������
                Controller : @Controller ���ọ̈���ע��������
                RestController: @RestController ���ã����ڱ�ע���и��������ص�PO���� ��json������ʽ���н���
                Service: @Service("id ֵ")
                Repository: @Rrpository("id") ���ã���ע����DAO��
                Component: @Component("id") ���ñ�ע������
                RequestMapping: @RequestMapping("���ʲ㼶") ���ã�����һ�����ʲ㼶
    
        2. Controller���з����ϵ�ע�⣺
                
                ������ʽ��public ����ֵ���ͣ�ModelAndView / String / void / ������������ / PO���� / ResponseEntity���� / ���϶��� 
                        �����������ύ����ͬ���Ĳ��� / ��װͬ���ύ������PO���� / request���� / response���� / session���� / Model����
                
                        Model.addAttribute("key" , ֵ) ��ͬ�ڴ洢��request

                    ע�� ���洢��Model�е����ݣ�����thymeleafģ��ҳ���л�ȡ${key}
                
                
                @RequestMapping("�����ʽ" / value="�����ʽ" , method="���󷽷�") 
                ���ã��趨�Է����������ʽ

                @PathVariable(value = "·��������")
                ���ã���ȡ������ʸ�ʽʱ����ʽ�е�·��ֵ�����ʸ�ʽ--xxxController/{·��������}
                ע�⣺���ʡ��value���ԣ�����뱣֤·���������뷽��������һ��

                @RequestParam(value = "�ύ������")
                ���ã����ύ����ֵ���ݸ����εķ�������
                
                @ModelAttribute("��")
                ���ã�Ӧ����PO������ʽ�ķ�����������ʾ���ò���ֱ�ӷ���Model
                
                @RequestBody
                ���ã�Ӧ����PO���󣬱�ʾ���ύ��JSON�����ݸ���PO����
                
                @ResponseBody
                ���ã���Ӧ���ڷ���֮�ϻ򷽷�����ֵ����֮ǰ����ʾ���������ص�PO����ת����JSON��

                

        3. Ӧ���ڳ�Ա������ע��
            
                ��ʽ�� @Autowired
                ���ã� ���������͵Ķ����Զ�ע�����ע�ĳ�Ա����
                
                ��ʽ�� @Qualifier("Bean����id")
                ���ã� ��idֵѰ�ұ�ע��Ķ������ע�ĳ�Ա����

                ��ʽ�� @Scope("propotype/singleton")
                ���ã� ָ�����ص�bean�����Ƿ�Ϊ����
            
                ��ʽ�� @Lazy(true/false) Ĭ��ֵtrue �ӳټ���
                ���ã� ��ʾ�����ڵ�Bean���󴴽�ʱ�Ƿ���ر�ע�ĳ�Ա����

        JSONר�⣺
            ��� һ����js������ʽ��ʾ���ݲ㼶��ϵ���ַ���
            ���ã� Ӧ�ó����в�ͬ�㼶��ҵ���������ݵĸ�ʽ
            ������ var jsonStr =JSON.stringify(JS����);
                                (jQuery�е�һ�����ö���)
        


        �첽�ύ��ʽ��
            $.ajax({
                url:"�ύ��ַ",
                contentType:"�ύ���ݵ���������(application/json;charset=utf-8)/(application/x-www-form-urlencode;charset=utf-8)",
                data:�ύ������,
                type:"post/get/delete/put",
                dataType:"�ش����ݵ�����",   //<-----json
                statusCode:{
                    200:function(returnData){
                            //ִ�в���
                        },
                    
                

                }
                            
                
            });


            ע�⣺ʹ��@RequestBody�ڲ���PO����֮ǰ���Ի�ȡ�ύ��JSON����
                 ʹ��@ResponseBody�ڷ���ֵ����֮ǰ�����󷽷�֮�ϣ��Ա�֤����ֵ��װ��JSON��
                 ��ʹ��Ĭ�ϵ�contentTypeʱ���ύ������js����
                 ��Ӧ����function�Ĳ����������֣��ֱ�Ϊ--returnData��status��xhr����ʾ�洢����ֵ���洢��Ӧ��״̬�ʹ洢�������Ӧ��Ϣ����ʹ��ʱ���ɸ������ѡ��ʹ�õ������ƻ�ǰ���ϵ��
                 ��ʹ��
                    succuss:function(returnData){
                        //����ɹ���Ĵ���
                    }
                     error:function(){
                        //����ʧ�ܺ�Ĵ���
                    }
                    
                 error�еĲ���ֻ��status��xhr


            4.RESTful���
                
                �����һ������Ӧ�ó����������Դ�������ʽ
                ��׼��
                    1.ʹ��uri��ʾ�������Դ  Unit Resource Identifier ͳһ��Դ��λ��
                    2.ʹ������ʽ��ʾ���ܴ���
                        �� -- post
                        ɾ -- delete
                        �� -- put
                        �� -- get
                    3.��״̬
                    ����Ҫ��������ʱ���������ܲ�����Ŀ�ꣻ����ӦʱҪ��Ȼش������ֻش���Ӧ���
                    4.SpringBoot ��RESTful��̷��ʹ��
                        ���裺
                            �ھ�̬ҳ��������$.ajax(......) ���������Controller���첽�ύ
                            ��Controller�У�����@RestController��עController������@XxxMapping��ע���󷽷�������@RequestBody��ע���󷽷��Ĳ���
                            ����ResponseEntity��Ϊ���󷽷��ķ���ֵ���ͣ����ڷ���ֵ�з�װ�ش������ݺ���Ӧ��״̬��
                        ע�⣺
                            ������ɹ�ʱ������ֵ����дΪResponseEntity.ok(po����)������ResponseEntity.status(200/404/500).body(po����)
                            ���޻ش�����,���ʽΪResponseEntity.status(״̬��).build()

                            ��ҳ���ж�״̬�������Ӧ�ĺ�����ʽ�����ࣺ
                                �ɹ���ʽ------- function(returndata[,status,xhr])
                                ʧ�ܸ�ʽ------- function(xhr[,status,exception])
                    
                        


                    5.yml�ļ�
                        ���ã�SpringBoot�������ļ� yet another markup language
                        ��ʽ����״ ������ʽ
                                ���ڵ�:
                                  �ӽڵ�:
                                    Ҷ�ӽڵ�: ֵ
                        
                        ���ӣ�
                                server:
                                    port: 9090
                        ע�⣺
                            �ļ�Ĭ������Ϊapplication.properties / application.yml
                            �ļ�λ��main/resourcesĿ¼��
                            application.properties �ĸ�ʽΪ server.port = 9090
                        yml����ֵ��ʽ��
                            ����ֵ -- true/false
                            ��ֵ -- 8080 ��100 �� 3.14
                            ��ֵ -- null
                            �ַ��� -- /xyz ��"/xyz"
                            Dateֵ -- 2024/10/29
                            ����/List/Set -- [ֵ1��ֵ2��ֵ3]
                            ����/map -- {������1 : ֵ1 , ...........}
                            ����/List/Set�Ͷ���/Map Ҳ���Բ������²˵���ʽ���и�ֵ -- 
                                - ֵ1            ������1 ��ֵ1
                                - ֵ2            ������2 ��ֵ2
                                - ֵ3            ������3 ��ֵ3
                                

                                ��yml���������ֵ -- ${random.int} , ${random.double} , ${random.uuid}

                        yml�ļ��Ķ�ȡ
                            yml���ݸ�ֵ��Bean
                                ����bean�࣬���Ա��������yml����Ӧ�����Ա������һ�£�������get/set����
                                ��bean����ʹ��@Component��@ConfigurationProperties("yml�е���Ӧ������")
                                ��Controller��������bean��������Ա��������Ϊ�����@Autowired



### SpringBoot����Mybatis **************************************************************


    ���裺
        1.����������SpringBoot , DB Driver , Mybatis
        2.�������ݿ��ṹ����PO��
        3.��resourceĿ¼�´���ӳ���ļ�(XxxMapper.xml),���������ļ�������mybatis.mapper-locations��������ӳ���ļ�������
        4.�������ļ��У����������ݿ������صĲ��� driver-class-name , url , username , password 
        5.����ӳ���ļ����� ӳ��ӿڣ������������@Mapper
        6.����Service�ӿڼ���ʵ���࣬�����������@Service,������ӳ��ӿڶ�������Ա���������ʹ��@Autowired���ע��
        7.����Controller�࣬���������@RestControler��@Controller��������Service�ӿڶ�������Ա��������ʹ��@Autowired����ע�롣���ʹ��@XxxMapping��ע���󷽷�
        8.�༭ǰ��ҳ��
            

                    
                            
                        
        
            

            
            

                
                
                
                



