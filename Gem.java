import java.awt.Font;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem
{
	private GemType type;
	private int points;

	public Gem() {
		int[] values = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
		int rand = (int)(Math.random() * values.length);
		points = values[rand];
		rand = (int)(Math.random() * 3);
		if (rand == 0) {
			type = GemType.GREEN;
		}
		else if (rand == 1) {
			type = GemType.ORANGE;
		}
		else {
			type = GemType.BLUE;
		}
	}
	public Gem(GemType type, int points) {
		this.type = type;
		this.points = points;
	}
	@Override
	public String toString() {
		return type + " " + points;
	}
	public GemType getType() {
		return type;
	}
	public int getPoints() {
		return points;
	}
	public void draw(double x, double y) {
		String filename = "gem_blue.png";
		if(type == GemType.GREEN) {
			filename = "gem_green.png";
		}
		if(type == GemType.ORANGE) {
			filename = "gem_orange.png";
		}
		StdDraw.picture(x, y, filename);
		StdDraw.setFont(new Font("SansSerif", Font.BOLD, 14));
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.text(x, y, "" + points);
	}

	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;

		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		try
		{
			green.draw(0.3, 0.7);
			blue.draw(0.5, 0.7);
			orange.draw(0.7, 0.7);

			// A row of random gems
			for (int i = 0; i < maxGems; i++)
			{
				Gem g = new Gem();
				g.draw(1.0 / maxGems * (i + 0.5), 0.5);
			}
		}
		catch (ExceptionInInitializerError e) {}
	}
}