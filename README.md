# 项目初始化
使用了SpringBoot 项目初始模板
> by [程序员鱼皮知识星球](https://yupi.icu)

使用了Java SpringBoot 项目初始模板，整合了常用框架和示例代码，大家可以在此基础上快速开发自己的项目。
## 模板功能
- Spring Boot 2.7.0（贼新）
- Spring MVC
- MySQL 驱动
- MyBatis
- MyBatis Plus
- Spring Session Redis 分布式登录
- Spring AOP
- Apache Commons Lang3 工具类
- Lombok 注解
- Swagger + Knife4j 接口文档
- Spring Boot 调试工具和项目处理器
- 全局请求响应拦截器（记录日志）
- 全局异常处理器
- 自定义错误码
- 封装通用响应类
- 示例用户注册、登录、搜索功能
- 示例单元测试类
- 示例 SQL（用户表）  

访问 localhost:7529/api/doc.html 就能在线调试接口了，不需要前端配合啦~

## 项目说明
提供用户以单位的计划组织功能
## 项目设想
基本：  
账号系统
基础功能：
查询标签库：初始化给予用户自定义的标签库（标签化有初始化模板，在创建用户时间进行 ---  todo）
添加任务：以周为单位定制计划,且只能指定从现在时刻至周末的计划
删除任务：确定删除任务
修改任务：修改任务内容，标签
查找任务：查找创建的任务以及任务信息。
统计：
- 本周完成了多少内容
- 本周还剩下多少任务
- 本周超时了多少任务
  未完成任务列表：
- 任务删除：是否确定删除任务？
- 任务修改：延迟时间期限（ 时间是从现在至周末）

## 开发日志

### 22.11.25
完成用户基本信息功能
  
### 22.11.26
完成用户标签管理功能
补充建立用户时更新TAG

### 22.12.6
用户标签BUG FIX