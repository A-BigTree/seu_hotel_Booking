since 2023.04.09

⭐⭐⭐⭐**团队**⭐⭐⭐⭐

- 👨‍💻Shuxin-Wang📫shuxinwang662@gmail.com
- 👨‍💻Haoyang-Chen📫haoyang.chen5@icloud.com
- 👨‍💻Jincheng-Li📫1635461341@qq.com
- 👨‍💻Zesen-Yun📫yunzesen@163.com

---

# 环境配置

## 软件安装

IDEA➕JDK`17`➕MySQL`8.0.32`➕Tomcat`10.1.7`➕Maven`3.9.1`➕Github Desktop

具体安装和环境配置网上有很多，❗版本最好保持一致❗

先把环境配好再用IDEA打开，不然IDEA内置Maven会自动配置可能会用bug❗

## IDEA配置

❗前提先把上面要求的软件和环境都配置好了❗

### Maven配置

文件👉设置👉构建、执行、部署👉构建工具👉Maven👉把Maven主路径改成自己下载的Maven路径👉**应用**

### Tomcat配置

运行👉编辑配置👉左上角加号选择Tomcat服务器👉本地👉如果没有配置过在选择配置，选择自己下载的Tomcat的文件夹👉部署👉加号选择工件，一般情况有两个，开发阶段选择该项目热部署**后面有war:exploded**的那个👉返回服务器👉可以选择浏览器，**执行更新操作选择<u>更新类和资源</u>，切换出IDEA时选择<u>更新类和资源</u>**，为了分辨配置可以修改上方的名称，也可以不改👉**确定**

运行项目看看是否自动打开浏览器，成功OK了。

## 配置文件

❗在路径`src/main/resources`新建数据库配置文件`druid.properties`，❗文件后缀名就是`*.properties`❗

因为每个的数据库用户名和密码不一致，配置如下：

```properties
# 实现驱动不用改
jdbc.driver=com.mysql.cj.jdbc.Driver
# 目标数据库，改成数据集所在数据库名，比如数据集在hotel数据库中
jdbc.url=jdbc:mysql://localhost:3306/hotel
# 用户名，一般是root
jdbc.username=root
# 密码，用自己的密码
jdbc.password=123456
# 下面是数据库连接池相关设置不用改
jdbc.initialSize=10
jdbc.maxActive=40
jdbc.maxWait=10000
```



# 项目路径说明

```bash
`--pom.xml（Maven配置文件）
`--README.md
|
|--src
|	|--main（开发文件夹）
|	|	|--java（代码区）
|	|	|	|--booking（组织文件夹）
|	|	|	|	|--entity（实体定义）
|	|	|	|	|	`--Example.java
|	|	|	|	|
|	|	|	|	|--handler（控制层类）
|	|	|	|	|	`--ExampleHandler.java
|	|	|	|	|
|	|	|	|	|--mapper（持久化层接口）
|	|	|	|	|	`--ExampleMapper.java
|	|	|	|	|
|	|	|	|	|--service（逻辑业务层）
|	|	|	|	|	|--api（业务接口）
|	|	|	|	|	|	`--ExampleService.java
|	|	|	|	|	|
|	|	|	|	|	|--impl（业务接口实现类）
|	|	|	|	|	|	`--ExampleServiceImpl.java
|	|	|
|	|	|--resources（配置资源文件夹）
|	|	|	`--druid.properties（Druid数据库连接池配置，每个人不一样需要配置）
|	|	|	`--logback.xml（日志打印格式配置）
|	|	|	`--mybatis-config.xml（Mybatis全局配置文件）
|	|	|	`--spring-mvc.xml（SpringMVC-IOC配置）
|	|	|	`--spring-persist.xml（Spring持久化层-IOC配置）
|	|	|	|
|	|	|	|--booking.mapper（Mybatis Mapper接口配置）
|	|	|	|	`--ExampleMapper.xml（ExampleMapper接口配置文件）
|	|	|	
|	|	|--webapp（网页视图文件夹）
|	|	|	`--web.xml（Web应用配置文件）
|	|	|	|
|	|	|	|--script（JS脚本文件）
|	|	|	|	`--example.js
|	|	|	|
|	|	|	|--css（css文件）
|	|	|	|	`--Example.css
|	|	|	|
|	|	|	|--image（图片文件）
|	|	|	|	`--Example.jpg
|	|	|	|
|	|	|	|--WEB-INF（Web信息）
|	|	|	|	|--templates（Thymeleaf渲染目标，html一般都放在这）
|	|	|	|	|	`--index.html（首页）
|	|	|	|	|	`--example.html
|	|
|	|--test（测试文件夹）
|	|	|--java（代码区）
|	|	|	|--booking（组织文件夹）
|	|	|	|	`--AppTest.java
```



# 数据库设计
