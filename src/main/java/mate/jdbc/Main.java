package mate.jdbc;

import java.util.List;
import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerDao manufacturerDao = (ManufacturerDao) injector
                .getInstance(ManufacturerDao.class);
        Manufacturer manufacturerSaab = new Manufacturer("SAAB", "Sweden");
        Manufacturer manufacturerJeep = new Manufacturer("Jeep", "USA");
        Manufacturer manufacturerRenault = new Manufacturer("Renault", "France");
        manufacturerDao.create(manufacturerSaab);
        manufacturerDao.create(manufacturerJeep);
        manufacturerDao.create(manufacturerRenault);

        List<Manufacturer> manufacturersCreateList = manufacturerDao.getAll();
        System.out.println("created table");
        for (Manufacturer manufacturer : manufacturersCreateList) {
            System.out.println(manufacturer.toString());
        }
        System.out.println(manufacturerDao.get(2L));
        manufacturerSaab.setName("Spyker");
        manufacturerDao.update(manufacturerSaab);
        manufacturerDao.delete(manufacturerRenault.getId());
        List<Manufacturer> manufacturersUpdateList = manufacturerDao.getAll();
        System.out.println("changed table");
        for (Manufacturer manufacturer : manufacturersUpdateList) {
            System.out.println(manufacturer.toString());
        }
    }
}
