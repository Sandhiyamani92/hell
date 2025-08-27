package NIMBIS_SharedClasses.utilities;

public class ElementColour 
{
	private int redValue;
	private int greenValue;
	private int blueValue;
	
	public int getRedValue() 
	{
		return redValue;
	}

	public void setRedValue(int redValue) 
	{
		this.redValue = redValue;
	}

	public int getGreenValue() 
	{
		return greenValue;
	}

	public void setGreenValue(int greenValue) 
	{
		this.greenValue = greenValue;
	}

	public int getBlueValue() 
	{
		return blueValue;
	}

	public void setBlueValue(int blueValue) 
	{
		this.blueValue = blueValue;
	}
	
	public ElementColour(int red, int green, int blue)
	{
		setRedValue(red);
		setGreenValue(green);
		setBlueValue(blue);
	}
}
