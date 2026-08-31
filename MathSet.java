import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class MathSet {
    // Instance variables
	private Set<Integer> one;
	private Set<Integer> two;

    // Constructors
	public MathSet() {
        one = new TreeSet<>();
        two = new TreeSet<>();
    }

    public MathSet(Set<Integer> one, Set<Integer> two) {
        this.one = one;
        this.two = two;
    }


    // Other methods
	public Set<Integer> union() {
		Set<Integer> x = new TreeSet<>(one);
        x.addAll(two);
        return x;
	}

	public Set<Integer> intersection() {
		Set<Integer> x = new TreeSet<>(one);
        x.retainAll(two);
        return x;
	}

	public Set<Integer> differenceAMinusB() {
		Set<Integer> x = new TreeSet<>(one);
        x.removeAll(two);
        return x;
	}

	public Set<Integer> differenceBMinusA() {
		Set<Integer> x = new TreeSet<>(two);
        x.removeAll(one);
        return x;
	}

	public Set<Integer> symmetricDifference() {
		Set<Integer> result = new TreeSet<Integer>(one);
    	for (Integer i : two) {
        	if (!result.add(i)) {
            	result.remove(i);
        }
    }
    return result;
	}

	@Override
    public String toString() {
        // Already done! No need to change this
		return "Set one " + one + "\n" +	"Set two " + two +  "\n";
	}

	public MathSet(String line1, String line2) {
		one = new TreeSet<>();
		two = new TreeSet<>();

		Scanner k = new Scanner(line1);
		while (k.hasNextInt()) {
			one.add(k.nextInt());
		}
		Scanner b = new Scanner(line2);
		while (b.hasNextInt()) {
			two.add(b.nextInt());
		}
		k.close();
		b.close();
	}

	public static void main(String[] args) {
		try {
			Scanner fileScan = new Scanner(new File("mathsetdata.dat"));

			while (fileScan.hasNextLine()) {
				String line1 = fileScan.nextLine();
				String line2 = fileScan.nextLine();

				MathSet mathSet = new MathSet(line1, line2);

				System.out.println(mathSet);
				System.out.println("union - " + mathSet.union());
				System.out.println("intersection - " + mathSet.intersection());
				System.out.println("difference A-B - " + mathSet.differenceAMinusB());
				System.out.println("difference B-A - " + mathSet.differenceBMinusA());
				System.out.println("symmetric difference - " + mathSet.symmetricDifference());
				System.out.println();
			}

			fileScan.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}