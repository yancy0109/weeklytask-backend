package com.yancy.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yancy.project.common.ErrorCode;
import com.yancy.project.exception.BusinessException;
import com.yancy.project.model.dto.task.TaskAddRequest;
import com.yancy.project.model.entity.Task;
import com.yancy.project.model.entity.User;
import com.yancy.project.service.TagService;
import com.yancy.project.service.TaskService;
import com.yancy.project.mapper.TaskMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
* @author yancy0109
* @description 针对表【task(任务)】的数据库操作Service实现
* @createDate 2022-11-24 13:08:01
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

    @Resource
    private TagService tagService;

    @Override
    public boolean createUserTask(TaskAddRequest taskAddRequest, User loginUser) {
        synchronized (loginUser.getUserAccount().intern()) {
            // 获取用户信息
            Long userId = loginUser.getId();
            // tags 必须为用户所拥有的标签
            String[] tags = taskAddRequest.getTaskTag().split(",");
            String userTags = tagService.getTagByUserId(userId).getTags();
            for (String tag : tags) {
                if (!userTags.contains(tag)) {
                    throw new BusinessException(ErrorCode.PARAMS_ERROR);
                }
            }
            // 任务结束时间必须为合规任务时间  -->  在本周末前 && 在当前时间后
            Date finishTime = taskAddRequest.getFinishTime();
            if (new Date().after(finishTime)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR.getCode(), "任务结束时间太早!!!");
            }
            int weekNow = getNowWeek(new Date());
            int weekFinish = getNowWeek(finishTime);
            if (weekFinish != weekNow) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR.getCode(), "请添加本周的任务!!!");
            }
            Task task = new Task();
            task.setUserId(userId);
            task.setIsFinish(0);
            task.setIsDelay(0);
            BeanUtils.copyProperties(taskAddRequest, task);
            return this.save(task);
        }
    }


    /**
     * 根据传入时间获取当前所属的周
     * @param date
     * @return 当前所属周
     */
    private int getNowWeek(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setFirstDayOfWeek(Calendar.MONDAY);
        gregorianCalendar.setTime(date);
        return gregorianCalendar.get(Calendar.WEEK_OF_YEAR);
    }
}




