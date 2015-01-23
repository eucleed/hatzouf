package org.castafiore.iot.websocket;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.castafiore.iot.Device;
import org.castafiore.iot.DeviceRegistry;
import org.castafiore.iot.IOTApplet;

public abstract  class GenericIOTApplet implements IOTApplet {

	private DeviceRegistry registry;

	private List<String> deviceNames = new LinkedList<String>();

	private List<String> connectedDeviceIds = new LinkedList<String>();

	@Override
	public DeviceRegistry getRegistry() {
		return registry;
	}

	public void setRegistry(DeviceRegistry registry) {
		this.registry = registry;
	}

	public IOTApplet addRequiredDeviceName(String deviceName) {

		if (!deviceNames.contains(deviceName)) {
			deviceNames.add(deviceName);
		}
		return this;
	}

	public Device findDeviceById(String deviceId) {
		for (String d : connectedDeviceIds) {
			if (d.equals(deviceId)) {
				return getRegistry().getDevice(deviceId);
			}
		}
		return null;
	}

	public Device findDeviceByName(String deviceName) {
		for (String d : connectedDeviceIds) {
			Device device = getRegistry().getDevice(d);
			if (device.getName().equals(deviceName)) {
				return device;
			}
		}
		
		throw new RuntimeException("The device " + deviceName + " does not seem to be registered. Please switch on the device. And check if it working properly");
	}

	@Override
	public void onDeviceConnected(Device device) {
		
		connectedDeviceIds.remove(device.getDeviceId());
		connectedDeviceIds.add(device.getDeviceId());
		initDevice(device);

	}
	
	public abstract void initDevice(Device device);

	@Override
	public Collection<String> getRequiredDeviceNames() {
		return deviceNames;
	}

}
