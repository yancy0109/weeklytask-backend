package com.yancy.project.model.dto.task;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户添加任务请求
 * @author yancy0109
 */
@Data
public class TaskAddRequest implements Serializable {

    private static final long serialVersionUID = -1751438822982580865L;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务描述
     */
    private String taskDescription;

    /**
     * 任务标签
     */
    private String taskTag;

    /**
     * 完成时间
     */
    private Date finishTime;

}
