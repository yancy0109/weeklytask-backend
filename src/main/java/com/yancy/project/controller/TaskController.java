package com.yancy.project.controller;

import com.yancy.project.common.BaseResponse;
import com.yancy.project.common.ErrorCode;
import com.yancy.project.common.ResultUtils;
import com.yancy.project.exception.BusinessException;
import com.yancy.project.model.dto.task.TaskAddRequest;
import com.yancy.project.model.entity.User;
import com.yancy.project.service.TagService;
import com.yancy.project.service.TaskService;
import com.yancy.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author yancy0109
 */

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Resource
    private UserService userService;

    @Resource
    private TagService tagService;

    @Resource
    private TaskService taskService;

    /**
     * 用户添加个人任务
     * @param taskAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Boolean> createUserTask(TaskAddRequest taskAddRequest, HttpServletRequest request) {
        String taskName = taskAddRequest.getTaskName();
        String taskTag = taskAddRequest.getTaskTag();
        Date finishTime = taskAddRequest.getFinishTime();
        if (StringUtils.isAllBlank(taskName, taskTag) && ObjectUtils.isEmpty(finishTime)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        boolean result = taskService.createUserTask(taskAddRequest, loginUser);
        return ResultUtils.success(result);
    }

}
