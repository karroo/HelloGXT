package com.hello.client;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.hello.client.resources.Resources;
import com.hello.client.view.ChannelView;
import com.hello.client.view.MessageView;
import com.extjs.gxt.ui.client.widget.layout.CardLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HelloGXT implements EntryPoint{
	LayoutContainer contentPanel;
	CardLayout cardlayout;
	MessageView messageView;
	ChannelView channelView;
	@Override
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("800", "600");
		
		
		Viewport viewport = new Viewport();
		viewport.setBorders(true);
		viewport.setLayout(new FitLayout());
		
		LayoutContainer layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new RowLayout(Orientation.VERTICAL));
		
		LayoutContainer layoutContainer_1 = new LayoutContainer();
		
		Text txtNewText = new Text("UMS Manager");
		txtNewText.setStyleAttribute("font-size", "24px");
//		txtNewText.setStyleName("text-label");
		
		layoutContainer_1.add(txtNewText);
		txtNewText.setSize("210px", "47px");
		layoutContainer_1.setLayout(new CenterLayout());
		layoutContainer.add(layoutContainer_1, new RowData(Style.DEFAULT, 80.0, new Margins()));
		
		ToolBar toolBar = new ToolBar();
		
		Button btnNewButton = new Button("메시징");
		btnNewButton.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
			}
		});
		toolBar.add(btnNewButton);
		btnNewButton.setIcon(Resources.ICONS.menu_show());
		
		Menu menu = new Menu();
		
		MenuItem mntmNewMenuitem = new MenuItem("메시지");
		mntmNewMenuitem.addSelectionListener(new SelectionListener<MenuEvent>() {
			public void componentSelected(MenuEvent ce) {
				if(messageView == null) {
					messageView = new MessageView();
					contentPanel.add(messageView);
				}
				
				cardlayout.setActiveItem(messageView);
			
			}
		});
		menu.add(mntmNewMenuitem);
		
		MenuItem mntmNewMenuitem_1 = new MenuItem("채널");
		mntmNewMenuitem_1.addSelectionListener(new SelectionListener<MenuEvent>() {
			public void componentSelected(MenuEvent ce) {
				if(channelView == null) {
					channelView = new ChannelView();
					contentPanel.add(channelView);
				}
				
				cardlayout.setActiveItem(channelView);
			}
		});
		menu.add(mntmNewMenuitem_1);
		btnNewButton.setMenu(menu);
		
		Button btnNewButton_1 = new Button("운영관리");
		btnNewButton_1.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
			}
		});
		toolBar.add(btnNewButton_1);
		
		Menu menu_1 = new Menu();
		
		MenuItem mntmNewMenuitem_3 = new MenuItem("관리자");
		menu_1.add(mntmNewMenuitem_3);
		
		MenuItem mntmNewMenuitem_2 = new MenuItem("그룹");
		menu_1.add(mntmNewMenuitem_2);
		
		MenuItem menuItem = new MenuItem("동의항목");
		menu_1.add(menuItem);
		btnNewButton_1.setMenu(menu_1);
		
		Button btnNewButton_2 = new Button("컨텐츠관리");
		toolBar.add(btnNewButton_2);
		
		Button btnNewButton_3 = new Button("객체관리");
		toolBar.add(btnNewButton_3);
		
		Menu menu_2 = new Menu();
		
		MenuItem mntmNewMenuitem_4 = new MenuItem("회원관리");
		menu_2.add(mntmNewMenuitem_4);
		
		MenuItem mntmNewMenuitem_5 = new MenuItem("클럽관리");
		menu_2.add(mntmNewMenuitem_5);
		btnNewButton_3.setMenu(menu_2);
		
		Button btnNewButton_4 = new Button("아티클관리");
		toolBar.add(btnNewButton_4);
		layoutContainer.add(toolBar, new RowData(Style.DEFAULT, 25.0, new Margins()));
		
		LayoutContainer layoutContainer_2 = new LayoutContainer();
		layoutContainer_2.setLayout(new BorderLayout());
		
		contentPanel = new LayoutContainer();
		cardlayout = new CardLayout();
		contentPanel.setLayout(cardlayout);
		
		layoutContainer_2.add(contentPanel, new BorderLayoutData(LayoutRegion.CENTER));
		
		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.getHeader().setStyleAttribute("text-align"	,"center");
		cntntpnlNewContentpanel.setHideCollapseTool(true);
		cntntpnlNewContentpanel.setHeading("조직도");
		cntntpnlNewContentpanel.setCollapsible(true);
		BorderLayoutData bld_cntntpnlNewContentpanel = new BorderLayoutData(LayoutRegion.WEST);
		bld_cntntpnlNewContentpanel.setSplit(true);
		bld_cntntpnlNewContentpanel.setCollapsible(true);
		layoutContainer_2.add(cntntpnlNewContentpanel, bld_cntntpnlNewContentpanel);
		layoutContainer.add(layoutContainer_2, new RowData(Style.DEFAULT, 1.0, new Margins()));
		viewport.add(layoutContainer);
		layoutContainer.setBorders(true);
		rootPanel.add(viewport);
		rootPanel.setWidgetPosition(viewport, 0, 0);
		
		
	
		
	}
}
