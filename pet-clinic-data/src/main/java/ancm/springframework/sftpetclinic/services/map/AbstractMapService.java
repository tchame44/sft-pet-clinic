package ancm.springframework.sftpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ancm.springframework.sftpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {
	
	protected Map<Long ,T> map = new HashMap<>();
	
	
	public Set<T> findAll(){
		return new HashSet<T>(map.values());
	}
	
	public T findById(ID id) {
		return map.get(id);
	}
	
	public T save(T object) {
		if(object !=null ) {
			if(object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object cannot be null");
		}
		return object;
	}
	
	public void deleteById(ID id) {
		map.remove(id);
	}
	
	public void delete(T object) {
		map.entrySet().removeIf(entry-> entry.getValue().equals(object));
	}
	
	
	private Long getNextId() {
		if(map.keySet().isEmpty()) {
			return 1L;
		}else {
			return Collections.max(map.keySet()) + 1;
		}
		
		
	}

}
