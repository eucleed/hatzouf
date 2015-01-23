package org.castafiore.iot.websocket;

import org.castafiore.iot.definitions.DeviceDefinition;

public interface DeviceStore {
	
	public DeviceDefinition getDevice(String deviceId);
	
	
	public void storeDevice(DeviceDefinition definition);
	
	

}
