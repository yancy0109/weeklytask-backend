package com.yancy.project.service.impl;
import com.google.common.collect.Lists;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yancy.project.common.ErrorCode;
import com.yancy.project.common.PageRequest;
import com.yancy.project.exception.BusinessException;
import com.yancy.project.model.dto.task.TaskAddRequest;
import com.yancy.project.model.entity.Task;
import com.yancy.project.model.entity.User;
import com.yancy.project.model.vo.UserTaskVo;
import com.yancy.project.service.TagService;
import com.yancy.project.service.TaskService;
import com.yancy.project.mapper.TaskMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    @Override
    public List<Task> getUserTasks(User loginUser) {
        Long userId = loginUser.getId();
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        // 结束时间越早 排序越靠前
        queryWrapper.orderByAsc("finish_time");
        List<Task> taskList = this.list(queryWrapper);
        if (CollectionUtils.isEmpty(taskList)){
            return new ArrayList<>();
        }
        return taskList;
    }

    @Override
    public Page<UserTaskVo> getUserTasksPages(PageRequest pageRequest, User loginUser) {
        Long userId = loginUser.getId();
        IPage<Task> page = new Page<>();
        long pageSize = pageRequest.getPageSize();
        long currentPage = pageRequest.getCurrent();
        // 排序字段
        String sortField = pageRequest.getSortField();
        // 排序顺序
        String sortOrder = pageRequest.getSortOrder();

        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        page.setPages(0L);
        page.setRecords(Lists.newArrayList());
        page.setTotal(0L);
        page.setSize(0L);
        page.setCurrent(0L);

        page.setPages(pageSize);
        IPage<Task> taskIPage = this.page(page, queryWrapper);

        return null;
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




