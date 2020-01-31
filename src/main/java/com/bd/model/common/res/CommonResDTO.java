package com.bd.model.common.res;

import java.time.LocalDateTime;

public class CommonResDTO {
	
	private LocalDateTime regDt;
	
	private LocalDateTime modiDt;

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public LocalDateTime getModiDt() {
		return modiDt;
	}

	public void setModiDt(LocalDateTime modiDt) {
		this.modiDt = modiDt;
	}
}
