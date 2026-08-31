public class Part implements Comparable<Part> {
    // Instance variables
    private String make;
    private String model;
    private String partNameNumber;
    private int year;

    // Constructor
    public Part(String line) {
        String[] tokens = line.split(" ");
        this.year = Integer.parseInt(tokens[tokens.length - 1]);
        this.model = tokens[tokens.length - 2];
        this.make = tokens[tokens.length - 3];
        this.partNameNumber = "";
        for (int i = 0; i < tokens.length - 3; i++) {
            this.partNameNumber += tokens[i] + " ";
        }
        this.partNameNumber = this.partNameNumber.trim();
    }

    @Override public int compareTo(Part other)
    {
        if (!this.make.equals(other.make)) {
            return this.make.compareTo(other.make);
        }
        else if (!this.model.equals(other.model)) {
            return this.model.compareTo(other.model);
        }
        else if (this.year != other.year) {
            return Integer.compare(this.year, other.year);
        } 
        else {
            return this.partNameNumber.compareTo(other.partNameNumber);
        }
    }

    @Override public String toString()
    {
        return make + " " + model + " " + year + " " + partNameNumber;
    }
}