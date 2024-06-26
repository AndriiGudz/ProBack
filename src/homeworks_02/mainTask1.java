package homeworks_02;

import homeworks_02.nation.countrysLeadership.HeadOfParliament;
import homeworks_02.nation.countrysLeadership.President;
import homeworks_02.nation.countrysLeadership.PrimeMinister;
import homeworks_02.nation.executivePower.MinisterOfForeignAffairs;
import homeworks_02.nation.executivePower.MinisterOfTheInterior;
import homeworks_02.nation.parlament.Deputy;

/*
Task 1
1. Разработать мини-приложение, похожее на то, которое делали на занятии.
2. Приложение должно содержать как минимум три сущности, которые должны
   зависеть друг от друга так, чтобы вызвав метод у одной из них, вызывались методы двух других.
3. Запустить приложение без Спринга, вызвав метод у родительской сущности
 */
public class mainTask1 {
    public static void main(String[] args) {
        Deputy deputy = new Deputy();
        MinisterOfForeignAffairs ministerOfForeignAffairs = new MinisterOfForeignAffairs();
        MinisterOfTheInterior ministerOfTheInterior = new MinisterOfTheInterior();

        PrimeMinister primeMinister = new PrimeMinister();
        primeMinister.setMinisterOfForeignAffairs(ministerOfForeignAffairs);
        primeMinister.setMinisterOfTheInterior(ministerOfTheInterior);

        HeadOfParliament headOfParliament = new HeadOfParliament();
        headOfParliament.setDeputy(deputy);

        President president = new President();
        president.setHeadOfParliament(headOfParliament);
        president.setPrimeMinister(primeMinister);

        president.manageCountry();
    }
}
