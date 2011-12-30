package com.hello.client.view;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;

public class MessagetTargetView extends ContentPanel {

	private ListStore<ModelData> store;
	public MessagetTargetView() {
		VBoxLayout boxLayout = new VBoxLayout();
		boxLayout.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);
		setLayout(boxLayout);
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNewColumn = new ColumnConfig("targetname", "New Column", 150);
		configs.add(clmncnfgNewColumn);
		
		ColumnConfig clmncnfgNewColumn_1 = new ColumnConfig("targetid", "New Column", 150);
		configs.add(clmncnfgNewColumn_1);
		
		ColumnConfig clmncnfgNewColumn_2 = new ColumnConfig("org", "New Column", 150);
		configs.add(clmncnfgNewColumn_2);
		
		ColumnConfig clmncnfgNewColumn_3 = new ColumnConfig("info", "New Column", 150);
		configs.add(clmncnfgNewColumn_3);
		
		store = new ListStore<ModelData>();
		Grid<ModelData> grid = new Grid<ModelData>(store, new ColumnModel(configs));
		grid.getSelectionModel().addSelectionChangedListener(new SelectionChangedListener<ModelData>(){

			@Override
			public void selectionChanged(SelectionChangedEvent<ModelData> se) {
				// TODO Auto-generated method stub
				window.show();
				device.loadData((List)se.getSelectedItem().get("messagedevices"));
				
			}
			
		});
		VBoxLayoutData vbld_grid = new VBoxLayoutData();
		vbld_grid.setFlex(1.0);
		add(grid, vbld_grid);
		grid.setBorders(true);
		
		PagingToolBar pagingToolBar = new PagingToolBar(10);
		add(pagingToolBar);
		
		
	}
	
	private Window window = getWindow();
	MessageDeviceView device;
	private Window getWindow(){
		final Window window = new Window();  
	    window.setSize(500, 300);  
	    window.setPlain(true);  
	    window.setModal(true);  
	    window.setBlinkModal(true);  
	    window.setHeading("Hello Window");  
	    window.setLayout(new FitLayout());  
	    device= new MessageDeviceView();
	    window.add(device);
	    return window;
	    
	}
	public void loadData(List<ModelData> list) {
		// TODO Auto-generated method stub
		store.add(list);
	}

}
