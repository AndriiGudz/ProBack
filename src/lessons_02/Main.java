package lessons_02;

import lessons_02.staff.administration.Director;
import lessons_02.staff.administration.ProdactionChief;
import lessons_02.staff.administration.SalesChief;
import lessons_02.staff.specialists.prodaction.MachineOperator;
import lessons_02.staff.specialists.prodaction.Storekeeper;
import lessons_02.staff.specialists.sales.Merchandiser;
import lessons_02.staff.specialists.sales.SalesManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        MachineOperator machineOperator = new MachineOperator();
//        Storekeeper storekeeper = new Storekeeper();
//        Merchandiser merchandiser = new Merchandiser();
//        SalesManager salesManager = new SalesManager();
//
//        ProdactionChief prodactionChief = new ProdactionChief();
//        prodactionChief.setStorekeeper(storekeeper);
//        prodactionChief.setMachineOperator(machineOperator);
//
//        SalesChief salesChief = new SalesChief();
//        salesChief.setSalesManager(salesManager);
//        salesChief.setMerchandiser(merchandiser);
//
//        Director director = new Director();
//        director.setProdactionChief(prodactionChief);
//        director.setSalesChief(salesChief);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("lessons_02.config");
        Director director = context.getBean(Director.class);


        director.manageCompany();

    }
}
