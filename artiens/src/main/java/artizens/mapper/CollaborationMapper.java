package artizens.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import artizens.mapper.dto.collaboration.CollaborationInsertDto;

@Mapper
public interface CollaborationMapper {
	@Insert("insert into collaboration(collaboration_title, collaboration_register_date, collaboration_deadline_date, collaboration_content) values (#{title}, now(), #{deadLineDate}, #{content})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "collaboration_id")
	Long insertCollaboration(CollaborationInsertDto collaborationInsertDto);
}
