package org.castafiore.iot.driver;

import java.awt.BorderLayout;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.castafiore.iot.client.Device;
import org.castafiore.iot.client.FunctionHandler;
import org.castafiore.iot.client.OnReady;

public class BasicSwitch extends Device{

	public BasicSwitch() {
		super("BasicSwitch", "Switch","Switch" ,"switch.png");
		registerFunction("SwitchOn", "Function exposed to server");
		registerFunction("SwitchOff", "Function exposed to server for switching off the device");
		setWebsocketLayer(new JavaWebsocketLayer(this));
		
		
	}
	
	public static void main(String[] args) {
		final Device mydevice = new Device("BasicSwitch", "Switch","Switch" ,"switch.png");
		mydevice.registerFunction("SwitchOn", "Function exposed to server");
		mydevice.registerFunction("SwitchOff", "Function exposed to server for switching off the device");
		mydevice.setWebsocketLayer(new JavaWebsocketLayer(mydevice));
		final JLabel state = new JLabel();
		mydevice.addFunctionHandler(new FunctionHandler() {
			
			@Override
			public void execute(String name, Map<String, String> input) {
				if(name.equals("SwitchOn")){
					System.out.println("Switched  on");
					state.setText("Switched on");
				}else{
					System.out.println("Switched off");
					state.setText("Switched off");
				}
				
			}
		});
		
		mydevice.onReady(new OnReady() {
			
			@Override
			public void ready() {
				JFrame frame = new JFrame("My switch");
				frame.getContentPane().add(state, BorderLayout.NORTH);
				frame.setSize(200, 200);
				frame.setVisible(true);
				
			}
		});
		
		mydevice.connect("ws://localhost:8080/iot/websockets/iot");
		
		
		
		
		

	}

}
