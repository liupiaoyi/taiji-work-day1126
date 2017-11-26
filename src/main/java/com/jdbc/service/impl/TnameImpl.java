package com.jdbc.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.jdbc.pojo.Tname;

@Service
public class TnameImpl  {
	
	@Autowired
	private static JdbcTemplate jdbcTemplate;

//	 public Stream<List<Tname>> getInfo(){
//	       
//	        return Stream.generate(new Supplier<List<Tname>>() {
//
//				@Override
//				public List<Tname> get() {
//					
//					return getList();
//				}});
//	        }
//	 
	 public static List<Tname> getList(){
		 	String sql = "SELECT ID,NAME FROM Tname";
		 	List<Tname> lt = new ArrayList<>();
	        lt = jdbcTemplate.query(sql, new RowMapper<Tname>(){

	            @Override
	            public Tname mapRow(ResultSet rs, int rowNum) throws SQLException {
					Tname tn = new Tname();
					tn.setId(rs.getInt("id"));
					tn.setName(rs.getString("name"));
					System.out.println("555"+tn.toString());
					return tn;
	            }
	        });
	        
	        return lt;
	    }
	 

	}
