package com.retailstore.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResult {
	private ReturnResultStatus status;
	private String message;

	public ReturnResult(ReturnResultStatus status) {
		this(status,null);
	}
}