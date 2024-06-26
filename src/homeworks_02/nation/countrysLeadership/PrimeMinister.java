package homeworks_02.nation.countrysLeadership;

import homeworks_02.nation.executivePower.MinisterOfForeignAffairs;
import homeworks_02.nation.executivePower.MinisterOfTheInterior;
import org.springframework.beans.factory.annotation.Autowired;

public class PrimeMinister {
    @Autowired
    private MinisterOfForeignAffairs ministerOfForeignAffairs;
    @Autowired
    private MinisterOfTheInterior ministerOfTheInterior;

    public void setMinisterOfForeignAffairs(MinisterOfForeignAffairs ministerOfForeignAffairs) {
        this.ministerOfForeignAffairs = ministerOfForeignAffairs;
    }

    public void setMinisterOfTheInterior(MinisterOfTheInterior ministerOfTheInterior) {
        this.ministerOfTheInterior = ministerOfTheInterior;
    }

    public void toDoWork() {
        System.out.println("Контроль за работой министерств.");
        ministerOfForeignAffairs.work();
        ministerOfTheInterior.work();
    }
}
