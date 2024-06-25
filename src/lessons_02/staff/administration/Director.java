package lessons_02.staff.administration;

import org.springframework.beans.factory.annotation.Autowired;

public class Director {
    @Autowired
    private ProdactionChief prodactionChief;
    @Autowired
    private SalesChief salesChief;

    public void setProdactionChief(ProdactionChief prodactionChief) {
        this.prodactionChief = prodactionChief;
    }

    public void setSalesChief(SalesChief salesChief) {
        this.salesChief = salesChief;
    }

    public void manageCompany() {
        prodactionChief.giveOrders();
        salesChief.giveOrders();
    }

}
