package com.hello.client.view;

import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;

public class MessageDetailView extends ContentPanel {

	FormBinding formBindings;
	public MessageDetailView() {
		setLayout(new FitLayout());
		
		FormPanel frmpnlNewFormpanel = new FormPanel();
		frmpnlNewFormpanel.setHeaderVisible(false);
		frmpnlNewFormpanel.setCollapsible(true);
		
		TextField txtfldNewTextfield = new TextField();
		txtfldNewTextfield.setName("author");
		frmpnlNewFormpanel.add(txtfldNewTextfield, new FormData("50%"));
		txtfldNewTextfield.setFieldLabel("New TextField");
		
		TextField txtfldNewTextfield_1 = new TextField();
		txtfldNewTextfield_1.setName("title");
		frmpnlNewFormpanel.add(txtfldNewTextfield_1, new FormData("50%"));
		txtfldNewTextfield_1.setFieldLabel("New TextField");
		
		TextField txtfldNewTextfield_2 = new TextField();
		txtfldNewTextfield_2.setName("channel");
		frmpnlNewFormpanel.add(txtfldNewTextfield_2, new FormData("50%"));
		txtfldNewTextfield_2.setFieldLabel("New TextField");
		
		TextField txtfldNewTextfield_3 = new TextField();
		txtfldNewTextfield_3.setName("type");
		frmpnlNewFormpanel.add(txtfldNewTextfield_3, new FormData("50%"));
		txtfldNewTextfield_3.setFieldLabel("New TextField");
		add(frmpnlNewFormpanel);
		
		
	    formBindings = new FormBinding(frmpnlNewFormpanel, true);  
	}

	public void loadData(ModelData data) {
		// TODO Auto-generated method stub
		
	    formBindings.bind(data);
	    
	}

}
