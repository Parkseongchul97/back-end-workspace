package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.semi.youtube.model.vo.VideoLike;

@Mapper
public interface VideoLikeMapper {
	
	void like(VideoLike vo);
	VideoLike likeCheck(VideoLike vo);
	void unlike(int code);

}
