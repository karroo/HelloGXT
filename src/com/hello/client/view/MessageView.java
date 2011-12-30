package com.hello.client.view;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.hello.client.JsonUtil;

public class MessageView extends Composite {

	public MessageView() {
		
		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.setHeading("메시지상자");
		VBoxLayout vbl_cntntpnlNewContentpanel = new VBoxLayout();
		vbl_cntntpnlNewContentpanel.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);
		cntntpnlNewContentpanel.setLayout(vbl_cntntpnlNewContentpanel);
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ToolBar toolBar = new ToolBar();
		
		TextField txtfldNewTextfield = new TextField();
		toolBar.add(txtfldNewTextfield);
		txtfldNewTextfield.setWidth("115px");
		
		Button btnNewButton = new Button("상세");
		toolBar.add(btnNewButton);
		btnNewButton.setWidth("51px");
		
		Button btnNewButton_1 = new Button("메시지보내기");
		toolBar.add(btnNewButton_1);
		cntntpnlNewContentpanel.add(toolBar);
//		cntntpnlNewContentpanel.add(textBox);
		
		
		ColumnConfig clmncnfgNewColumn = new ColumnConfig("author", "작성자", 150);
		configs.add(clmncnfgNewColumn);
		
		ColumnConfig clmncnfgNewColumn_1 = new ColumnConfig("channel", "채널", 150);
		configs.add(clmncnfgNewColumn_1);
		
		ColumnConfig clmncnfgNewColumn_2 = new ColumnConfig("title", "제목", 150);
		configs.add(clmncnfgNewColumn_2);
		
		
		
	    
		final ListStore<ModelData> store = new ListStore<ModelData>();
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, "data/messagelist.json");
		try {
			Request request = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					//displayError("Couldn't retrieve JSON");
				}
				
				public void onResponseReceived(Request request, Response response) {
					if (200 == response.getStatusCode()) {
						//updateTable(asArrayOfStockData(response.getText()));
						String s = response.getText();
						System.out.println(s);
						JSONObject json = (JSONObject)JSONParser.parseLenient(s);

						ModelData data = JsonUtil.toModelData(json);
						
						store.add((List)data.get("messages"));
						
						
					} else {
						//displayError("Couldn't retrieve JSON (" + response.getStatusText()
						//   + ")");
					}
				}
			});
			
		} catch (RequestException e) {
			//displayError("Couldn't retrieve JSON");
		}
		
		final Grid<ModelData> grid = new Grid<ModelData>(store, new ColumnModel(configs));
		final MessageDetailWindow win = new MessageDetailWindow();
		grid.addListener(Events.CellDoubleClick, new Listener<GridEvent>(){

			@Override
			public void handleEvent(GridEvent be) {
				// TODO Auto-generated method stub
				ModelData data = grid.getSelectionModel().getSelectedItem();
				win.show();
				win.loadData(data);
			}
			
		});
		VBoxLayoutData vbld_grid = new VBoxLayoutData();
		vbld_grid.setFlex(1.0);
		cntntpnlNewContentpanel.add(grid, vbld_grid);
		grid.setBorders(true);
		
		PagingToolBar pagingToolBar = new PagingToolBar(10);
		cntntpnlNewContentpanel.add(pagingToolBar);
		initComponent(cntntpnlNewContentpanel);
		cntntpnlNewContentpanel.setSize("581px", "473px");
		
		
	}
	
	
	

}
