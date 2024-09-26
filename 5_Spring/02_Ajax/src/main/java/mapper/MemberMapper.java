package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.model.vo.Member;

@Mapper
public interface MemberMapper {
	Member idCheck(String id);
	void serialize(Member member);
	
}
