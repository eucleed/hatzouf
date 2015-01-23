package org.castafiore.iot;

import java.util.LinkedHashMap;
import java.util.Map;

import org.castafiore.iot.definitions.DeviceDefinition;
import org.castafiore.iot.websocket.DeviceStore;

public class MemoryDeviceStore implements DeviceStore{
	
	private Map<String, DeviceDefinition> db = new LinkedHashMap<String, DeviceDefinition>();

	public DeviceDefinition getDevice(String deviceId) {
		return db.get(deviceId);
	}

	public void storeDevice(DeviceDefinition definition) {
		db.put(definition.getDeviceid(), definition);
		
	}

}
