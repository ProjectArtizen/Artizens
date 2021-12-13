package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

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
	
	@Select("Select * from artwork where artwork_images_id = ${artwork_images_id}")
	List<ArtWork> findArtWork();
	
	@Select("Select artwork_images_storefilename as storefilename from artwork_images;")
	List<StoreFileDTO> findByImageURL();
	
	@Insert("Insert into artwork(artwork_category_name, artwork_content, artwork_register_date, artwork_title) values(#{subject},#{talk},now(),#{title})")
	void InsertUploadImg(String subject, String talk, String title);
	
	@Insert("Insert into artWork(artwork_id, artwork_title, artwork_content) values((select * from (select max(next_val)+1 from hibernate_sequence) next), #{title}, #{content})")
	void insertArtWork(String title, String content);
	
	@Insert(" Insert into artwork(artwork_id,artwork_category_name, artwork_content, artwork_register_date,artwork_title) "
			+ "values(null,"
			+ "		#{subject},"
			+ "		#{talk}, "
			+ "		now(), "
			+ "		#{title})")
	@Options(useGeneratedKeys = true, keyColumn = "artwork_id", keyProperty="id")
	Long insertText( UploadFileDTO uploadfiledto );
	
		
}
