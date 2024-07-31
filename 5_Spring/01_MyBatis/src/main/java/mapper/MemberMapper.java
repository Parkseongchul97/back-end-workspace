package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.vo.Member;
import com.mysql.cj.Session;

@Mapper
public interface MemberMapper {
	void register(Member member);
	ArrayList<Member> allMember();
	Member login(Member member);
	void update(Member member);
}
