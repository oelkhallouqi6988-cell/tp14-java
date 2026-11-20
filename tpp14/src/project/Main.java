package project;

import ma.project.entities.Machine;
import ma.project.entities.Salle;
import ma.project.service.MachineService;
import ma.project.service.SalleService;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        // 1. Création et ajout des salles
        Salle s1 = new Salle(1, "s1", "Salle Informatique");
        Salle s2 = new Salle(2, "s2", "Salle Réseau");
        salleService.ajouter(s1);
        salleService.ajouter(s2);

        // 2. Création et ajout des machines
        Machine m1 = new Machine(1, "PC-HP", new Date(), s1);
        Machine m2 = new Machine(2, "PC-HP", new Date(), s1);
        Machine m3 = new Machine(3, "SERV-IBM", new Date(), s2);

        machineService.ajouter(m1);
        machineService.ajouter(m2);
        machineService.ajouter(m3);

        // 3. Affichage des machines de la salle A1
        System.out.println("--- Machines dans la salle s1 ---");
        List<Machine> machinesA1 = machineService.getMachinesBySalle(1);
        for (int i = 0; i < machinesA1.size(); i++) {
            System.out.println(machinesA1.get(i));
        }
        
     // 4. Test de modification
     m1.setRef("PC-DELL-PRO");
     machineService.modifier(m1);

     System.out.println("--- Après modification de m1 ---");
     System.out.println(machineService.getById(1));

     // 5. Test de suppression
     machineService.supprimer(m3);

     System.out.println("--- Liste de toutes les machines après suppression ---");
     List<Machine> toutes = machineService.getAll();

     for (int i = 0; i < toutes.size(); i++) {
         System.out.println(toutes.get(i));
     }
    
    }
}
