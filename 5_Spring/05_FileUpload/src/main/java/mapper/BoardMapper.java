package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

@Mapper
public interface BoardMapper {
	
	void writeBoard(Board board);
	List<Board> allBoard(Paging vo);
	Board selectBoard(int no);
	void remove(int no);
	void reWrite(Board board);
	int total();
}
