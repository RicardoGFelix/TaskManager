import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerControllerTest {

    private TaskManagerController taskManagerController;

    @BeforeEach
    public void newTaskManagerController() {
        taskManagerController = new TaskManagerController();
        Date dateTask1 = new Date(2023, 8, 20);
        taskManagerController.createTask("Finalizar exercício de V&V", "Preciso finalizar o exercício 2 de V&V para a validação do código", dateTask1, "Alta");
        Date dateTask2 = new Date(2023, 12, 30);
        taskManagerController.createTask("Estudar inglês", "Preciso estudar os tempos verbais em inglês", dateTask2, "Alta");
        Date dateTask3 = new Date(2023, 8, 30);
        taskManagerController.createTask("Comprar presente para o meu pai", "Preciso comprar o presente de aniversário do meu pai", dateTask3, "Média");
    }

    @Test
    public void testCreateTask() {
        Date dateTask = new Date(2023, 9, 9);
        assertEquals(3, taskManagerController.createTask("Pagar fatura", "Pagar fatura do cartão de crédito", dateTask, "Baixa"));
    }

    @Test
    public void testUpdateTitleTask() {
        assertEquals("Estudar estrutura das frases", taskManagerController.updateTitleTask(1, "Estudar estrutura das frases"));
    }

    @Test
    public void testUpdateDescriptionTask() {
        assertEquals("Preciso estudar a estrutura das frases em inglês", taskManagerController.updateDescriptionTask(1, "Preciso estudar a estrutura das frases em inglês"));
    }

    @Test
    public void testUpdateDateTask() {
        Date dateTask = new Date(2024, 5, 30);
        assertEquals(dateTask, taskManagerController.updateDateTask(1, dateTask));
    }

    @Test
    public void testUpdatePriorityTask() {
        assertEquals("Média", taskManagerController.updatePriorityTask(1, "Média"));
    }

    @Test
    public void testRemoveTask() {
        Date dateTask = new Date(2023, 8, 20);
        Task task = new Task("Finalizar exercício de V&V", "Preciso finalizar o exercício 2 de V&V para a validação do código", dateTask, "Alta");

        taskManagerController.removeTask("Finalizar exercício de V&V", "Preciso finalizar o exercício 2 de V&V para a validação do código", dateTask, "Alta");

        assertFalse(taskManagerController.getTasks().contains(task));
    }

    @Test
    public void testGetTasks() {
        assertNotNull(taskManagerController.getTasks());
    }
}
