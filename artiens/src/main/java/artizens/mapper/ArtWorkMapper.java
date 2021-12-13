package artizens.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import artizens.domain.ArtWork;
import artizens.domain.ArtWorkImages;
import artizens.mapper.dto.AbstractDto;
import artizens.mapper.dto.ArtWorkMainDto;
import artizens.mapper.dto.ColoringDto;
import artizens.mapper.dto.FigureDto;
import artizens.mapper.dto.InkpaintingDto;
import artizens.mapper.dto.LandscapeDto;
import artizens.mapper.dto.PopartDto;
import artizens.mapper.dto.StillDto;

@Mapper
public interface ArtWorkMapper {
	
	@Select("Select * from artwork")
	List<ArtWork> findArtWorkAll();
	
	@Select("Select * from artwork where artwork_images_id = ${artwork_images_id}")
	List<ArtWork> findArtWork();
	
	@Insert("Insert into artwork(artwork_category_name, artwork_content, artwork_register_date, artwork_title) values(#{subject},#{talk},now(),#{title})")
	void InsertUploadImg(String subject, String talk, String title);
	
	@Insert("Insert into artWork(artwork_id, artwork_title, artwork_content) values((select * from (select max(next_val)+1 from hibernate_sequence) next), #{title}, #{content})")
	void insertArtWork(String title, String content);
	
	// 작품 메인 페이지 최신순 출력 쿼리
	@Select("select " + 
			"a.artwork_id as id," + 
			"a.artwork_title as title, " + 
			"b_img.artwork_images_storefilename as artworkImgName, " + 
			"c.creator_profile_storefilename as creatorImgName, " + 
			"c.creator_nickname as creatorNickName, " + 
			"(select count(*) from artwork_sympathy where artwork_sympathy_id = a.artwork_id) as likeCount, " + 
			"(select count(*) from artwork_comment where artwork_id = a.artwork_id) as commentCount " + 
			"from artwork as a " + 
			"left join artwork_images as b_img " + 
			"on a.artwork_id = b_img.artwork_images_id " + 
			"left join creator as c " + 
			"on a.creator_id = c.creator_id limit 20;")
	List<ArtWorkMainDto> findArtWorkMainAll();
	
	// 수묵화 상세페이지 출력 쿼리
	@Select("")
	List<InkpaintingDto> findInkpainting();
	
	// 채색화 상세페이지 출력 쿼리
	@Select("")
	List<ColoringDto> findColoring();
	
	// 풍경화 상세페이지 출력 쿼리
	@Select("")
	List<LandscapeDto> findLandscape();
	
	// 인물화 상세페이지 출력 쿼리
	@Select("")
	List<FigureDto> findFigure();
	
	// 추상화 상세페이지 출력 쿼리
	@Select("")
	List<AbstractDto> findAbstract();
	
	// 정물화 상세페이지 출력 쿼리
	@Select("")
	List<StillDto> findStill();
	
	// 팝아트 상세페이지 출력 쿼리
	@Select("")
	List<PopartDto> findPopart();
	
}
