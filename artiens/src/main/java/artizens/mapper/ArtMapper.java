package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import artizens.controller.dto.artwork.BlogInfoDTO;
import artizens.controller.dto.artwork.StoreFileDTO;
import artizens.controller.dto.artwork.UploadFileDTO;
import artizens.controller.dto.artwork.UploadTextDTO;
import artizens.domain.ArtWork;
import artizens.domain.ArtWorkImages;
import artizens.mapper.dto.ArtWorkMainDto;
import artizens.mapper.dto.InsertUserDto;

@Mapper
public interface ArtMapper {
	
	@Select("Select * from artwork")
	List<ArtWork> findArtWorkAll();
	
	@Select("Select creator_profile_storefilename as image_url from creator where creator_id = ${creatorId}")
	String findByCreatorProfileImage(Long creatorId );
	
	@Select("Select * from artwork where artwork_images_id = ${artwork_images_id}")
	List<ArtWork> findArtWork();
	
	@Select("select creator_id as creatorId from creator where creator_nickname = #{nickname} ")
	Long findByCreator(String nickname);
	
	@Select("Select creator_nickname as nickname from creator where creator_id = ${creatorid}")
	String findByCreatorName( Long creatorid );
	
	@Select("select b.artwork_images_storefilename as storefilename "
			+ " from artwork a, artwork_images b "
			+ " where a.artwork_id = b.art_work_id and a.creator_id = ${creator}")
	List<StoreFileDTO> findByImageURL(Long creator);
	
	@Select("select creator_profile_storefilename as profileImage, "
			+ "		creator_nickname as nickname	"
			+ "from creator where creator_id = ${creaotr}")
	List<StoreFileDTO> findByCreatorImage(Long creator ); 
	
	@Select("select image.artwork_images_storefilename as image_url, "
			+ "art.artwork_title as title, "
			+ "image.artwork_images_id as imageId "
			+ "from artwork_images as image left join artwork as art "
			+ "on image.art_work_id = art.artwork_id left join creator "
			+ "on art.creator_id = creator.creator_id "
			+ "where creator.creator_id = ${creatorid}")
	List<BlogInfoDTO> findByCreatorBlogAll(Long creatorid);
	
	@Insert("Insert into artwork(artwork_category_name, artwork_content, artwork_register_date, artwork_title) values(#{subject},#{talk},now(),#{title})")
	void InsertUploadImg(String subject, String talk, String title);
	
	
	
	@Insert("Insert into artwork(artwork_id, "
			+ "					 artwork_category_name, "
			+ "					 artwork_content, "
			+ "					 artwork_register_date, "
			+ "					 artwork_title, "
			+ "					 creator_id ) "
		  + " values(null, "
		  + "		#{subject}, "
		  + "		#{talk}, "
		  + "		now(), "
		  + "		#{title}, "
		  + "		${creatorId})")
	@Options(useGeneratedKeys = true, keyColumn = "artwork_id", keyProperty="artworkId")
	Long insertArtWork( UploadFileDTO upload );
	
	@Insert("Insert into creator(creator_id,creator_nickname,user_profile_id) values(null,#{nickname},${userProfileId})")
	@Options(useGeneratedKeys = true, keyColumn = "creator_id", keyProperty="creatorId")
	Long insertCreatorNickname( UploadFileDTO upload );
			
}