package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import artizens.mapper.dto.collaboration.CollaborationMainDto;

@Mapper
public interface CollaborationMapper1 {
	@Insert("insert into collaboration("
			+ "collaboration_title, "
			+ "collaboration_register_date, "
			+ "collaboration_deadline_date, "
			+ "collaboration_content, "
			+ "collaboration_store_file_name) values ("
			+ "#{title}, now(), #{deadLineDate}, #{content} , #{storedFileName})")
	@Options(useGeneratedKeys = true, keyProperty = "collaborationId", keyColumn = "collaboration_id")
	Long insertCollaboration(CollaborationMainDto collaborationDto);
	
	@Results({
		@Result(property = "collaborationId", column = "collaboration_id", id = true),
		@Result(property = "title", column = "collaboration_title"),
		@Result(property = "deadLineDate", column = "collaboration_deadline_date"),
		@Result(property = "registerDate", column = "collaboration_register_date"),
		@Result(property = "content", column = "collaboration_content"),
		@Result(property = "storedFileName", column = "collaboration_store_file_name")
	})
	@Select("select * from collaboration")
	List<CollaborationMainDto> findAllCollaboration();

}
