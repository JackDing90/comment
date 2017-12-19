package annotation;

import javax.annotation.Resource;

import org.imooc.bean.Business;
import org.imooc.dao.BusinessDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})  
public class TestSpring {
	
	@Resource
	private BusinessDao businessDao;
	 
	@Test
	public void selectbyid(){
		Business selectById = businessDao.selectById(1L);
		System.out.println(selectById);
	}
}
