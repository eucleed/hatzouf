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

import org.castafiore.ui.StatefullComponent;
import org.castafiore.ui.engine.JQuery;
import org.castafiore.ui.ex.EXContainer;
import org.castafiore.utils.StringUtil;

/**
 * 
 * 
 * @author Kureem Rossaye<br>
 *          kureem@gmail.com
 * Oct 22, 2008
 */
public abstract  class AbstractStatefullComponent<T> extends EXContainer implements StatefullComponent<T> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public AbstractStatefullComponent(String name, String tagName) {
		super(name, tagName);

	}

	
	public void requestFocus(){
		setAttribute("focus", "true");
	}
	
	
	public void onReady(JQuery query){
		if(StringUtil.isNotEmpty(getAttribute("focus"))){
			//query.eval("$('"+getId()+"')")
			query.invoke("focus");
		}
	}
	

	

}
