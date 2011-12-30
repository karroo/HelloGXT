/*
 * Ext GWT 2.2.5 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.hello.client.resources;

import com.google.gwt.core.client.GWT;
import com.hello.client.resources.icons.ExampleIcons;
import com.hello.client.resources.images.ExampleImages;

public class Resources {

  public static final ExampleImages IMAGES = GWT.create(ExampleImages.class);
  public static final ExampleIcons ICONS = GWT.create(ExampleIcons.class);

}
