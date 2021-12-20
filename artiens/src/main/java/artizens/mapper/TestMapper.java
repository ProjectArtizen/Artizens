package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import artizens.domain.SampleVO;

@Mapper
public interface TestMapper {
	
	@Insert("Insert into artworktest(title,name) values(#{title},#{name} )")
	int insertContent(String title, String name);
	
	@Select("Select * from artworktest")
	List<SampleVO> findAll();
	
}
