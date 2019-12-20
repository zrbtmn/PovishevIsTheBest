package RationalFraction;

public class Fraction implements Comparable<Fraction> {

    private double numerator, denuminater;

    /**
     * 
     * @param x
     * @param y
     * @return
     */

    Fraction(final double x, final double y) {

        if (y == 0) {
            throw new IllegalArgumentException("Denum cant be zero");
        }
        else {
            this.numerator = x;
            this.denuminater = y;
            final double nod = NOD(numerator, denuminater);
            this.numerator /= nod;
            this.denuminater /= nod;
        }
    }

    public double getTop(){
        return numerator;
    }

    public double getBottom(){
        return denuminater;
    }

    public double printFraction(){
        return numerator / denuminater;
    }

    public double NOD(double numerator, double denuminater){
        numerator = Math.abs(numerator);
        denuminater = Math.abs(denuminater);
        while (numerator != 0 && denuminater != 0){
            if (numerator > denuminater) {numerator %= denuminater;}
            else {denuminater %= numerator;}
        }
        return numerator + denuminater;
    }

    public Fraction addFraction(final Fraction addiable){
        final double otherFractionNumerator = addiable.getTop();
        final double otherFractionDenuminater = addiable.getBottom();
        numerator = (numerator * otherFractionDenuminater + otherFractionNumerator * denuminater);
        denuminater = denuminater * otherFractionDenuminater;
        return new Fraction(numerator, denuminater);
    }

    @Override
    public String toString() {
        String txt;
        if (numerator == 0){
            txt = "[0]";
        }
        else if (denuminater == 1){
            txt = String.format("[%.0f]", numerator);
        }
        else txt = String.format("[%.0f / %.0f]", numerator, denuminater);
        return txt;
    }

    @Override
    public int compareTo(final Fraction compariable) {
        final double numeratorCompaiable = compariable.getTop();
        final double denuminatorCompariable = compariable.getBottom();
        final double num_1 = this.denuminater * numeratorCompaiable;
        final double num_2 = this.numerator * denuminatorCompariable;
        if (num_1 > num_2)
            return 1;
        else if (num_1 < num_2)
            return -1;
        else return 0;
    }

    public Fraction subFraction(final Fraction subtractablle){
        final double otherFractionNumerator = subtractablle.getTop();
        final double otherFractionDenuminater = subtractablle.getBottom();
        denuminater = denuminater * otherFractionDenuminater;
        numerator = (numerator * otherFractionDenuminater - otherFractionNumerator * denuminater);
        return new Fraction(numerator, denuminater);
    }

    public Fraction multiFraction(final Fraction multipliable){
        final double otherFractionNumerator = multipliable.getTop();
        final double otherFractionDenuminater = multipliable.getBottom();
        numerator *= otherFractionNumerator;
        denuminater *= otherFractionDenuminater;
        return new Fraction(numerator, denuminater);
    }

    // public Fraction multiNumber(final double multipliable){
    //     numerator *= multipliable;
    //     return new Fraction(numerator, denuminater);
    // }

    // public Fraction divFraction(final Fraction multipliable){
    //     final double otherFractionNumerator = multipliable.getTop();
    //     final double otherFractionDenuminater = multipliable.getBottom();
    //     numerator *= otherFractionDenuminater;
    //     denuminater *= otherFractionNumerator;
    //     return new Fraction(numerator, denuminater);
    // }
}