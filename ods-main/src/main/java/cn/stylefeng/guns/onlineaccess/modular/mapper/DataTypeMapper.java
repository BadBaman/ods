package cn.stylefeng.guns.onlineaccess.modular.mapper;

import cn.stylefeng.guns.onlineaccess.modular.entity.DataType;
import cn.stylefeng.guns.onlineaccess.modular.result.DataTypeResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataTypeMapper extends BaseMapper<DataType> {


}
