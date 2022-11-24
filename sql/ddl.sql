-- 创建库
create database if not exists weekly_task;

-- 切换库
use weekly_task;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    user_name     varchar(256)                           null comment '用户昵称',
    user_account  varchar(256)                           not null comment '账号',
    user_avatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                 null comment '性别',
    user_role     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    user_password varchar(512)                           not null comment '密码',
    user_status   tinyint default 0                      not null comment '状态 0 - 正常',
    create_time   datetime                               not null comment '创建时间',
    update_time   datetime                               not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (user_account)
) comment '用户';

-- 标签表
create table if not exists tag
(
    id           bigint auto_increment comment 'id' primary key,
    tags          varchar(512)                           not null comment '用户自定义标签',
    user_id        bigint                                not null comment '用户 id',
    create_time   datetime                               not null comment '创建时间',
    update_time   datetime                               not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete     tinyint      default 0                 not null comment '是否删除'
) comment '标签';

# 初始化标签模板
insert into tag values (1, '学习, CODING, 单词, 娱乐',0, now(), now(), 0);

-- 任务表
create table if not exists task
(
    id             bigint auto_increment comment 'id' primary key,
    task_name      varchar(256)                       not null comment '任务名称',
    task_description    varchar(256)                  null comment '任务描述',
    task_tag       varchar(256)                       null     comment '任务标签',
    is_finish      tinyint default 0                  not null comment '是否完成',
    is_delay       tinyint default 0                  not null comment '是否有延期',
    finish_time    datetime                           not null comment '完成时间',
    user_id        bigint                             not null comment '用户 id',
    create_time    datetime                           not null comment '创建时间',
    update_time    datetime                           not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete      tinyint  default 0                 not null comment '是否删除'
) comment '任务';