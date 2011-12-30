package com.hello.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.ModelData;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class JsonUtil {
	public static ModelData toModelData(JSONObject jo){
		ModelData data = new BaseModelData();
		for(String key:jo.keySet()){
			JSONValue value = jo.get(key);
			data.set(key, convert(value));
		}
		
		return data;
	}
	
	public static List toModelDataList(JSONArray ja){
		List list = new ArrayList();
		for(int i=0;i<ja.size();i++){
			list.add(convert(ja.get(i)));
		}
		
		return list;
	}
	
	private static Object convert(JSONValue value){
		if(value.isArray() !=null){
			return toModelDataList(value.isArray());
			
		}else if(value.isBoolean() !=null){
			return value.isBoolean().booleanValue();
			
		}else if(value.isNumber() !=null){
			return value.isNumber().doubleValue();
			
		}else if(value.isObject() !=null){
			return toModelData(value.isObject());
			
		}else if(value.isString() !=null){
			return value.isString().stringValue();
			
		}else{
			return null;
		}
	}
}
