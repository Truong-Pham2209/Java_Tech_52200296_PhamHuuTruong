package lab9.lab9.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(value = Include.NON_NULL)
public class ApiResponse<T> {
	boolean success;
	String message;
	T result;

	public ApiResponse(T result) {
		this.result = result;
		this.success = true;
	}

	public ApiResponse(String message) {
		this.message = message;
		this.success = false;
	}

}
