package org.imooc.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.imooc.bean.Ad;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AdDto extends Ad{
    private String img;
    
    private MultipartFile imgFile;
    
    private List<String> list;
    
    private List<Ad> adList;
    
    private String[] strArray;
    
    private Map<String,String> map;
    
    private Map<String,Ad> adMap;
    
    private String attr;
    
    @DateTimeFormat(pattern="yyyyMMdd")
    private Date mydate; 
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String[] getStrArray() {
		return strArray;
	}

	public void setStrArray(String[] strArray) {
		this.strArray = strArray;
	}

	public List<Ad> getAdList() {
		return adList;
	}

	public void setAdList(List<Ad> adList) {
		this.adList = adList;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Map<String, Ad> getAdMap() {
		return adMap;
	}

	public void setAdMap(Map<String, Ad> adMap) {
		this.adMap = adMap;
	}

	public String getAttr() {
		return attr;
	}

	public void setAttr(String attr) {
		this.attr = attr;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")	
	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
    
    
}
