package com.xintong.solarpower.api.utils;

/**
 * @ClassName ResultMap
 * @Description 统一返回结果类型
 * @Author zsk
 * @Date 2019/9/24 14:41
 * @Version 1.0
 */
public class ResultMap {

    //成功状态码
    private static final Integer SUCCESS_CODE = 200;
    //失败状态码
    private static final Integer FAILED_CODE = -1;

    private static final Boolean SUCCESS_STR = true;

    private static final Boolean FAILED_STR = false;


    //是否成功
    private boolean success;

    //状态码
    private Integer resultCode;

    //信息
    private String resultMessage;

    //数据
    private Object data;


    private ResultMap(Integer resultCode,Boolean success) {
        this.resultCode = resultCode;
        this.success = success;
    }


    private ResultMap(Integer resultCode,Boolean success,String resultMessage) {
        this.resultCode = resultCode;
        this.success = success;
        this.resultMessage = resultMessage;
    }

    private ResultMap(Integer resultCode,Boolean success,Object data) {
        this.resultCode = resultCode;
        this.success = success;
        this.data = data;
    }


    private ResultMap(Integer resultCode,Boolean success,String resultMessage, Object data) {
        this.resultCode = resultCode;
        this.success = success;
        this.resultMessage = resultMessage;
        this.data = data;
    }

    /**
     * 处理成功，返回200
     */
    public static ResultMap success(){
        return new ResultMap(SUCCESS_CODE,SUCCESS_STR);
    }

    /**
     * 处理成功，返回200 、message
     * @param resultMessage
     * @return
     */
    public static ResultMap success(String resultMessage){
        return new ResultMap(SUCCESS_CODE,SUCCESS_STR,resultMessage);
    }

    /**
     * 处理成功，返回200 、message、data
     * @param data
     * @param data
     * @return
     */
    public static ResultMap success(Object data){
        return new ResultMap(SUCCESS_CODE,SUCCESS_STR,data);
    }

    /**
     * 处理失败，返回-1
     * @return
     */
    public static ResultMap failed(){
        return new ResultMap(FAILED_CODE,FAILED_STR);
    }

    /**
     * 处理失败,返回-1和错误信息
     * @param resultMessage
     * @return
     */
    public static ResultMap failed(String resultMessage){
        return new ResultMap(FAILED_CODE,FAILED_STR,resultMessage);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
