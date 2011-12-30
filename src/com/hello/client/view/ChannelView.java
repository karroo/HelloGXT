package com.hello.client.view;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.RadioGroup;
import com.extjs.gxt.ui.client.widget.form.TextArea;

public class ChannelView extends LayoutContainer {

	public ChannelView() {
		
		NumberField nmbrfldNewNumberfield = new NumberField();
		add(nmbrfldNewNumberfield);
		nmbrfldNewNumberfield.setFieldLabel("New NumberField");
		
		CheckBoxGroup chckbxgrpNewCheckboxgroup = new CheckBoxGroup();
		add(chckbxgrpNewCheckboxgroup);
		chckbxgrpNewCheckboxgroup.setFieldLabel("New CheckBoxGroup");
		
		RadioGroup rdgrpNewRadiogroup = new RadioGroup();
		add(rdgrpNewRadiogroup);
		rdgrpNewRadiogroup.setFieldLabel("New RadioGroup");
		
		TextArea txtrNewTextarea = new TextArea();
		add(txtrNewTextarea);
		txtrNewTextarea.setFieldLabel("New TextArea");
		
		LabelField lblfldNewLabelfield = new LabelField("New LabelField");
		add(lblfldNewLabelfield);
	}

}
