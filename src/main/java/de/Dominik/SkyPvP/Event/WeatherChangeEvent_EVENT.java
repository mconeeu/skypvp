package me.SkyPvP.Event.de;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeEvent_EVENT implements Listener{

	@EventHandler
	public void on(WeatherChangeEvent e){
		e.setCancelled(true);
	}
}
