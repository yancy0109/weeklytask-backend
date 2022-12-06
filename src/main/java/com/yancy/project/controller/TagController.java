package com.yancy.project.controller;

import com.yancy.project.common.BaseResponse;
import com.yancy.project.common.ErrorCode;
import com.yancy.project.common.ResultUtils;
import com.yancy.project.exception.BusinessException;
import com.yancy.project.model.dto.tag.TagAddRequest;
import com.yancy.project.model.dto.tag.TagDeleteRequest;
import com.yancy.project.model.entity.User;
import com.yancy.project.model.vo.UserTagsVo;
import com.yancy.project.service.TagService;
import com.yancy.project.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 标签Controller
 * @author yancy0109
 */

@RestController
@RequestMapping("/tag")
@Slf4j
public class TagController {

    @Resource
    private TagService tagService;

    @Resource
    private UserService userService;


    /**
     * 增加用户标签
     *
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Boolean> addUserTag(@RequestBody TagAddRequest tagAddRequest, HttpServletRequest request){
        String tagName = tagAddRequest.getTagName();
        if (StringUtils.isBlank(tagName)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        boolean result = tagService.addUserTag(tagAddRequest, loginUser);
        return ResultUtils.success(result);
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteUserTag(@RequestBody TagDeleteRequest tagDeleteRequest, HttpServletRequest request) {
        String tagName = tagDeleteRequest.getTagName();
        if (StringUtils.isBlank(tagName)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        Boolean result = tagService.deleteUserTag(tagDeleteRequest, loginUser);
        return ResultUtils.success(result);
    }
    @GetMapping("/get")
    public BaseResponse<UserTagsVo> getUserTag(HttpServletRequest request) {
        User loginUser = userService.getLoginUser(request);
        UserTagsVo userTagsVo = tagService.getUserTags(loginUser);
        return ResultUtils.success(userTagsVo);
    }

}
