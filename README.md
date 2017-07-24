# CustomerManageSystem
- ***KUNY 2017-7-24 创建***


* * *

[TOC]


* * *

### CS系统介绍
- 此项目是基于JSP与servlet的无框架式动态web应用， 实现了对客户的增查删改基本操作，加入了关于三个键值的搜素功能。
- 此项目主要目的为熟悉JSP应用的基本框架与接口。
- 运行需要设置Tomcat服务器。
- 运行**需要在mysql加入datamanage数据库与customer表，并在src/dbDao/DBDao中设置连接**。
- 创建环境为** Eclipse+Mysql**。


- - -



#### 引用jar包介绍
| 引用包 | 功能 |
|--------|--------|
|     mysql-connector-java-5.1.42-bin.jar   |    mysql驱动与支持    |
|itcast-tools-1.4.2.jar /	commons-logging-1.1.1.jar / commons-beanutils-1.8.3.jar|对javabean的支持与解析|
|json-lib-2.2.3-jdk15.jar / json-lib-2.3-jdk13.jar|对JSON数据的支持与解析|
|jstl.jar；standard.jar|对JSTL标签的支持|
- 以上引用包放置于WebRoot/WEB-INF/lib 下。


- - -


#### 项目介绍
##### 后端CustomerServlet服务
| 包 | 功能 |备注|优化|
|--------|--------|------|------|
|    customerBean   |    客户的javabean |无|后期可以加入更多的属性|
|    dbDao    |    数据库服务封装    |DBDao类为数据库驱动注册与初始化，带有init与close函数。DBSeivice类(内含DBDao对象)为所有的需要连接数据库的功能提供方法。 |可以设置为数据池，增加访问效率。|
|     customerServelt   |    客户处理的主要类   |所有关于客户操作处理放入doPost函数中，前端网页request传来的submitType变量决定使用哪种服务。|可以在前端将method区分，不让所有请求都使用doPost。|
##### 前端JSP文件
| 文件 | 功能 |备注|优化|
|--------|--------|------|---|
|welcome.jsp|启动的主界面|无|可以加入登录验证模块|
|CustomerAdd.jsp|添加页面|无|无|
|CustomerEdit.jsp|编辑页面|从查询页面的编辑可以自带信息|无|
|CustomerManage.jsp|查询页面|可以查看所有用户|无|
|advancedSearchCustomer.jsp|搜索页面|姓名、性别、电话号码三个键值的搜索|此处后端函数比较烦琐，可以加入Map优化|
|top.jsp|导航栏|无|无|
|footer.jsp|底部信息|无|无|
|about.jsp|关于|无|无|


_ _ _

####项目演示

##### 查询界面
![](https://raw.githubusercontent.com/DarinLKY/referPic/master/customerSystem/custmanage.png)


- - -

##### 添加界面
![](https://raw.githubusercontent.com/DarinLKY/referPic/master/customerSystem/custadd.png)


- - -

##### 编辑界面
![](https://raw.githubusercontent.com/DarinLKY/referPic/master/customerSystem/custedit.png)


- - -

##### 搜索界面
![](https://raw.githubusercontent.com/DarinLKY/referPic/master/customerSystem/custsearch1.png)

![](https://raw.githubusercontent.com/DarinLKY/referPic/master/customerSystem/custsearch2.png)



* * *



