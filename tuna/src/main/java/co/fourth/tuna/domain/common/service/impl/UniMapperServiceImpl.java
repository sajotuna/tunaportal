package co.fourth.tuna.domain.common.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.fourth.tuna.domain.common.mapper.UniMapper;
import co.fourth.tuna.domain.common.service.UniMapperService;

@Service
public class UniMapperServiceImpl implements UniMapperService {

	@Autowired UniMapper map;
	
	@Override
	public Object findByTable(String tableName, Object obj) {
		return null;
		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		List<Map> maps = map.findByTableName(tableName);
//		List<Object> objs = new ArrayList<>();
//		
//		for(int i=0; i <= maps.size(); i++) {
//			try {
//				System.out.println("try here!!!");
//				System.out.println(maps.get(i));
//				List<HashMap<String, String>> tempMap = mapper.(maps.get(i), new TypeReference<List<HashMap<String, String>>>(){
//					
//				});
//				System.out.println("here??");
//				objs.add( mapper.convertValue(tempMap, obj.getClass() ));
//				System.out.println(objs);
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//			
//		}
//		
//		return objs;
		
		
//		List<Map> maps = map.findByTableName(tableName);
//		System.out.println(maps.toString());
//		List<Object> objs = new ArrayList<>();
//		String setMethodString = "set";
//		String keyAttr = null;
//		String methodString = null;
//		
//		for(int j=0; j<=maps.size()-1; j++) {			
//			
//			Iterator itr = maps.get(j).keySet().iterator();
//			while(itr.hasNext()) {
//				keyAttr = (String)itr.next();
//				methodString = setMethodString
//						+keyAttr.substring(0,1).toUpperCase()
//						+keyAttr.substring(1).toLowerCase();
//				try {
//					Method[] methods = obj.getClass().getDeclaredMethods();
//					for(int i=0; i<=methods.length-1; i++) {
//						System.out.println("invoke?");
//						System.out.println(methodString);
//						System.out.println(methods[i].getName());
//						if(methodString.equals(methods[i].getName())) {
//							System.out.println("invoke : "+methodString);
//							methods[i].invoke(obj, maps.get(j).get(keyAttr));
//						}
//					}
//				} catch ( Exception e) {
//					
//				}
//			}
//			objs.add(obj);
//		}
//		
//		return objs;
	}

}
