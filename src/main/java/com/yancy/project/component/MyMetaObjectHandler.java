package com.yancy.project.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Mybatis-Plus 自动填充
 * @author yancy0109
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 自动填充创建时间字段
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
    }

    /**
     * 自动填充更新时间字段
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // log.info("start update fill ....");
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date()); // 起始版本 3.3.0(推荐使用)
    }
}
