# api-mobile

### 项目使用说明
ctrl + F9 可以快速重启项目
### swagger接口文档地址
http://localhost:8080/swagger-ui/index.html
### 代码生成器位置
**utils**包下**CodeGenerator**
修改配置参数运行main方法直接生成代码
### 授权拦截
在Controller方法前添加 **@CheckToken** 注解
### 使用Gson反序列化报Warning
请使用**utils**包下的**GsonProduction**
### 响应报文
请使用**utils**包下的**ResultUtil**
### 切换数据源
请在Service层使用**@DS**注解 不要在Mapper层使用
### 远程调用
在rpc包下创建openFegin类进行远程调用

