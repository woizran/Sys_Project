/**
 * Copyright (c) 2016-2019 feel All rights reserved.
 *
 * https://www.feel.io
 *
 * 版权所有，侵权必究！
 */

package com.feel.modules.job.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feel.common.utils.PageUtils;
import com.feel.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);

}