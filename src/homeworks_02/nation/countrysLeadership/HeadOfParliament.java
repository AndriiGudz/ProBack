package homeworks_02.nation.countrysLeadership;

import homeworks_02.nation.parlament.Deputy;
import org.springframework.beans.factory.annotation.Autowired;

public class HeadOfParliament {
   @Autowired
    private Deputy deputy;

    public void setDeputy(Deputy deputy) {
        this.deputy = deputy;
    }

    public void toDoWork() {
        System.out.println("Контроль за работой парламента.");
        deputy.work();
    }
}
