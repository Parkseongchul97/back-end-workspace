package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.semi.youtube.model.vo.Member;

@Mapper
public interface MemberMapper {
	Member idCheck (String id);
	void signup(Member member);

	
}
