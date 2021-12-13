package artizens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artizens.domain.SampleVO;
import artizens.mapper.TestMapper;

@Service
public class SampleService {

	@Autowired TestMapper testMapper;
	
	public int save( String title, String name ) {
		int result = testMapper.insertContent(title, name);
		return result;
	}
	
	public List<SampleVO> findAll() {
		List<SampleVO> samplevo = testMapper.findAll();
		return samplevo;
	}
	
}
