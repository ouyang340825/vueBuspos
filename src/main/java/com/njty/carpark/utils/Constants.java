package com.njty.carpark.utils;

public interface Constants {

	
	public static final Boolean GLOBAL_MSG_BOOL_SUCCESS = true;
	public static final Boolean GLOBAL_MSG_BOOL_FAIL = false;
	public static final String GLOBAL_MSG_SUCCESS = "操作成功！";
	public static final String GLOBAL_MSG_FAIL = "操作失败！";
	public static final String GLOBAL_MSG_NORECORD = "未查询到有效记录！";
	
	public static final Integer GLOBAL_NOT_LEAF = 0;
	public static final Integer GLOBAL_LEAF = 1;
	
	public static final String ACTION_OVERTIME_STATE = "疲劳报警触发";
	public static final String ACTION_IN_FORBIDDEN_ZONE_STATE = "进禁区触发";
	public static final String ACTION_OUT_FORBIDDEN_ZONE_STATE = "出禁区触发";
	public static final String ACTION_ACCELERATE_STATE = "急加速触发";
	public static final String ACTION_DECELERATE_STATE = "急减速触发";
	public static final String ACTION_WHEEL_DECELERATE_STATE = "转弯不减速触发";
	public static final String ACTION_WHEEL_NOLIGHT_STATE = "转弯不打方向灯触发";
	public static final String ACTION_OTHERS_STATE = "-";
	public static final String CREATE_REASON_BYCAR ="车机上传";
	public static final String CREATE_REASON_BYSYSTEM ="平台判断产生";
}
