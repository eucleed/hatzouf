package org.castafiore.iot.websocket;

import java.util.LinkedList;
import java.util.List;

import org.castafiore.iot.Device;
import org.castafiore.iot.DeviceRegistry;
import org.castafiore.iot.definitions.DeviceDefinition;

public class GenericDeviceRegistry implements DeviceRegistry {

	private DeviceStore deviceStore;

	private List<Device> devices = new LinkedList<Device>();

	public DeviceStore getDeviceStore() {
		return deviceStore;
	}

	public void setDeviceStore(DeviceStore deviceStore) {
		this.deviceStore = deviceStore;
	}

	@Override
	public DeviceDefinition getDeviceDefinition(String deviceId) {
		return deviceStore.getDevice(deviceId);
	}

	@Override
	public Device registerDevice(DeviceDefinition definition) {

		deviceStore.storeDevice(definition);
		Device device = getDevice(definition.getDeviceid());
		if (device != null) {
			devices.remove(device);
		}
		device = new Device(definition);
		devices.add(device);
		return device;

	}

	@Override
	public Device getDevice(String deviceId) {
		for (Device d : devices) {
			if (d.getDeviceId().equals(deviceId)) {
				return d;
			}
		}
		return null;
	}

	@Override
	public List<Device> getDevices() {
		return devices;
	}

}
