package co.fourth.tuna.domain.common.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.fourth.tuna.domain.common.mapper.UniMapper;
import co.fourth.tuna.domain.common.service.UniMapperService;

@Service
public class UniMapperServiceImpl implements UniMapperService {

	@Autowired UniMapper map;
	
	@Override
	public List<Object> findByTable(String tableName, Object obj) {
		
		List<Map> maps = map.findByTableName(tableName);
		
		List<Object> objs = new ArrayList<>();
		
		for(int j=0; j<=maps.size()-1; j++) {
			
			String setMethodString = "set";
			String keyAttr = null;
			String methodString = null;
			
			Iterator itr = maps.get(j).keySet().iterator();
			while(itr.hasNext()) {
				keyAttr = (String)itr.next();
				methodString = setMethodString
						+keyAttr.substring(0,1).toUpperCase()
						+keyAttr.substring(1);
				try {
					Method[] methods = obj.getClass().getDeclaredMethods();
					for(int i=0; i<=methods.length-1; i++) {
						if(methodString.equals(methods[i].getName())) {
							System.out.println("invoke : "+methodString);
							methods[i].invoke(obj, maps.get(j).get(keyAttr));
						}
					}
					objs.add(obj);
				} catch ( Exception e) {
					
				}
			}
		}
		
		return objs;
	}
	
}
