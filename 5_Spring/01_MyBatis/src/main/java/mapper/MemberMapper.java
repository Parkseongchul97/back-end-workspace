package mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;
import com.mysql.cj.Session;

@Mapper
public interface MemberMapper {
	void register(Member member);
	ArrayList<Member> allMember();
	Member login(Member member);
	void update(Member member);
	ArrayList<Member> search(SearchDTO dto); 
	void delete(ArrayList<String> idList) ;
}
