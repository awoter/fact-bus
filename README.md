# fact-bus

## **当前版本**

1.0.0-SNAPSHOT

## **Maven依赖**

```xml

<dependency>

<groupId>com.woter.fact</groupId>

<artifactId>fact-bus</artifactId>

<version>1.0.0-SNAPSHOT</version>

</dependency>

```

## **功能描述**

fact-bus 是基于guava整合spring实现EventBus；主要包括一下几个方面的功能，具体如下：

- [x] 整合spring，handle支持bean注入；  

- [x] 支持同步异步广播事件；

- [x] 自动注册及注销handle；  

## **升级日志** 
   暂无


## **常用功能代码演示**

### ** 示例：导出用户列表 **
```java

public class TestEvent implements BaseEvent{

    private String name;

    public TestEvent(){}

    public TestEvent(String a){
    this.name = a;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}



@Component
public class TestEventHandler extends EventAdapter<TestEvent>{

    private static final Logger logger = LoggerFactory.getLogger(EventBusFacade.class);

    @Override
    public boolean process(TestEvent e) {

      logger.info("==================== 收到测试事件 ===================");

      return true;
    }

}


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
public class TestLaunch {

    @Test
    public void testExecute() {

       EventBusFacade.execute(new TestEvent()); //发布事件

    }

}

```
