package com.njty.carpark.bean;





import com.njty.carpark.utils.Constants;

import java.util.List;

public class MsgBean implements Constants {

	private boolean success = GLOBAL_MSG_BOOL_FAIL;

	private String msg = GLOBAL_MSG_FAIL;

	private int total;

	private List<?> rows;


	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		if (this.total > 0){
			this.success = GLOBAL_MSG_BOOL_SUCCESS;
			this.msg = GLOBAL_MSG_SUCCESS;
		}else if (this.total == 0){
			this.success = GLOBAL_MSG_BOOL_SUCCESS;
			this.msg = GLOBAL_MSG_NORECORD;
		}else {
			this.success = GLOBAL_MSG_BOOL_FAIL;
			this.msg = GLOBAL_MSG_FAIL;
		}
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
		if (this.success == GLOBAL_MSG_BOOL_FAIL) {
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
