package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionTest implements MyColl {
	List<String> list;
	Map<String, String> map;
	Set<String> set;
	Properties props;
	
	@Override
	public void setList(List<String> list) {
		this.list = list;
		for(String str : list) {
			System.out.println(str);
		}
	}

	@Override
	public void setMap(Map<String, String> map) {
		this.map = map;
		Set<String> keys = map.keySet();
		for(String k : keys) {
			System.out.println(k + " : " + map.get(k));
		}
	}

	@Override
	public void setSet(Set<String> set) {
		this.set = set;
		for(String str : set) {
			System.out.println(str);
		}
	}

	@Override
	public void setProps(Properties props) {
		this.props = props;
		Set<Object> propKey = props.keySet();
		for(Object k : propKey) {
			System.out.println(k + " : " +  props.get(k));
		}
	}

	//option

	public Properties getProps() { return props;	}
	public List<String> getList() {return list;	}
	public Map<String, String> getMap() {return map;	}
	public Set<String> getSet() {return set;	}

}
