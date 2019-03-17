package com.pinyougou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Title  品优购商城
 * Description  返回结果封装
 * Date   2019/3/15 12:48
 * Modify-Date  2019/3/15 12:48
 *
 * @author wxf
 * @version 0.8
 */
@AllArgsConstructor
@Data
public class Result implements Serializable{

    private boolean success;

    private String message;
}
