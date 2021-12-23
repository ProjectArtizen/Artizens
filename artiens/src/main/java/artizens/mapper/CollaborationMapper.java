package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import artizens.domain.Collaboration;
import artizens.mapper.dto.collaboration.CollaborationDto;
import artizens.mapper.dto.collaboration.CollaborationWinnerDto;

@Mapper
public interface CollaborationMapper {
	
	@Insert("insert into collaboration("
			+ "collaboration_title, "
			+ "collaboration_register_date, "
			+ "collaboration_deadline_date, "
			+ "collaboration_content) values ("
			+ "#{title}, now(), #{deadLineDate}, #{content})")
	@Options(useGeneratedKeys = true, keyProperty = "collaborationId", keyColumn = "collaboration_id")
	Long insertCollaboration(CollaborationDto collaborationDto);
	
	// 콜라보 이미지 insert query
	@Insert("insert into collaboration_images(collaboration_images_storefilename, collaboration_id) values("
			+ "#{storedFileName},"
			+ "${collaborationId})")
	@Options(useGeneratedKeys = true, keyProperty = "collaborationImageId", keyColumn = "collaboration_images_id")
	Long insertCollaborationImage(CollaborationDto collaborationDto);
	
	@Select("select collaboration_images_storefilename from collaboration_images where collaboration_id=${collaborationId}")
	List<String> findAllCollaborationImages(Long collaborationId);
	
	@Results({
		@Result(property = "collaborationId", column = "collaboration_id", id = true),
		@Result(property = "title", column = "collaboration_title"),
		@Result(property = "deadLineDate", column = "collaboration_deadline_date"),
		@Result(property = "registerDate", column = "collaboration_register_date"),
		@Result(property = "content", column = "collaboration_content")
	})
	@Select("select * from collaboration")
	List<CollaborationDto> findAllCollaboration();
	
	// 작품선정 리스트
	@Results({
		@Result(property = "collaborationId", column = "collaboration_id", id = true),
		@Result(property = "image", column = "collaboration_artwork_images_storefilename"),
		@Result(property = "title", column = "collaboration_artwork_title"),
		@Result(property = "nickname", column = "creator_nickname")
	})
	@Select("select image.collaboration_artwork_images_storefilename, "
			+ "		artwork.collaboration_artwork_title, "
			+ "		creator.creator_nickname "
			+ "	form collaboration_artwork AS artwork "
			+ "		JOIN collaboration_artwork_Images AS image "
			+ "			ON artwork.collaboration_artwork_id = image.collaboration_artwork_id"
			+ "		JOIN creator "
			+ "			ON creator.creator_id = artwork.creator_id"
			+ "	WHERE artwork.collaboration_id = ${collaborationId")
	List<CollaborationWinnerDto> findAllCollaborationWinner(Long collaboraionId);
	
	
	
}
