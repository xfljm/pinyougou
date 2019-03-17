package com.pinyougou.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Title  云成长一体化大数据平台
 * Description  {类功能中文描述}
 * Date   2019/3/13 9:27
 * Modify-Date  2019/3/13 9:27
 *
 * @author wxf
 * @version 0.8
 */
@AllArgsConstructor
@Data
public class PageResult implements Serializable{



    //总记录数
    private long total;
    //当前页结果
    private List rows;
}
