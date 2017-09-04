package com.dai7.controller.vo;

/**
 * 后台结果类
 */
public class Result<T> {

	public static final int ERRCODE_SUCCESS = 0;
	public static final int ERRCODE_FAIL = 1;

	private int code;
	private String message;
	private T data;
	
	public Result(int code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public Result(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public Result() {
	}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	/***
	 * 创建空的 无数据的 成功返回对象
	 *
	 * @param <T>
	 * @return
     */
	public static <T> Result<T> createOK(){
		Result<T> ok = new Result<>(ERRCODE_SUCCESS, "");
		return ok;
	}

    /***
     * 创建空的 无数据的 成功返回对象
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> createFail(){
        Result<T> fail = new Result<>(ERRCODE_FAIL, "");
        return fail;
    }

    /***
     * 创建空的 无数据的 成功返回对象
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> createFail(T data){
        Result<T> fail = new Result<>(ERRCODE_FAIL, "");
        fail.setData(data);
        return fail;
    }

	/**
	 * 根据返回的数据，创建成功的返回对象
	 *
	 * @param data
	 * @param <T>
     * @return
     */
	public static <T> Result<T> createOK(T data){
		Result<T> ok = createOK();
		ok.setData(data);
		return ok;
	}

}
