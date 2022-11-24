package com.yancy.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 任务
 * @TableName task
 */
@TableName(value ="task")
@Data
public class Task implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 任务名称
     */
    @TableField(value = "task_name")
    private String taskName;

    /**
     * 任务描述
     */
    @TableField(value = "task_description")
    private String taskDescription;

    /**
     * 任务标签
     */
    @TableField(value = "task_tag")
    private String taskTag;

    /**
     * 是否完成
     */
    @TableField(value = "is_finish")
    private Integer isFinish;

    /**
     * 是否有延期
     */
    @TableField(value = "is_delay")
    private Integer isDelay;

    /**
     * 完成时间
     */
    @TableField(value = "finish_time")
    private Date finishTime;

    /**
     * 用户 id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Task other = (Task) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getTaskDescription() == null ? other.getTaskDescription() == null : this.getTaskDescription().equals(other.getTaskDescription()))
            && (this.getTaskTag() == null ? other.getTaskTag() == null : this.getTaskTag().equals(other.getTaskTag()))
            && (this.getIsFinish() == null ? other.getIsFinish() == null : this.getIsFinish().equals(other.getIsFinish()))
            && (this.getIsDelay() == null ? other.getIsDelay() == null : this.getIsDelay().equals(other.getIsDelay()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getTaskDescription() == null) ? 0 : getTaskDescription().hashCode());
        result = prime * result + ((getTaskTag() == null) ? 0 : getTaskTag().hashCode());
        result = prime * result + ((getIsFinish() == null) ? 0 : getIsFinish().hashCode());
        result = prime * result + ((getIsDelay() == null) ? 0 : getIsDelay().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskName=").append(taskName);
        sb.append(", taskDescription=").append(taskDescription);
        sb.append(", taskTag=").append(taskTag);
        sb.append(", isFinish=").append(isFinish);
        sb.append(", isDelay=").append(isDelay);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}