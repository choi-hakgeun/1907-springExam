package mybatis;

public class MemberPhoto {
	int    serial;
	String mId;
	String oriFile;
	String sysFile;
	
	public MemberPhoto() {}
	public MemberPhoto(String ori, String sys) {
		this.oriFile = ori;
		this.sysFile = sys;
	}
	
	public String getmId() { return mId;	}
	public void setmId(String mId) {this.mId = mId;	}
	public int getSerial() {return serial;}
	public void setSerial(int serial) {this.serial = serial;}
	public String getOriFile() {return oriFile;	}
	public void setOriFile(String oriFile) {this.oriFile = oriFile;	}
	public String getSysFile() {return sysFile;	}
	public void setSysFile(String sysFile) {this.sysFile = sysFile;	}
	
}
