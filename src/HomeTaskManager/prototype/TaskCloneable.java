package HomeTaskManager.prototype;


public class TaskCloneable implements Task {
    private String name;
    private int duration;

    public TaskCloneable(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public Task cloneTask() {
        return new TaskCloneable(this.name, this.duration);
    }

    @Override
    public String toString() {
        return "Tarea: " + name + " - Duración: " + duration + " minutos";
    }
}
