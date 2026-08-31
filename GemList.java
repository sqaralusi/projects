import org.w3c.dom.Node;

public class GemList
{
    private Node first;

    private class Node {
        private Gem gem;
        private Node next;
    }

    public int size() {
        int count = 0;
        Node current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void draw(double y) {
        double x = 0.05;
        Node current = first;
        while (current != null) {
            current.gem.draw(x, y);
            x += 0.05;
            current = current.next;
        }
    }

    public String toString() {
        String result = "";
        Node current = first;

        while (current != null) {
            result += current.gem.getType().toString();
            if (current.next != null) {
                result += " -> ";
            }
            current = current.next;
        }
        return result.isEmpty() ? "<none>\n" : result;
    }

    public void insertBefore(Gem gem, int index) {
        if (index <= 0 || first == null) {
            Node newNode = new Node();
            newNode.gem = gem;
            newNode.next = first;
            first = newNode;
        } else {
            Node current = first;
            for (int i = 0; i < index - 1 && current.next != null; i++) {
                current = current.next;
            }
            Node newNode = new Node();
            newNode.gem = gem;
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int score() {
        int totalScore = 0;
        Node current = first;

        while (current != null) {
            int blockScore = current.gem.getPoints();
            int blockMultiplier = 1;

            Node nextNode = current.next;
            while (nextNode != null && current.gem.getType() == nextNode.gem.getType()) {
                blockScore += nextNode.gem.getPoints();
                blockMultiplier++;
                nextNode = nextNode.next;
            }

            totalScore += blockScore * blockMultiplier;
            current = nextNode;
        }

        return totalScore;
    }

    public static void main(String [] args)
    {
        GemList list = new GemList();
        System.out.println(list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        try
		{
			list.draw(0.9);
		}
		catch (ExceptionInInitializerError e) {}
        catch (NoClassDefFoundError n) {}


        list.insertBefore(new Gem(GemType.BLUE, 10), 0);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        try
		{
			list.draw(0.8);
		}
		catch (ExceptionInInitializerError e) {}
        catch (NoClassDefFoundError n) {}

        list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        try
		{
			list.draw(0.7);
		}
		catch (ExceptionInInitializerError e) {}
        catch (NoClassDefFoundError n) {}

        list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        try
		{
			list.draw(0.6);
		}
		catch (ExceptionInInitializerError e) {}
        catch (NoClassDefFoundError n) {}

        list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        try
		{
			list.draw(0.5);
		}
		catch (ExceptionInInitializerError e) {}
        catch (NoClassDefFoundError n) {}

        list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        try
		{
			list.draw(0.4);
		}
		catch (ExceptionInInitializerError e) {}
        catch (NoClassDefFoundError n) {}

        list.insertBefore(new Gem(GemType.GREEN, 50), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        try
		{
			list.draw(0.3);
		}
		catch (ExceptionInInitializerError e) {}
        catch (NoClassDefFoundError n) {}
    }
}