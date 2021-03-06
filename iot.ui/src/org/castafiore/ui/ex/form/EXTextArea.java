/*
 * Copyright (C) 2007-2008 Castafiore
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */

package org.castafiore.ui.ex.form;

/**
 * 
 * @author Kureem Rossaye<br>
 *          kureem@gmail.com
 * June 27 2008
 */ 
public class EXTextArea extends AbstractStatefullComponent<String> {

	public EXTextArea(String name) {
		super(name, "textarea");
		addClass("form-control");
		
	}

	public EXTextArea(String name, String value) {
		super(name, "textarea");
		setValue(value);
		addClass("form-control");
	}
	public String getValue() {
		return super.getAttribute("value");
	}

	
	public void setValue(String value) {
		super.setAttribute("value", value);
		setText(value);
	}
	
	
	public void setColumns(int columns){
		setAttribute("cols", columns + "");
	}
	
	public void setRows(int rows){
		setAttribute("rows", rows + "");
	}

	public void setEnabled(boolean enabled) {
		if(enabled){
			setAttribute("disabled", (String)null);
		}else{
			setAttribute("disabled", "disabled");
		}
	}

	public boolean isEnabled() {
		return getAttribute("disabled").equals("disabled");
	}


	

}
