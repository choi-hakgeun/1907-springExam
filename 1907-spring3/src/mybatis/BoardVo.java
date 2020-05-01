package mybatis;

public class BoardVo {
	int    serial;
	String subject = "";
	String content = "";
	String mDate = "";
	String id = "";
	String pwd = "";
	int    hit;
	int    pSerial;
	int    attCnt; //첨부 파일의 개수
	
	
	public int getSerial() { return serial; }
	public void setSerial(int serial) { this.serial = serial; }
	public String getSubject() { return subject; }
	public void setSubject(String subject) { this.subject = subject; }
	public String getContent() { return content; }
	public void setContent(String content) { this.content = content; }
	public String getmDate() { return mDate; }
	public void setmDate(String mDate) { this.mDate = mDate; }
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPwd() { return pwd; }
	public void setPwd(String pwd) { this.pwd = pwd; }
	public int getHit() { return hit; }
	public void setHit(int hit) { this.hit = hit; }
	public int getpSerial() { return pSerial; }
	public void setpSerial(int pSerial) { this.pSerial = pSerial; }
	public int getAttCnt() { return attCnt; }
	public void setAttCnt(int attCnt) { this.attCnt = attCnt; }
	
	
	
}
