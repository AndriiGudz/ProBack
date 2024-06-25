package lessons_02.staff.administration;

import lessons_02.staff.specialists.prodaction.MachineOperator;
import lessons_02.staff.specialists.prodaction.Storekeeper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdactionChief {
    @Autowired
    private MachineOperator machineOperator;
    @Autowired
    private Storekeeper storekeeper;

    public void setMachineOperator(MachineOperator machineOperator) {
        this.machineOperator = machineOperator;
    }

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public void giveOrders() {
        machineOperator.work();
        storekeeper.work();
    }

}
