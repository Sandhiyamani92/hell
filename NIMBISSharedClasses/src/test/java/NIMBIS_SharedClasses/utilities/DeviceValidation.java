package NIMBIS_SharedClasses.utilities;

import java.util.HashMap;
import java.util.Map;

import NIMBIS_SharedClasses.deviceConfig.AndroidNode;
import NIMBIS_SharedClasses.deviceConfig.BrowserNode;
import NIMBIS_SharedClasses.deviceConfig.IOSNode;
import NIMBIS_SharedClasses.deviceConfig.Node;

public class DeviceValidation 
{
	private HashMap<String,Node> SeleniumGrid;
	private String Device;
	
	public DeviceValidation(HashMap<String,Node> SeleniumGrid, String Device)
	{
		this.SeleniumGrid = SeleniumGrid;
		this.Device = Device;
	}

	public String ValidateDevice()
	{
		String device = " ";
		 try
	 		{
	 			//Loop runs through all the Nodes in the Grid and performs the tests on them 
	 			for(Map.Entry<String, Node> currentNode : SeleniumGrid.entrySet())
	 			{
	 				if(currentNode.getKey().equals(Device))
	 				{
	 					//Android
	 					if(currentNode.getValue() instanceof AndroidNode)
	 					{
	 						device = "ANDROID";
	 					
	 					}
	 					
	 					//iOS
	 					else if(currentNode.getValue() instanceof IOSNode)
	 					{
	 							
	 						device = "IOS";
	 							
	 					}
	 					
	 					//Browsers
	 					else if(currentNode.getValue() instanceof BrowserNode)
	 					{
	 						device = "BROWSER";
	 						
	 					} 
	 				
	 				}
	 			}
	 		    	
	 	
	 		}
	 		
	 		catch (Exception e) 
	 		{
	 			e.printStackTrace();
	 		} 
		 return device;
	}
	

}
