package tests.api;

import org.aeonbits.owner.ConfigFactory;
import config.api.ApiConfig;
import helpers.DataGenerator;

public class TestData {
    static DataGenerator generator = new DataGenerator();
    static ApiConfig config = ConfigFactory.create(ApiConfig.class);

    public static final String
            projectNumber = config.projectNumber(),
            projectName = generator.getTaskName(),
            taskName = generator.getTaskDescription(),
            outdatedTaskName = generator.getStreetName(),
            updatedTaskName = generator.getStreetName(),
            removedProjectName = "Delete this";
}