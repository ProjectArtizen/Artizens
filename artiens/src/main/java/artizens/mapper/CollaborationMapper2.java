package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import artizens.mapper.dto.collaboration.CollaborationDetailDto;

@Mapper
public interface CollaborationMapper2 {
	
	/**
	 * Collaboration 공모전 상세 페이지 query
	 * @param collaborationId
	 * @return
	 */
	@Results(id = "collaboratonResult", value = {
		@Result(property = "id", column = "collaboration_id", id =true),
		@Result(property = "title", column = "collaboration_title"),
		@Result(property = "registerDate", column = "collaboration_register_date"),
		@Result(property = "creatorNickname", column = "creator_nickname"),
		@Result(property = "creatorImgName", column = "creator_profile_storefilename"),
		@Result(property = "contentImgName", column = "collaboration_storefilename"),
		@Result(property = "content", column = "collaboration_content")
	})
	@Select("select * from collaboration"
			+ " left join creator"
			+ " on collaboration.creator_id = creator.creator_id"
			+ " where collaboration.collaboration_id=${collaborationId}")
	CollaborationDetailDto findCollaborationById(Long collaborationId);
	
	@Results(id = "collaboratonArtWorkResult", value = {
			@Result(property = "id", column = "collaboration_artwork_id", id =true),
			@Result(property = "title", column = "collaboration_artwork_title"),
			@Result(property = "registerDate", column = "collaboration_artwork_register_date"),
			@Result(property = "creatorNickname", column = "creator_nickname"),
			@Result(property = "creatorImgName", column = "creator_profile_storefilename"),
			@Result(property = "contentImgName", column = "collaboration_artwork_storefilename"),
			@Result(property = "content", column = "collaboration_artwork_content")
		})
	@Select("select * from collaboration_artwork"
			+ " left join creator"
			+ " on collaboration_artwork.creator_id = creator.creator_id"
			+ " where collaboration_artwork.collaboration_artwork_id=${collaborationArtWorkId}")
	CollaborationDetailDto findaCollaboArtWorkById(Long collaborationArtWorkId);
	
}
