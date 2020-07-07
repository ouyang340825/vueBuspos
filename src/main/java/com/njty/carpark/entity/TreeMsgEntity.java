package com.njty.carpark.entity;





import com.njty.carpark.utils.Constants;

import java.util.List;

public class TreeMsgEntity implements Constants {

	private int code = 0;

	private String msg = GLOBAL_MSG_FAIL;

	private int count;

	private List<?> data;


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		if (this.count > 0){
			this.code = 0;
			this.msg = GLOBAL_MSG_SUCCESS;
		}else if (this.count == 0){
			this.code = 0;
			this.msg = GLOBAL_MSG_NORECORD;
		}else {
			this.code = 200;
			this.msg = GLOBAL_MSG_FAIL;
		}
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
		if (this.code == 400) {
			this.msg = GLOBAL_MSG_FAIL;
		}else {
			this.msg = GLOBAL_MSG_SUCCESS;
		}
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
