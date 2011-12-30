package com.hello.client.view;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;

public class MessageDeviceView extends ContentPanel {

	ListStore<ModelData> store;
	public MessageDeviceView() {
		VBoxLayout boxLayout = new VBoxLayout();
		boxLayout.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);
		setLayout(boxLayout);
		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();
		
		ColumnConfig clmncnfgNewColumn = new ColumnConfig("device", "New Column", 100);
		configs.add(clmncnfgNewColumn);
		
		ColumnConfig clmncnfgNewColumn_1 = new ColumnConfig("receive", "New Column", 100);
		configs.add(clmncnfgNewColumn_1);
		
		ColumnConfig clmncnfgNewColumn_3 = new ColumnConfig("date", "New Column", 100);
		configs.add(clmncnfgNewColumn_3);
		store = new ListStore<ModelData>();
		Grid grid = new Grid(store, new ColumnModel(configs));
		VBoxLayoutData vbld_grid = new VBoxLayoutData();
		vbld_grid.setFlex(1.0);
		add(grid, vbld_grid);
		grid.setBorders(true);
		
		PagingToolBar pagingToolBar = new PagingToolBar(10);
		add(pagingToolBar);
	}

	public void loadData(List list) {
		// TODO Auto-generated method stub
		store.add(list);
	}

}
