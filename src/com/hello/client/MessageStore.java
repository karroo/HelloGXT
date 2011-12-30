package com.hello.client;

import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.DataField;
import com.extjs.gxt.ui.client.data.HttpProxy;
import com.extjs.gxt.ui.client.data.JsonLoadResultReader;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.ModelType;
import com.google.gwt.http.client.RequestBuilder;

public class MessageStore {
	
	public static ListLoader<ListLoadResult<ModelData>> getLoader(){
		
		String url = "data/data.json";
	    HttpProxy<ListLoadResult<ModelData>> proxy = new HttpProxy<ListLoadResult<ModelData>>(new RequestBuilder(RequestBuilder.GET,url));
	    
	    ModelType type = new ModelType();
	    
	    
	    type.setRoot("records");
	    
	    
	    //type.setRecordName("records");
	    type.addField("symbol");
	    type.addField("price");
	    type.addField("change");
	    type.addField("etc","etc");
	    
	    
	    
	    

//	    DataField date = new DataField("lastPost", "post_time");
//	    date.setType(Date.class);
//	    date.setFormat("timestamp");
//	    type.addField(date);

	    JsonLoadResultReader<ListLoadResult<ModelData>> reader = new JsonLoadResultReader<ListLoadResult<ModelData>>(
	        type);

	    ListLoader<ListLoadResult<ModelData>> loader = new BaseListLoader<ListLoadResult<ModelData>>(proxy, reader);
	    
	    
	    return loader;
	    
//		this.add(new Message("안녕","하세요","요",18));
//		this.add(new Message("안녕","하세요","요",18));
//		this.add(new Message("안녕","하세요","요",18));
	}
	
	
	

	
}
