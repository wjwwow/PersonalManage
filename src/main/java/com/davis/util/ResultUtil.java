package com.davis.util;

import com.davis.DTO.ResultDTO;

/**
 * @author Davis
 * @date 2021-11-17 - 18:25
 * @description
 */
public class ResultUtil {
    public static <T> ResultDTO<T> successResult(T t){
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setResult(true);
        resultDTO.setMessage("请求成功");
        resultDTO.setData(t);
        return resultDTO;
    }

    public static <T> ResultDTO<T> failResult(){
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setResult(false);
        resultDTO.setMessage("请求失败");
        return resultDTO;
    }
}
