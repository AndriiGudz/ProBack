package homeworks_02.nation.countrysLeadership;

import org.springframework.beans.factory.annotation.Autowired;

public class President {
    @Autowired
    private HeadOfParliament headOfParliament;
    @Autowired
    private PrimeMinister primeMinister;

    public void setHeadOfParliament(HeadOfParliament headOfParliament) {
        this.headOfParliament = headOfParliament;
    }

    public void setPrimeMinister(PrimeMinister primeMinister) {
        this.primeMinister = primeMinister;
    }

    public void manageCountry() {
        System.out.println("Управление государством.");
        headOfParliament.toDoWork();
        primeMinister.toDoWork();
    }
}
