package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import artizens.mapper.dto.collaboration.CollaborationCollaboratorDto;
import artizens.mapper.dto.collaboration.CollaborationWinnerDto;

@Mapper
public interface CollaborationMapper3 {

	// 작품선정 리스트
	@Select("SELECT artwork.collaboration_artwork_storefilename, " + "		artwork.collaboration_artwork_title, "
			+ "		creator.creator_nickname " + "	FROM collaboration_artwork AS artwork " + "		JOIN creator "
			+ "			ON artwork.creator_id = creator.creator_id"
			+ "	WHERE artwork.collaboration_id = ${collaboration_id}")
	@Results({ @Result(property = "collaborationId", column = "collaboration_id", id = true),
			@Result(property = "image", column = "collaboration_artwork_storefilename"),
			@Result(property = "title", column = "collaboration_artwork_title"),
			@Result(property = "nickname", column = "creator_nickname") })
	List<CollaborationWinnerDto> findAllCollaborationWinner(Long collaboration_id);

	
	  @Select("SELECT creator.creator_profile_storefilename, " +
	  "		creator.creator_nickname, " +
	  "		collaboration.collaboration_register_date " + "	FROM creator " +
	  "		JOIN collaboration " +
	  "			ON creator.creator_id = collaboration.creator_id " +
	  "	WHERE collaboration.collaboration_id = ${collaboId}")
	  
	  @Results({
	  
	  @Result(property = "onenickname", column = "creator_nickname"),
	  
	  @Result(property = "creatorimage", column = "creator_profile_storefilename"),
	  
	  @Result(property = "registerdate", column = "collaboration_register_date") })
	  CollaborationCollaboratorDto findcollaborator(Long collaboId);


	 

	/*
	 * @Select("SELECT creator.creator_profile_storefilename, " +
	 * "		creator.creator_nickname, " +
	 * "		collaboration.collaboration_register_date, " + "	FROM creator " +
	 * "		JOIN collaboration " +
	 * "		ON creator.creator_id = collaboration.creator_id" +
	 * "	WHERE collaboration.collaboration_id = ${collaboration_id}")
	 * 
	 * @ResultMap("WinnerMap") CollaborationWinnerDto findCollaborator( Long
	 * collaboration_id );
	 */

}
