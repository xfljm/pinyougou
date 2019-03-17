package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	@Override
	public List<TbBrand> findAll() {

		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int pageNum, int PageSize) {
		PageHelper.startPage(pageNum,PageSize);

		Page<TbBrand> page= (Page<TbBrand>) brandMapper.selectByExample(null);

		return new PageResult(page.getTotal(),page.getResult());

	}

	@Override
	public Result add(TbBrand brand) {
		if(0<brandMapper.insert(brand)){
			return new Result(true,"添加成功");
		}else {
			return new Result(false,"添加失败");
		}
	}

	@Override
	public Result update(TbBrand brand) {
		if(0<brandMapper.updateByPrimaryKey(brand)){
			return new Result(true,"修改成功");
		}else {
			return new Result(false,"修改失败");
		}
	}

	@Override
	public TbBrand findOne(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public Result delete(Long[] ids) {


		try {
			for(long id:ids){
				brandMapper.deleteByPrimaryKey(id);
			}
			return new Result(true,"删除成功");
		}catch (Exception e){
			e.printStackTrace();
			return new Result(true,"删除失败");
		}
	}

	@Override
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum,pageSize);

		TbBrandExample example=new TbBrandExample();

		TbBrandExample.Criteria criteria = example.createCriteria();

		if(brand!=null){
			if(brand.getName()!=null && brand.getName().length()>0){
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0){

				criteria.andFirstCharEqualTo(brand.getFirstChar());
			}
		}

		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);

		return new PageResult(page.getTotal(),page.getResult());

	}

}
