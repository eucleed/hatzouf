package org.castafiore.iot;

import java.util.List;

import org.castafiore.iot.definitions.DeviceDefinition;

public interface DeviceRegistry {

	public DeviceDefinition getDeviceDefinition(String deviceId);

	public Device getDevice(String deviceId);

	public Device registerDevice(DeviceDefinition definition);
	
	public List<Device> getDevices();

}
