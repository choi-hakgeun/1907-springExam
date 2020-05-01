package mybatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberVo {
	String mId; //(PK)
	String pwd;
  String mName; // not null
  String rDate; //입학일 not null
  int    grade; //학년 //check
  List<MemberPhoto> photos = new ArrayList<MemberPhoto>();
  
	public String getmId() { return mId;	}
	public void setmId(String mId) { this.mId = mId; 	}
	public String getmName() { return mName; 	}
	public void setmName(String mName) { this.mName = mName; 	}
	public String getrDate() { return rDate; 	}
	public void setrDate(String rDate) { this.rDate = rDate; 	}
	public int getGrade() { return grade; 	}
	public void setGrade(int grade) { this.grade = grade; 	}
	public String getPwd() { return pwd; 	}
	public void setPwd(String pwd) {this.pwd = pwd; 	}
	public List<MemberPhoto> getPhotos() {return photos; 	}
	public void setPhotos(List<MemberPhoto> photos) { this.photos = photos; 	}
  
  
  
}
