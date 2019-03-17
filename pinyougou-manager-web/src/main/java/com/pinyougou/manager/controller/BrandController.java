package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		System.out.println("测试开始了*********************************");
		return brandService.findAll();		
	}

	/**
	 * Description 返回全部列表
	 * Date 2019/3/13 9:40
	 * @param
	 * @return
	 * @author wxf
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page,int rows){
		return brandService.findPage(page,rows);
	}

	/**
	 * Description 增加
	 * Date 2019/3/15 12:51
	 * @param
	 * @return
	 * @author wxf
	 */
	@RequestMapping(value = "/add")
	public Result add(@RequestBody TbBrand brand){
		return brandService.add(brand);
	}

	/**
	 * Description 修改
	 * Date 2019/3/15 15:49
	 * @param
	 * @return
	 * @author wxf
	 */
	@RequestMapping(value = "/update")
	public Result update(@RequestBody TbBrand brand){
		return brandService.update(brand);
	}

	/**
	 * Description 查询品牌
	 * Date 2019/3/15 16:27
	 * @param
	 * @return
	 * @author wxf
	 */
	@RequestMapping(value = "/findOne")
	public TbBrand findOne(Long id){
		return brandService.findOne(id);
	}

	@RequestMapping(value = "/delete")
	public Result delete(Long[] ids){
		return brandService.delete(ids);
	}

	/**
	 * Description 查询+分页
	 * Date 2019/3/15 17:31
	 * @param
	 * @return
	 * @author wxf
	 */
	@RequestMapping(value = "/search")
	public PageResult search(@RequestBody TbBrand brand,int page,int rows){

		return brandService.findPage(brand,page,rows);
	}

}
