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

package org.castafiore.ui.ex.form.table;

import java.util.Map;

import org.castafiore.ui.Container;
import org.castafiore.ui.UIException;
import org.castafiore.ui.engine.JQuery;
import org.castafiore.ui.events.Event;
import org.castafiore.ui.ex.EXContainer;
import org.castafiore.ui.js.JMap;
import org.castafiore.ui.js.Var;
/**
 * 
 * 
 * @author Kureem Rossaye<br>
 *          kureem@gmail.com
 * Oct 22, 2008
 */
public class EXPagineableTable extends EXContainer {

	public EXPagineableTable(String name, Table table) {
		super(name, "div");
		
		addChild(table);
		createPaginator(table);
	}
	public Table getTable()
	{
		return getDescendentOfType(Table.class);
	}
	
	/**
<div class="EXPageIterator">
	<div class="PageIteratorContainer">
		<div class="RightPageIteratorBlock">
			<a class="Icon LastTopPageIcon" /> 
			<a class="Icon LastPageIcon"></a>

			<div class="Number">
				<a class="PageSelected">1</a>
				<a>2</a>
			</div>

			<a class="Icon NextPageIcon" />


			<a class="Icon NextTopPageIcon"><span /></a>

			<div style="clear: left;"><span /></div>
			
		</div>
	</div>
</div>


	

	 * @param table
	 */
	
	
	public void refresh()
	{
		if(this.getChildren().size() >1)
			this.getChildren().remove(1);
		this.setRendered(false);
		Table table = (Table)getChildByIndex(0);
		table.refresh();
		createPaginator(table);
	}
	
	
	private void createPaginator(Table table){
		final int pages = table.getPages();
		if(pages > 1){
			Container pagin = new EXContainer("pagin", "div").addClass("EXPageIterator");
			pagin.addChild(new EXContainer("mleft", "a").addClass("Icon LastTopPageIcon"));
			pagin.addChild(new EXContainer("oleft", "a").addClass("Icon LastPageIcon"));
			pagin.addChild(new EXContainer("p_wrap", "div").addClass("paginator_p_wrap").addClass("PageIteratorContainer").addChild(new EXContainer("paginator_p_bloc", "div").addClass("paginator_p_bloc")));
			
			pagin.addChild(new EXContainer("oright", "a").addClass("Icon NextPageIcon"));
			pagin.addChild(new EXContainer("mright", "a").addClass("Icon NextTopPageIcon"));
			addChild(pagin);
			pagin.addEvent(new Event(){
	
				@Override
				public void ClientAction(JQuery container) {
					
					JMap options = new JMap();
					options.put("nbPages", pages-2);
					options.put("overBtnLeft", container.getDescendentByName("oleft").getIdRef());
					options.put("overBtnRight", container.getDescendentByName("oright").getIdRef());
					options.put("maxBtnLeft", container.getDescendentByName("mleft").getIdRef());
					options.put("maxBtnRight", container.getDescendentByName("mright").getIdRef());
					
					JQuery clickpage = container.clone();
					clickpage.makeServerRequest(new JMap().put("page", new Var("num")),this);
					
					options.put("onPageClicked", clickpage, "a", "num");
					
					
					container.invoke("jPaginator", options);
					//container.getScript("js1/jPaginator-min.js", callback);
					
				}
	
				@Override
				public boolean ServerAction(Container container,
						Map<String, String> request) throws UIException {
					int  page = Integer.parseInt(request.get("page"));
					
					container.getAncestorOfType(EXPagineableTable.class).getDescendentOfType(Table.class).changePage(page);
					return true;
				}
	
				@Override
				public void Success(JQuery container,
						Map<String, String> request) throws UIException {
					// TODO Auto-generated method stub
					
				}
				
			}, Event.READY);
		}
	}
	
	
}
