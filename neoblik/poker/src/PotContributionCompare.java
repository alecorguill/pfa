package poker;
import java.util.*;


class PotContributionCompare implements Comparator<PotContribution> {
 /**
     * This method compare two PotContribution 
     * based on the value of the PotContribution
     */
    @Override
    public int compare(PotContribution pc1, PotContribution pc2) {
        return pc1.getContribution() - pc2.getContribution();
    }
}
