package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	public List<TbBrand> findAll();

	/**
	 * Description 返回分页列表
	 * Date 2019/3/13 9:35
	 * @param
	 * @return
	 * @author wxf
	 */
	public PageResult findPage(int pageNum,int PageSize);

	/**
	 * Description 增加
	 * Date 2019/3/15 12:46
	 * @param
	 * @return
	 * @author wxf
	 */
	public Result add(TbBrand brand);

	/**
	 * Description 修改品牌
	 * Date 2019/3/15 15:42
	 * @param
	 * @return
	 * @author wxf
	 */
	Result update(TbBrand brand);

	/**
	 * Description 查询实体
	 * Date 2019/3/15 15:51
	 * @param
	 * @return
	 * @author wxf
	 */
	TbBrand findOne(Long id);

	/**
	 * Description 批量删除
	 * Date 2019/3/15 16:29
	 * @param
	 * @return
	 * @author wxf
	 */
	Result delete(Long[] ids);

	/**
	 * Description 查询+分页
	 * Date 2019/3/15 17:33
	 * @param  pageNum 当前页
	 * @param  pageSize 每页记录数
	 * @return
	 * @author wxf
	 */
	PageResult findPage(TbBrand brand, int pageNum, int pageSize);
}
