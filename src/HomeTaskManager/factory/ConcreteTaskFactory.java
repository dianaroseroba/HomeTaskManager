package HomeTaskManager.factory;

import HomeTaskManager.prototype.Task;
import HomeTaskManager.prototype.TaskCloneable;

public class ConcreteTaskFactory extends TaskFactory {

    @Override
    public Task createTask(String type) {
        switch (type) {
            case "Lavar platos":
                return new TaskCloneable("Lavar platos", 20);
            case "Hacer la cama":
                return new TaskCloneable("Hacer la cama", 10);
            case "Regar plantas":
                return new TaskCloneable("Regar plantas", 15);
            default:
                throw new IllegalArgumentException("Tipo de tarea no soportado.");
        }
    }
}
