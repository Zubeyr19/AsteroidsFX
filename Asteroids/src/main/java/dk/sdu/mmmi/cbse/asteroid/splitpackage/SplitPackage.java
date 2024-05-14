package dk.sdu.mmmi.cbse.asteroid.splitpackage;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class SplitPackage implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        System.out.println("Hello World! From Asteroids");
    }

    @Override
    public void postProcess(GameData gameData, World world) {

    }
}