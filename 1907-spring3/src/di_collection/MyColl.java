package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public interface MyColl {
	public void setList(List<String> list);
	public void setMap(Map<String, String> map);
	public void setSet(Set<String> set);
	public void setProps(Properties prop);
	
	//option
	public List<String> getList();
	public Map<String, String> getMap();
	public Set<String> getSet();
	public Properties getProps();
}
