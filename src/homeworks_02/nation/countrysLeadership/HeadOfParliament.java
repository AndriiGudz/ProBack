package homeworks_02.nation.countrysLeadership;

import homeworks_02.nation.parlament.Deputy;

public class HeadOfParliament {
    private Deputy deputy;

    public void setDeputy(Deputy deputy) {
        this.deputy = deputy;
    }

    public void toDoWork() {
        System.out.println("Контроль за работой парламента.");
        deputy.work();
    }
}
