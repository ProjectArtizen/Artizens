package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import artizens.controller.dto.artwork.ArtDetailDTO;
import artizens.controller.dto.artwork.BlogInfoDTO;
import artizens.controller.dto.artwork.CommentDTO;
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
	
	@Select("select b.artwork_images_id as imageId, "
			+ "		b.artwork_images_storefilename as storefilename "
			+ "from artwork_images as b left join artwork as a on "
			+ "b.art_work_id = a.artwork_id left join creator c on "
			+ "a.creator_id = c.creator_id "
			+ "where c.creator_id = ${creator}")
	List<StoreFileDTO> findByImageURL(Long creator);
	
	@Select("select creator_profile_storefilename as profileImage, "
			+ "		creator_nickname as nickname, "
			+ "		creator_detail_intro as content	"
			+ "from creator where creator_id = ${creaotr}")
	List<StoreFileDTO> findByCreatorImage(Long creator ); 
	
	@Select("select image.artwork_images_storefilename as images,"
			+ "image.artwork_images_id as imageId, "
			+ "art.artwork_title as title, "
			+ "image.artwork_images_id as imageId "
			+ "from artwork_images as image left join artwork as art "
			+ "on image.art_work_id = art.artwork_id left join creator "
			+ "on art.creator_id = creator.creator_id "
			+ "where creator.creator_id = ${creatorid}")
	List<BlogInfoDTO> findByCreatorBlogAll( Long creatorid );
	
	@Select("select 	a.artwork_title as title,"
			+ "	a.artwork_content as content, " + 
			"	b.artwork_images_storefilename as images, " + 
			"	c.creator_profile_storefilename as profile, " + 
			"	c.creator_detail_intro as talk, " + 
			"	c.creator_nickname as nickname, " + 
			"	date_format(a.artwork_register_date,'%Y-%m-%d') as date " + 
			"	from artwork_images as b left join artwork as a on " + 
			"	b.art_work_id = a.artwork_id left join creator as c on " + 
			"	a.creator_id = c.creator_id " + 
			"	where b.artwork_images_id = ${imageId};")
	List<ArtDetailDTO> clickImageAction( Long imageId );
	
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
	
	@Insert("Insert into artwork_comment(artwork_comment_id, "
			+ "							 artwork_comment_conetent,"
			+ "							 artwork_comment_register_date,"
			+ "							 artwork_id,"
			+ "							 user_profile_id) "
			+ " values(null, "
			+ "		 #{comment}, "
			+ "		   now(), "
			+ "		 ${userid}, "
			+ "		 ${artworkId}")
	String insertComment(Long artworkId, Long userid, String comment );
			
}