package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.model.vo.Movie;
import com.jpa.repo.MovieDAO;

@Service
public class MovieService {
	
	@Autowired
	private MovieDAO dao;
	
	public void change(Movie movie) {
		dao.save(movie); // id가 없으면 추가 있으면 수정 둘다가능

	}
	
	public List<Movie> viewAll(){
		return dao.findAll();
	}
	public Movie view(int id) {
		return dao.findById(id).orElse(null); // 무비 객체가 아니면 null보냄
//		return dao.findById(id).get();  // 보내고 끝
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
}
