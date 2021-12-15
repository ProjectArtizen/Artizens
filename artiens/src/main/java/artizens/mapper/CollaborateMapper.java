package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import artizens.mapper.dto.CollaborationMainDto;

@Mapper
public interface CollaborateMapper {
	
	// 콜라보레이션 상세화면 출력 쿼리
//	@Select("Select "
//			+ " a.collaboration_id as id,"
//			+ " a.collaboration_title as title, "
//			+ " date_format(a.collaboration_register_date,'%Y.%m.%d') as registerDate, "
//			+ " c.creator_nickname as creatorNickname, "
//			+ " b_img.collaboration_images_storefilename as collaborationImgName, "
//			+ " c.creator_profile_storefilename as creatorImgName, "
//			+ " a.collaboration_content as content, "
//			+ " (select count(*) from collaboration_comment where collaboration_id = a.collaboration_id) as commentCount "
//			+ "	d.collaboration_comment_id as commentId, "
//			+ "	d.collaboration_comment_comment as comment"
//			+ " from collaboration as a "
//			+ "  left join collaboration_images as b_img "
//			+ "  on a.collaboration_id = b_img.collaboration_id "
//			+ "  left join creator as c "
//			+ "  on a.creator_id = c.creator_id"
//			+ "  left join collaboration_comment as d "
//			+ "	 on a.collaboration_id = d.collaboration_id "
//			+ " where a.collaboratuon_id = #{id}")
		
	
	// 콜라보레이션 메인 출력 쿼리
	@Select("Select "
			+ " a.collaboration_id as id,"
			+ " a.collaboration_title as title, "
			+ " date_format(a.collaboration_register_date,'%Y.%m.%d') as registerDate, "
			+ " date_format(a.collaboration_deadline_date,'%Y.%m.%d') as deadlineDate, "
			+ " c.creator_nickname as creatorNickname, "
			+ " b_img.collaboration_images_storefilename as collaborationImgName, "
			+ " c.creator_profile_storefilename as creatorImgName, "
			+ " (select count(*) from collaboration_artwork where collaboration_id = a.collaboration_id) as artworkCount, "
			+ " (select count(*) from collaboration_comment where collaboration_id = a.collaboration_id) as commentCount "
			+ " from collaboration as a "
			+ " left join collaboration_images as b_img "
			+ " on a.collaboration_id = b_img.collaboration_id "
			+ " left join creator as c "
			+ " on a.creator_id = c.creator_id ")
	List<CollaborationMainDto> findcollaborationMainAll();
	
}
