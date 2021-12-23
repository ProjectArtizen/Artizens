package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import artizens.mapper.dto.collaboration.CollaborationWinnerDto;

@Mapper
public interface CollaborationMapper3 {

	// 작품선정 리스트
	@Results({
		@Result(property = "collaborationId", column = "collaboration_id", id = true),
		@Result(property = "image", column = "collaboration_artwork_storefilename"),
		@Result(property = "title", column = "collaboration_artwork_title"),
		@Result(property = "nickname", column = "creator_nickname")
	})
	@Select("SELECT artwork.collaboration_artwork_storefilename, "
			+ "		artwork.collaboration_artwork_title, "
			+ "		creator.creator_nickname "
			+ "	FROM collaboration_artwork AS artwork "
			+ "		JOIN creator "
			+ "			ON artwork.creator_id = creator.creator_id"
			+ "	WHERE artwork.collaboration_id = ${collaborationId")
	List<CollaborationWinnerDto> findAllCollaborationWinner();
}
