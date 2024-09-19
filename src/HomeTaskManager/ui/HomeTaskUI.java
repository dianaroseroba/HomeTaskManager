package HomeTaskManager.ui;


import HomeTaskManager.factory.ConcreteTaskFactory;
import HomeTaskManager.prototype.Task;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeTaskUI extends JFrame {
    private ConcreteTaskFactory taskFactory;
    private DefaultListModel<Task> taskListModel;

    public HomeTaskUI() {
        taskFactory = new ConcreteTaskFactory();
        taskListModel = new DefaultListModel<>();

        setTitle("Gestión de Tareas del Hogar");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Lista de tareas
        JList<Task> taskList = new JList<>(taskListModel);
        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Botones
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Agregar tarea");
        JButton cloneButton = new JButton("Duplicar tarea");
        buttonPanel.add(addButton);
        buttonPanel.add(cloneButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Acciones de los botones
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] taskTypes = {"Lavar platos", "Hacer la cama", "Regar plantas"};
                String selectedType = (String) JOptionPane.showInputDialog(
                        null, "Selecciona una tarea", "Agregar Tarea",
                        JOptionPane.QUESTION_MESSAGE, null, taskTypes, taskTypes[0]);

                if (selectedType != null) {
                    Task newTask = taskFactory.createTask(selectedType);
                    taskListModel.addElement(newTask);
                }
            }
        });

        cloneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Task selectedTask = taskList.getSelectedValue();
                if (selectedTask != null) {
                    Task clonedTask = selectedTask.cloneTask();
                    taskListModel.addElement(clonedTask);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una tarea para duplicar.");
                }
            }
        });

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeTaskUI app = new HomeTaskUI();
            app.setVisible(true);
        });
    }
}
