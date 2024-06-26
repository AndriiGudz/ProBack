package homeworks_02.nation.countrysLeadership;

public class President {
    private HeadOfParliament headOfParliament;
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
