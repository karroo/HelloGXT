package com.hello.client.view;

import java.util.List;

import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class MessageDetailWindow extends Window {

	MessageDetailView messageDetailView;
	MessageTargetView messagetTargetView;
	public MessageDetailWindow() {
		setHeading("New Window");
		setLayout(new FitLayout());
		
		TabPanel tabPanel = new TabPanel();
		
		TabItem tbtmNewTabitem_1 = new TabItem("New TabItem");
		messageDetailView = new MessageDetailView();
		messageDetailView.setHeaderVisible(false);
		tbtmNewTabitem_1.add(messageDetailView);
		tabPanel.add(tbtmNewTabitem_1);
		tbtmNewTabitem_1.setLayout(new FitLayout());
		
		
		
		TabItem tbtmNewTabitem = new TabItem("New TabItem");
		
		messagetTargetView = new MessageTargetView();
		messagetTargetView.setHeaderVisible(false);
		messagetTargetView.setHeading("");
		tbtmNewTabitem.add(messagetTargetView);
		tabPanel.add(tbtmNewTabitem);
		tbtmNewTabitem.setLayout(new FitLayout());

		
		add(tabPanel);
	}
	
	public void loadData(ModelData data){
		messageDetailView.loadData(data);
		messagetTargetView.loadData((List)data.get("messagetargets"));
	}

}
