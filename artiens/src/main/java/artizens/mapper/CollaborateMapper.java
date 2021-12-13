package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import artizens.mapper.dto.CollaborationMainDto;

@Mapper
public interface CollaborateMapper {

	

	@Select("Select "
			+ " a.collaboration_id as id"
			+ " a.collaboration_title as title"
			+ " date_format(a.collaboration_register_date,'%Y.%m.%d') as registerDate "
			+ " date_format(a.collaboration_deadline_date,'%Y-%m-%d') as deadlineDate "
			+ " c.creater_nickname as createrNickname "
			+ " b.collaboration_images_storefilename as collaborationImgName "
			+ " c.creater_profile_storefilename as createrImgName "
			+ " (select count(*) from collaboration_artwork where collaboration_id = a.collaboration_id) as artworkCount "
			+ " (select count(*) from collaboration_comment where collaboration_id = a.collaboration_id) as commentCount "
			+ " from collaboration as a "
			+ " left join collaboration_images as b_img "
			+ " on a.collaboration_id = b_images.collaboration_images_id "
			+ " left join creater as c "
			+ " on a.creater_id = c.creater_id ")
	List<CollaborationMainDto> findcollaborationMainAll();
	
}
