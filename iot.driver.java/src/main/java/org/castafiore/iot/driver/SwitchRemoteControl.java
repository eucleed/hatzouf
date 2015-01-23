package org.castafiore.iot.driver;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.castafiore.iot.client.Device;
import org.castafiore.iot.client.OnReady;

public class SwitchRemoteControl extends Device {

	public SwitchRemoteControl() {
		super("SwitchRC",
				"SwitchRC", "Remote control", "");

		registerEvent("OnSwitchOn", "Event published when switched on");
		registerEvent("OnSwitchOff", "Published when switched off");
	}

	public void switchOn() {
		propagateEvent("OnSwitchOn", new HashMap<String, String>());
	}

	public void switchOff() {
		propagateEvent("OnSwitchOff", new HashMap<String, String>());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final SwitchRemoteControl device = new SwitchRemoteControl();
		device.onReady(new OnReady() {

			@Override
			public void ready() {

				String title = "Switch....";
				JFrame frame = new JFrame(title);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JButton switchon = new JButton("Switch on");
				switchon.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						device.switchOn();
					}
				});
				
				JButton switchoff = new JButton("Switch off");
				switchoff.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						device.switchOff();
					}
				});
				
				Container contentPane = frame.getContentPane();
				contentPane.add(switchon, BorderLayout.NORTH);
				contentPane.add(switchoff, BorderLayout.CENTER);

				frame.setSize(300, 125);
				frame.setVisible(true);

			}
		});
		device.setWebsocketLayer(new JavaWebsocketLayer(device));
		device.connect("ws://localhost:8080/iot/websockets/iot");
		try {
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
