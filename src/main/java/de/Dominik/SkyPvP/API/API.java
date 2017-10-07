package me.SkyPvP.API.de;


import java.lang.reflect.Field;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

public class API {

	
	
	/* ItemCreate */
	public static ItemStack createItem1(Material material, int subid, String displayname){
		
		ItemStack item = new ItemStack(material, 1, (short)subid);
		ItemMeta mitem = item.getItemMeta();
		mitem.setDisplayName(displayname);
		item.setItemMeta(mitem);
		return item;
		
		
	}
	
	public static ItemStack createitem2(Material Material, int subid, int amount, String string, Enchantment Enchantment, int lvl) {
		ItemStack is = new ItemStack(Material, amount, (short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(string);
		im.addEnchant(Enchantment, lvl, true);
		ArrayList<String> il = new ArrayList<String>();
		im.setLore(il);
		is.setItemMeta(im);
		return is;
	}
	
	public static ItemStack createitem3(Material Material, int subid, int amount, String string) {
		ItemStack is = new ItemStack(Material, amount, (short)subid);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(string);
		ArrayList<String> il = new ArrayList<String>();
		im.setLore(il);
		is.setItemMeta(im);
		return is;
	}
	
	/* Actionbar */
	public static void sendActionbar(Player p, String msg){
		IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + msg + "\"}");
		PacketPlayOutChat packet = new PacketPlayOutChat(cbc, (byte) 2);
		((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
	}
	
	 
	 /* SendTitles */
		public static void sendTitle(Player p, String msg, int fadein, int stay, int fadeout) {
			
			PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"" + msg + "\"}"), fadein , stay, fadeout);
		
			PlayerConnection con = ((CraftPlayer)p).getHandle().playerConnection;
		
			con.sendPacket(packet);
		
		}
		
		public static void sendSubTitle(Player p, String msg, int fadein, int stay, int fadeout) {
			
			PacketPlayOutTitle packet = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"" + msg + "\"}"), fadein , stay, fadeout);
		
			PlayerConnection con = ((CraftPlayer)p).getHandle().playerConnection;
		
			con.sendPacket(packet);
		
		}
		
		public static void SendHeaderAndFooter(Player p, String header, String footer){
			
			if(header == null) header = "";
			if(footer == null) footer = "";
			
			IChatBaseComponent tabHeader = ChatSerializer.a("{\"text\":\"" + header + "\"}");	
			IChatBaseComponent tabFooter = ChatSerializer.a("{\"text\":\"" + footer + "\"}");
			
			PacketPlayOutPlayerListHeaderFooter headerpacket = new PacketPlayOutPlayerListHeaderFooter(tabHeader);
			
			try{
				Field field = headerpacket.getClass().getDeclaredField("b");
				field.setAccessible(true);
				field.set(headerpacket, tabFooter);
				
			} catch(Exception e){
				e.printStackTrace();
				
			} finally {
				
				((CraftPlayer)p).getHandle().playerConnection.sendPacket(headerpacket);
				
			}
		}
}
