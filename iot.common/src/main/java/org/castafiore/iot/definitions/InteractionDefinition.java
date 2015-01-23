package org.castafiore.iot.definitions;

import java.util.LinkedList;
import java.util.List;

public class InteractionDefinition {

	private List<EventDefinition> events = new LinkedList<EventDefinition>();

	private List<FunctionDefinition> functions = new LinkedList<FunctionDefinition>();

	public List<EventDefinition> getEvents() {
		return events;
	}

	public void setEvents(List<EventDefinition> events) {
		this.events = events;
	}

	public List<FunctionDefinition> getFunctions() {
		return functions;
	}

	public void setFunctions(List<FunctionDefinition> functions) {
		this.functions = functions;
	}

	
	

}
