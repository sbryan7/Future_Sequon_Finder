public class MegaSiteRate {
    private int positionIdentifier;
    private double mutationRate;

    public MegaSiteRate(int positionIdentifier, double mutationRate) {
        this.positionIdentifier = positionIdentifier;
        this.mutationRate = mutationRate;
    }

    public int getPositionIdentifier() {
        return positionIdentifier;
    }

    public double getMutationRate() {
        return mutationRate;
    }

}
