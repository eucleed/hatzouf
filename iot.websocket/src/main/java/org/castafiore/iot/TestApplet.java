package org.castafiore.iot;

import java.util.Map;

import org.castafiore.iot.websocket.GenericIOTApplet;
 
public class TestApplet extends GenericIOTApplet implements EventListener{

	public TestApplet(){
		addRequiredDeviceName("Switch");
		addRequiredDeviceName("SwitchRC");
		
	}

	@Override
	public void initDevice(Device device) {
		if(device.getName().equals("SwitchRC")){
			device.addEvent(new OnSwitchOn(), "OnSwitchOn");
			device.addEvent(new OnSwitchOff(), "OnSwitchOff");
		}
		
	}

	@Override
	public void execute(Device source,String type, Map<String, String> parameters) {
		
			if(type.equals("OnSwitchOn")){
				findDeviceByName("Switch").invoke("SwitchOn");
			}else{
				findDeviceByName("Switch").invoke("SwitchOff");
			}
			
			
		
		
	}
	
	class OnSwitchOn implements EventListener{

		@Override
		public void execute(Device source, String type,
				Map<String, String> parameters) {
			findDeviceByName("Switch").invoke("SwitchOn");
			
		}
		
	}
	
	class OnSwitchOff implements EventListener{

		@Override
		public void execute(Device source, String type,
				Map<String, String> parameters) {
			findDeviceByName("Switch").invoke("SwitchOff");
			
		}
		
	}

}
