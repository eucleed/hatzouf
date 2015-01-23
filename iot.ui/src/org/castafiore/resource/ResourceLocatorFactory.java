/*
 * Copyright (C) 2007-2010 Castafiore
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
 package org.castafiore.resource;


import org.castafiore.utils.BaseSpringUtil;
import org.castafiore.utils.StringUtil;

public class ResourceLocatorFactory {
	
	public static ResourceLocator getResourceLocator(String spec)
	{
		String[] parts =StringUtil.split(spec, ":");
		
		if(parts != null && parts.length >=2)
		{
			String type = parts[0];
			
			return BaseSpringUtil.getBean("resourcelocator_" + type);
		}
		
		throw new RuntimeException("unable to find resourcelocator for spec " + spec );
	}

}
