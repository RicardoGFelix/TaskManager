import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerControllerTest {

    private TaskManagerController taskManagerController;

    @BeforeEach
    public void newTaskManagerController() {
        taskManagerController = new TaskManagerController();
        taskManagerController.createTask("Comprar monitor", "Comprar monitor para usar com meu notebook", "30/06/2024", "Baixa");
        taskManagerController.createTask("Estudar inglês", "Preciso estudar os tempos verbais em inglês", "30/12/2023", "Alta");
        taskManagerController.createTask("Finalizar exercício de V&V", "Preciso finalizar o exercício 2 de V&V para a validação do código", "20/08/2023", "Alta");
        taskManagerController.createTask("Comprar presente para o meu pai", "Preciso comprar o presente de aniversário do meu pai", "30/08/2023", "Média");
    }

    @Test
    public void testCreateTask() {
        assertEquals(4, taskManagerController.createTask("Pagar fatura", "Pagar fatura do cartão de crédito", "09/09/2023", "Baixa"));
    }

    @Test
    public void testUpdateTitleTask() throws Exception {
        assertEquals("Estudar estrutura das frases", taskManagerController.updateTitleTask(1, "Estudar estrutura das frases"));
    }

    @Test
    public void testUpdateDescriptionTask() throws Exception {
        assertEquals("Preciso estudar a estrutura das frases em inglês", taskManagerController.updateDescriptionTask(1, "Preciso estudar a estrutura das frases em inglês"));
    }

    @Test
    public void testUpdateDateTask() throws Exception {
        assertEquals("30/05/2024", taskManagerController.updateDateTask(1, "30/05/2024"));
    }

    @Test
    public void testUpdatePriorityTask() throws Exception {
        assertEquals("Média", taskManagerController.updatePriorityTask(1, "Média"));
    }

    @Test
    public void testRemoveTask() throws Exception {
        LocalDate dateTask = LocalDate.parse("20/08/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Task task = new Task("Finalizar exercício de V&V", "Preciso finalizar o exercício 2 de V&V para a validação do código", dateTask, "Alta");

        taskManagerController.removeTask("Finalizar exercício de V&V", "Preciso finalizar o exercício 2 de V&V para a validação do código", "20/08/2023", "Alta");

        assertFalse(taskManagerController.getTasks().contains(task));
    }

    @Test
    public void testGetTasks() {
        assertNotNull(taskManagerController.getTasks());
    }

    @Test
    public void testGetSortedTasks() throws Exception {
        String sortedTasks = "Finalizar exercício de V&V - " + "Preciso finalizar o exercício 2 de V&V para a validação do código - " + "20/08/2023 - " + "Alta\n" +
                "Estudar inglês - " + "Preciso estudar os tempos verbais em inglês - " + "30/12/2023 - " + "Alta\n" +
                "Comprar presente para o meu pai - " + "Preciso comprar o presente de aniversário do meu pai - " + "30/08/2023 - " + "Média\n" +
                "Comprar monitor - " + "Comprar monitor para usar com meu notebook - " + "30/06/2024 - " + "Baixa\n";

        assertEquals(sortedTasks, taskManagerController.getSortedTasks());
    }
}
